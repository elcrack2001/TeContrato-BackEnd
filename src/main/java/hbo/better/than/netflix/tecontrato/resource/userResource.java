package hbo.better.than.netflix.tecontrato.resource;

public class userResource {

    private Integer Cuser;
    private String Nuser;
    private String Cpassword;
    private String Tmail;
    private Integer Cdni;
    private String Nname;
    private String Nlastname;
    private Integer isAdmin;

    public userResource() { super();
    }

    public userResource(Integer cuser, String nuser, String cpassword, String tmail, Integer cdni, String nname, String nlastname, Integer isAdmin) {
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

    public userResource setCuser(Integer cuser) {
        Cuser = cuser;
        return this;
    }

    public String getNuser() {
        return Nuser;
    }

    public userResource setNuser(String nuser) {
        Nuser = nuser;
        return this;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public userResource setCpassword(String cpassword) {
        Cpassword = cpassword;
        return this;
    }

    public String getTmail() {
        return Tmail;
    }

    public userResource setTmail(String tmail) {
        Tmail = tmail;
        return this;
    }

    public Integer getCdni() {
        return Cdni;
    }

    public userResource setCdni(Integer cdni) {
        Cdni = cdni;
        return this;
    }

    public String getNname() {
        return Nname;
    }

    public userResource setNname(String nname) {
        Nname = nname;
        return this;
    }

    public String getNlastname() {
        return Nlastname;
    }

    public userResource setNlastname(String nlastname) {
        Nlastname = nlastname;
        return this;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public userResource setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }
}
