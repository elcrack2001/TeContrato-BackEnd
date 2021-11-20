package hbo.better.than.netflix.tecontrato.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="cuser")
@OnDelete(action = OnDeleteAction.CASCADE)
@Table(name = "contractors")
public class contractor extends user {
    private String Tbio;
    private String Neducation;
    private String Numphone;

    public contractor() { super(); }

    public contractor(Integer cuser, @NotNull String nuser, @NotNull String cpassword, @NotNull String tmail, @NotNull Integer cdni, @NotNull String nname, @NotNull String nlastname, Integer isAdmin ,String tbio, String neducation, String numphone) {
        super(cuser, nuser, cpassword, tmail, cdni, nname, nlastname, isAdmin);
        Tbio = tbio;
        Neducation = neducation;
        Numphone = numphone;
    }

    public String getTbio() {
        return Tbio;
    }

    public contractor setTbio(String tbio) {
        Tbio = tbio;
        return this;
    }

    public String getNeducation() {
        return Neducation;
    }

    public contractor setNeducation(String neducation) {
        Neducation = neducation;
        return this;
    }

    public String getNumphone() {
        return Numphone;
    }

    public contractor setNumphone(String numphone) {
        Numphone = numphone;
        return this;
    }
}
