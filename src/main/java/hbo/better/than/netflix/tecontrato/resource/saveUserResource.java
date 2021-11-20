package hbo.better.than.netflix.tecontrato.resource;

public class saveUserResource {
    private String Nuser;
    private String Cpassword;
    private String Tmail;
    private Integer Cdni;
    private String Nname;
    private String Nlastname;
    private Integer isAdmin;

    public saveUserResource() {
        super();
    }

    public saveUserResource(String nuser, String cpassword, String tmail, Integer cdni, String nname, String nlastname, Integer isAdmin) {
        super();
        Nuser = nuser;
        Cpassword = cpassword;
        Tmail = tmail;
        Cdni = cdni;
        Nname = nname;
        Nlastname = nlastname;
        this.isAdmin = isAdmin;
    }

    public String getNuser() {
        return Nuser;
    }

    public saveUserResource setNuser(String nuser) {
        Nuser = nuser;
        return this;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public saveUserResource setCpassword(String cpassword) {
        Cpassword = cpassword;
        return this;
    }

    public String getTmail() {
        return Tmail;
    }

    public saveUserResource setTmail(String tmail) {
        Tmail = tmail;
        return this;
    }

    public Integer getCdni() {
        return Cdni;
    }

    public saveUserResource setCdni(Integer cdni) {
        Cdni = cdni;
        return this;
    }

    public String getNname() {
        return Nname;
    }

    public saveUserResource setNname(String nname) {
        Nname = nname;
        return this;
    }

    public String getNlastname() {
        return Nlastname;
    }

    public saveUserResource setNlastname(String nlastname) {
        Nlastname = nlastname;
        return this;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public saveUserResource setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }
}
