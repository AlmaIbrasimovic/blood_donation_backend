package ba.red_cross.blood_donation.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank(message = "Ime korisnika ne može biti prazno!")
    private String ime;

    @NotBlank(message = "Prezime korisnika ne može biti prazno!")
    private String prezime;

    @NotBlank(message = "Ime jednog roditelja korisnika ne može biti prazno!")
    private String imeJednogRoditelja;

    @NotBlank(message = "Spol korisnika ne može biti prazno!")
    private String spol;

    @JsonFormat(pattern="DD-MM-YYYY")
    private LocalDate datumRodenja;

    @NotBlank(message = "Mjesto rođenja korisnika ne može biti prazno!")
    private String mjestoRodena;

    @NotBlank(message = "Mjesto prebivališta korisnika ne može biti prazno!")
    private String mjestoPrebivalista;

    @NotBlank(message = "Adresa prebivališta korisnika ne može biti prazno!")
    private String adresaPrebivalista;

    @NotBlank(message = "Kanton prebivališta korisnika ne može biti prazno!")
    private String kantonPrebivalista;

    @NotBlank(message = "Kontakt telefon korisnika ne može biti prazno!")
    private String kontaktTelefon;

    private String zanimanje;
    private String krvnaGrupa;
    private int brojDarivanjaKrvi;

    @NotBlank(message = "Email adresa ne može biti prazno!")
    private String emailAdresa;

    @NotBlank(message = "Lozinka ne može biti prazno!")
    private String lozinka;
    private Boolean slatiNotifikacije;

    @JsonFormat(pattern="DD-MM-YYYY")
    private LocalDate datumKreiranjaRacuna;

    // Veze između tabela

    // Rola 1-n
    @ManyToOne
    @JoinColumn(name = "rola_ID", referencedColumnName = "ID")
    private Rola rola;

    // Device 1-n
    @OneToMany(mappedBy="korisnik")
    private Set<Uredaj> uredaji;

    // Priznanja n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "korisnik_priznanje",
            joinColumns = {
                    @JoinColumn(name = "korisnik_ID", referencedColumnName = "ID", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "priznanje_ID", referencedColumnName = "ID", nullable = false, updatable = false)})
    private Set<Priznanje> priznanja = new HashSet<>();

    // Akcije darivanja n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "korisnik_akcije_darivanja",
            joinColumns = {
                    @JoinColumn(name = "korisnik_ID", referencedColumnName = "ID", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "akcijeDarivanjaKrvi_ID", referencedColumnName = "ID", nullable = false, updatable = false)})
    private Set<AkcijeDarivanjaKrvi> akcijeDarivanja = new HashSet<>();

    // Notifikacije n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "korisnik_notifikacije",
            joinColumns = {
                    @JoinColumn(name = "korisnik_ID", referencedColumnName = "ID", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "notifikacije_ID", referencedColumnName = "ID", nullable = false, updatable = false)})
    private Set<Notifikacija> notifikacije = new HashSet<>();

    public Korisnik(){}

    public Korisnik(String ime, String prezime, String imeJednogRoditelja, String spol, LocalDate datumRodenja,  String mjestoRodena,String mjestoPrebivalista, String adresaPrebivalista, String kantonPrebivalista, String kontaktTelefon, String zanimanje, String krvnaGrupa, int brojDarivanjaKrvi, String emailAdresa,String lozinka, Boolean slatiNotifikacije, LocalDate datumKreiranjaRacuna, Rola rola) {
        this.ime = ime;
        this.prezime = prezime;
        this.imeJednogRoditelja = imeJednogRoditelja;
        this.spol = spol;
        this.datumRodenja = datumRodenja;
        this.mjestoRodena = mjestoRodena;
        this.mjestoPrebivalista = mjestoPrebivalista;
        this.adresaPrebivalista = adresaPrebivalista;
        this.kantonPrebivalista = kantonPrebivalista;
        this.kontaktTelefon = kontaktTelefon;
        this.zanimanje = zanimanje;
        this.krvnaGrupa = krvnaGrupa;
        this.brojDarivanjaKrvi = brojDarivanjaKrvi;
        this.emailAdresa = emailAdresa;
        this.lozinka = lozinka;
        this.slatiNotifikacije = slatiNotifikacije;
        this.datumKreiranjaRacuna = datumKreiranjaRacuna;
        this.rola = rola;
    }

    public Korisnik(String ime, String prezime, String imeJednogRoditelja, String spol, LocalDate datumRodenja, String mjestoRodena, String mjestoPrebivalista, String adresaPrebivalista, String kantonPrebivalista, String kontaktTelefon, String zanimanje, String krvnaGrupa, int brojDarivanjaKrvi, String emailAdresa, String lozinka, Boolean slatiNotifikacije, LocalDate datumKreiranjaRacuna) {
        this.ime = ime;
        this.prezime = prezime;
        this.imeJednogRoditelja = imeJednogRoditelja;
        this.spol = spol;
        this.datumRodenja = datumRodenja;
        this.mjestoRodena = mjestoRodena;
        this.mjestoPrebivalista = mjestoPrebivalista;
        this.adresaPrebivalista = adresaPrebivalista;
        this.kantonPrebivalista = kantonPrebivalista;
        this.kontaktTelefon = kontaktTelefon;
        this.zanimanje = zanimanje;
        this.krvnaGrupa = krvnaGrupa;
        this.brojDarivanjaKrvi = brojDarivanjaKrvi;
        this.emailAdresa = emailAdresa;
        this.lozinka = lozinka;
        this.slatiNotifikacije = slatiNotifikacije;
        this.datumKreiranjaRacuna = datumKreiranjaRacuna;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getImeJednogRoditelja() {
        return imeJednogRoditelja;
    }

    public void setImeJednogRoditelja(String imeJednogRoditelja) {
        this.imeJednogRoditelja = imeJednogRoditelja;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public LocalDate getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(LocalDate datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public String getMjestoRodena() {
        return mjestoRodena;
    }

    public void setMjestoRodena(String mjestoRodena) {
        this.mjestoRodena = mjestoRodena;
    }

    public String getMjestoPrebivalista() {
        return mjestoPrebivalista;
    }

    public void setMjestoPrebivalista(String mjestoPrebivalista) {
        this.mjestoPrebivalista = mjestoPrebivalista;
    }

    public String getAdresaPrebivalista() {
        return adresaPrebivalista;
    }

    public void setAdresaPrebivalista(String adresaPrebivalista) {
        this.adresaPrebivalista = adresaPrebivalista;
    }

    public String getKantonPrebivalista() {
        return kantonPrebivalista;
    }

    public void setKantonPrebivalista(String kantonPrebivalista) {
        this.kantonPrebivalista = kantonPrebivalista;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public String getKrvnaGrupa() {
        return krvnaGrupa;
    }

    public void setKrvnaGrupa(String krvnaGrupa) {
        this.krvnaGrupa = krvnaGrupa;
    }

    public int getBrojDarivanjaKrvi() {
        return brojDarivanjaKrvi;
    }

    public void setBrojDarivanjaKrvi(int brojDarivanjaKrvi) {
        this.brojDarivanjaKrvi = brojDarivanjaKrvi;
    }

    public String getEmailAdresa() {
        return emailAdresa;
    }

    public void setEmailAdresa(String emailAdresa) {
        this.emailAdresa = emailAdresa;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Boolean getSlatiNotifikacije() {
        return slatiNotifikacije;
    }

    public void setSlatiNotifikacije(Boolean slatiNotifikacije) {
        this.slatiNotifikacije = slatiNotifikacije;
    }

    public LocalDate getDatumKreiranjaRacuna() {
        return datumKreiranjaRacuna;
    }

    public void setDatumKreiranjaRacuna(LocalDate datumKreiranjaRacuna) {
        this.datumKreiranjaRacuna = datumKreiranjaRacuna;
    }

    public Rola getRola() {
        return rola;
    }

    public void setRola(Rola rola) {
        this.rola = rola;
    }

    public Set<Uredaj> getUredaji() {
        return uredaji;
    }

    public void setUredaji(Set<Uredaj> uredaji) {
        this.uredaji = uredaji;
    }

    public Set<Priznanje> getPriznanja() {
        return priznanja;
    }

    public void setPriznanja(Set<Priznanje> priznanja) {
        this.priznanja = priznanja;
    }

    public Set<AkcijeDarivanjaKrvi> getAkcijeDarivanja() {
        return akcijeDarivanja;
    }

    public void setAkcijeDarivanja(Set<AkcijeDarivanjaKrvi> akcijeDarivanja) {
        this.akcijeDarivanja = akcijeDarivanja;
    }

    public Set<Notifikacija> getNotifikacije() {
        return notifikacije;
    }

    public void setNotifikacije(Set<Notifikacija> notifikacije) {
        this.notifikacije = notifikacije;
    }
}