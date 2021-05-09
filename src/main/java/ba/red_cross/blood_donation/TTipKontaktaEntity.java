package ba.red_cross.blood_donation;

import javax.persistence.*;

@Entity
@Table(name = "T_TIP_KONTAKTA", schema = "dbo", catalog = "ck_db")
public class TTipKontaktaEntity {
    private String tipKontakta;
    private String naziv;
    private boolean vazi;

    @Id
    @Column(name = "TIP_KONTAKTA")
    public String getTipKontakta() {
        return tipKontakta;
    }

    public void setTipKontakta(String tipKontakta) {
        this.tipKontakta = tipKontakta;
    }

    @Basic
    @Column(name = "NAZIV")
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Basic
    @Column(name = "VAZI")
    public boolean isVazi() {
        return vazi;
    }

    public void setVazi(boolean vazi) {
        this.vazi = vazi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TTipKontaktaEntity that = (TTipKontaktaEntity) o;

        if (vazi != that.vazi) return false;
        if (tipKontakta != null ? !tipKontakta.equals(that.tipKontakta) : that.tipKontakta != null) return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tipKontakta != null ? tipKontakta.hashCode() : 0;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
