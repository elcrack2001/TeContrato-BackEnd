package hbo.better.than.netflix.tecontrato.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="cuser")
@OnDelete(action = OnDeleteAction.CASCADE)
@Table(name = "clients")
public class client extends user{
    private String Tbio;
    private String Tadress;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private city city;

    public client() { super();}

    public client(Integer cuser, String nuser, String cpassword, String tmail, Integer cdni, String nname, String nlastname, Integer isAdmin, String tbio, String tadress, city city) {
        super(cuser, nuser, cpassword, tmail, cdni, nname, nlastname, isAdmin);
        Tbio = tbio;
        Tadress = tadress;
        this.city = city;
    }

    public String getTbio() {
        return Tbio;
    }

    public client setTbio(String tbio) {
        Tbio = tbio;
        return this;
    }

    public String getTadress() {
        return Tadress;
    }

    public client setTadress(String tadress) {
        Tadress = tadress;
        return this;
    }

    public city getCity() {
        return city;
    }

    public client setCity(city city) {
        this.city = city;
        return this;
    }
}
