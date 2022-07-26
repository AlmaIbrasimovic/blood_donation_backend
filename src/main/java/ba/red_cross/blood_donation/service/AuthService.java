package ba.red_cross.blood_donation.service;


import ba.red_cross.blood_donation.DTO.LoginRequest;
import ba.red_cross.blood_donation.DTO.LoginResponse;
import ba.red_cross.blood_donation.model.dto.ValidationRequest;
import ba.red_cross.blood_donation.model.dto.ValidationResponse;
import ba.red_cross.blood_donation.security.CustomUserDetails;
import ba.red_cross.blood_donation.security.JwtUtil;
import ba.red_cross.blood_donation.security.UserDetailsService;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    private final String SECRET_KEY = "SECRET";

    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
                                 UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }


    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        catch (Exception e) {
            throw e;
        }

        final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        return generateTokens(userDetails);
    }

    private LoginResponse generateTokens(CustomUserDetails userDetails) {
        final String token = JwtUtil.generateToken(userDetails, SECRET_KEY, false);
        final String refreshToken = JwtUtil.generateToken(userDetails, SECRET_KEY, true);

        return new LoginResponse(userDetails.getUserId(), token, refreshToken);
    }

    public LoginResponse refresh(LoginResponse authenticationDto) throws Exception {

        String refreshToken = authenticationDto.getRefreshToken();

        String username = JwtUtil.extractUsername(refreshToken, SECRET_KEY);

        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if(!JwtUtil.validateToken(refreshToken, userDetails, SECRET_KEY)) {
            throw new Exception("Invalid refreshToken");
        }

        return generateTokens(userDetails);
    }

    public ValidationResponse validate(ValidationRequest validationRequest) {
        try {
            String username = JwtUtil.extractUsername(validationRequest.getToken(), SECRET_KEY);
            final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

            return new ValidationResponse(JwtUtil.validateToken(validationRequest.getToken(), userDetails, SECRET_KEY),
                    userDetails.getUsername(),
                    userDetails.getPassword(),
                    userDetails.getAuthorities().stream().findFirst().get().getAuthority());
        }
        catch (JwtException e) {
            return new ValidationResponse(false);
        }
    }
}
