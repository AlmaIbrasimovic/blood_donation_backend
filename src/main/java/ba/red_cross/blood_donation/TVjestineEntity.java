package ba.red_cross.blood_donation;

import javax.persistence.*;

@Entity
@Table(name = "T_VJESTINE", schema = "dbo", catalog = "ck_db")
public class TVjestineEntity {
    private String vjestina;
    private String naziv;
    private boolean vazi;

    @Id
    @Column(name = "VJESTINA")
    public String getVjestina() {
        return vjestina;
    }

    public void setVjestina(String vjestina) {
        this.vjestina = vjestina;
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

        TVjestineEntity that = (TVjestineEntity) o;

        if (vazi != that.vazi) return false;
        if (vjestina != null ? !vjestina.equals(that.vjestina) : that.vjestina != null) return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vjestina != null ? vjestina.hashCode() : 0;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (vazi ? 1 : 0);
        return result;
    }
}
