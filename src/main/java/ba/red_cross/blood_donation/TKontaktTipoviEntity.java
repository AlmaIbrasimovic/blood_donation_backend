package ba.red_cross.blood_donation;

import javax.persistence.*;

@Entity
@Table(name = "T_KONTAKT_TIPOVI", schema = "dbo", catalog = "ck_db")
@IdClass(TKontaktTipoviEntityPK.class)
public class TKontaktTipoviEntity {
    private int kontaktId;
    private String tipKontakta;

    @Id
    @Column(name = "KONTAKT_ID")
    public int getKontaktId() {
        return kontaktId;
    }

    public void setKontaktId(int kontaktId) {
        this.kontaktId = kontaktId;
    }

    @Id
    @Column(name = "TIP_KONTAKTA")
    public String getTipKontakta() {
        return tipKontakta;
    }

    public void setTipKontakta(String tipKontakta) {
        this.tipKontakta = tipKontakta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TKontaktTipoviEntity that = (TKontaktTipoviEntity) o;

        if (kontaktId != that.kontaktId) return false;
        if (tipKontakta != null ? !tipKontakta.equals(that.tipKontakta) : that.tipKontakta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kontaktId;
        result = 31 * result + (tipKontakta != null ? tipKontakta.hashCode() : 0);
        return result;
    }
}
