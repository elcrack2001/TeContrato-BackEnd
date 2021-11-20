package hbo.better.than.netflix.tecontrato.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class user extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cuser")
    private Integer Cuser;

    @NotNull
    @Size(max = 100)
    private String Nuser;

    @NotNull
    @Size(max = 100)
    private String Cpassword;

    @NotNull
    @Size(max = 200)
    private String Tmail;

    @NotNull
    private Integer Cdni;

    @NotNull
    private String Nname;

    @NotNull
    private String Nlastname;

    @NotNull
    private Integer isAdmin;

    public user() {
        super();
    }

    public user(Integer cuser, @NotNull String nuser, @NotNull String cpassword, @NotNull String tmail, @NotNull Integer cdni, @NotNull String nname, @NotNull String nlastname, Integer isAdmin) {
        super();
        Cuser = cuser;
        Nuser = nuser;
        Cpassword = cpassword;
        Tmail = tmail;
        Cdni = cdni;
        Nname = nname;
        Nlastname = nlastname;
        this.isAdmin = isAdmin;
    }

    public Integer getCuser() {
        return Cuser;
    }

    public user setCuser(Integer cuser) {
        Cuser = cuser;
        return this;
    }

    public String getNuser() {
        return Nuser;
    }

    public user setNuser(String nuser) {
        Nuser = nuser;
        return this;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public user setCpassword(String cpassword) {
        Cpassword = cpassword;
        return this;
    }

    public String getTmail() {
        return Tmail;
    }

    public user setTmail(String tmail) {
        Tmail = tmail;
        return this;
    }

    public Integer getCdni() {
        return Cdni;
    }

    public user setCdni(Integer cdni) {
        Cdni = cdni;
        return this;
    }

    public String getNname() {
        return Nname;
    }

    public user setNname(String nname) {
        Nname = nname;
        return this;
    }

    public String getNlastname() {
        return Nlastname;
    }

    public user setNlastname(String nlastname) {
        Nlastname = nlastname;
        return this;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public user setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }
}
