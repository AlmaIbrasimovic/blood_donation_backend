package ba.red_cross.blood_donation;

import ba.red_cross.blood_donation.model.*;
import ba.red_cross.blood_donation.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BloodDonationApplication {

    private static final Logger log =
            LoggerFactory.getLogger(BloodDonationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationApplication.class, args);
    }

    @Bean
    public CommandLineRunner addDataToDatabase(KorisnikRepository korisnikRepository, TransfuzijskiCentarRepository transCentarRepo, RolaRepository rolaRepo, AkcijeDarivanjaKrviRepository akcijaDarivanjaRepo, NotifikacijaRepository notifikacijaRepo) {
        return (args) -> {
          /*  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Rola admin = rolaRepo.save(new Rola("administrator"));
            Rola korisnik = rolaRepo.save(new Rola("korisnik"));
            LocalDate datumKreiranjaRacuna = LocalDate.now();
            LocalDate datumRodenja = LocalDate.of(1996, 10, 23);
            Korisnik user = new Korisnik("Alma", "Ibrašimović", "alma_96", "Z", datumRodenja, "Zenica","Novi Travnik", "Stjepana Radića 18/15", "SBK", "061718733", "SW dev", "0+", 5, "almaibrasimovic96@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, admin);
          //  user.getAkcijeDarivanja().add(akcijaDarivanja);
            korisnikRepository.save(user);

            datumKreiranjaRacuna = LocalDate.of(2021, 10, 23);
            datumRodenja = LocalDate.of(1958, 6, 25);
            Korisnik user1 = (new Korisnik("Jasmina", "Ibrašimović", "jasmina_58", "Z", datumRodenja, "Bosanski Petrovac","Novi Travnik", "Stjepana Radića 18/15", "SBK", "063836791", "Profesor", "A+", 5, "jasmina@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
           // user1.getAkcijeDarivanja().add(akcijaDarivanja);
            korisnikRepository.save(user1);

            datumKreiranjaRacuna = LocalDate.of(2021, 10, 23);
            datumRodenja = LocalDate.of(1993, 10, 28);
            Korisnik user2 = (new Korisnik("Belma", "Ibrašimović", "belma_93", "Z", datumRodenja, "Zenica","Sarajevo", "Paromlinska 5", "KS", "063836790", "Dev", "B+", 5, "belma@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
           // user2.getAkcijeDarivanja().add(akcijaDarivanja1);
            korisnikRepository.save(user2);

            datumKreiranjaRacuna = LocalDate.of(2021, 12, 23);
            datumRodenja = LocalDate.of(1993, 10, 28);
            Korisnik user3 = (new Korisnik("Šefik", "Ibrašimović", "sefik", "Z", datumRodenja, "Zenica","Sarajevo", "Paromlinska 5", "KS", "063836790", "Dev", "B+", 5, "belma@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
         //   user3.getAkcijeDarivanja().add(akcijaDarivanja2);
            korisnikRepository.save(user3);
         /*   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            // Kreiranje rola
            Rola admin = rolaRepo.save(new Rola("administrator"));
            Rola korisnik = rolaRepo.save(new Rola("korisnik"));

            // Kreiranje akcija darivanja krvi
            AkcijaDarivanjaKrvi akcijaDarivanja = new AkcijaDarivanjaKrvi("Paromlinska 3", "Sarajevo", LocalDate.of(2021, 9, 23), LocalTime.of(9, 0, 0), LocalTime.of(11, 30, 0), "Akcija darivanja krvi u Sarajevu");
            akcijaDarivanjaRepo.save(akcijaDarivanja);
            AkcijaDarivanjaKrvi akcijaDarivanja1 = new AkcijaDarivanjaKrvi("Hujići 4", "Zenica", LocalDate.now(), LocalTime.now(), LocalTime.now(), "Akcija darivanja krvi u Zenici");
            akcijaDarivanjaRepo.save(akcijaDarivanja1);
            AkcijaDarivanjaKrvi akcijaDarivanja2 = new AkcijaDarivanjaKrvi("Stjepana Radića 18/15", "Novi Travnik", LocalDate.of(2021, 7, 23), LocalTime.of(15, 0, 0), LocalTime.of(17, 30, 0), "Akcija darivanja krvi u Novom Travniku");
            akcijaDarivanjaRepo.save(akcijaDarivanja2);
            AkcijaDarivanjaKrvi akcijaDarivanja3 = new AkcijaDarivanjaKrvi("Nerkeza Smailagića 15", "Bihać", LocalDate.of(2021, 8, 10), LocalTime.of(10, 0, 0), LocalTime.of(15, 0, 0), "Akcija darivanja krvi u Bihaću");
            akcijaDarivanjaRepo.save(akcijaDarivanja3);
            AkcijaDarivanjaKrvi akcijaDarivanja4 = new AkcijaDarivanjaKrvi("Titova", "Banja Luka", LocalDate.of(2021, 8, 17), LocalTime.of(16, 0, 0), LocalTime.of(20, 0, 0), "Akcija darivanja krvi u Banja Luci");
            akcijaDarivanjaRepo.save(akcijaDarivanja4);
            // Kreiranje korisnika
            LocalDate datumKreiranjaRacuna = LocalDate.now();
            LocalDate datumRodenja = LocalDate.of(1996, 10, 23);
            Korisnik user = new Korisnik("Alma", "Ibrašimović", "alma_96", "Z", datumRodenja, "Zenica","Novi Travnik", "Stjepana Radića 18/15", "SBK", "061718733", "SW dev", "0+", 5, "almaibrasimovic96@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, admin);
            user.getAkcijeDarivanja().add(akcijaDarivanja);
            korisnikRepository.save(user);

            datumKreiranjaRacuna = LocalDate.of(2021, 10, 23);
            datumRodenja = LocalDate.of(1958, 6, 25);
            Korisnik user1 = (new Korisnik("Jasmina", "Ibrašimović", "jasmina_58", "Z", datumRodenja, "Bosanski Petrovac","Novi Travnik", "Stjepana Radića 18/15", "SBK", "063836791", "Profesor", "A+", 5, "jasmina@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
            user1.getAkcijeDarivanja().add(akcijaDarivanja);
            korisnikRepository.save(user1);

            datumKreiranjaRacuna = LocalDate.of(2021, 10, 23);
            datumRodenja = LocalDate.of(1993, 10, 28);
            Korisnik user2 = (new Korisnik("Belma", "Ibrašimović", "belma_93", "Z", datumRodenja, "Zenica","Sarajevo", "Paromlinska 5", "KS", "063836790", "Dev", "B+", 5, "belma@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
            user2.getAkcijeDarivanja().add(akcijaDarivanja1);
            korisnikRepository.save(user2);

            datumKreiranjaRacuna = LocalDate.of(2021, 12, 23);
            datumRodenja = LocalDate.of(1993, 10, 28);
            Korisnik user3 = (new Korisnik("Šefik", "Ibrašimović", "sefik", "Z", datumRodenja, "Zenica","Sarajevo", "Paromlinska 5", "KS", "063836790", "Dev", "B+", 5, "belma@gmail.com", passwordEncoder.encode("proba123"), false, datumKreiranjaRacuna, korisnik));
            user3.getAkcijeDarivanja().add(akcijaDarivanja2);
            korisnikRepository.save(user3);

            // Kreiranje transfuzijskih centara
            transCentarRepo.save (new TransfuzijskiCentar("Novi Travnik", "Stjepana Radića 18/15", "061718733"));

            // Kreiranje notifikacija
            notifikacijaRepo.save (new Notifikacija("Hitno potrebna krvna grupa 0+", "Hitno potrebna krvna grupa 0+", "HITNO", "0+"));

            log.info("Podaci uspjesno upisani u db!");*/
        };

    }
}
