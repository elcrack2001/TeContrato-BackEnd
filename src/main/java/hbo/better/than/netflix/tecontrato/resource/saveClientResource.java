package hbo.better.than.netflix.tecontrato.resource;

public class saveClientResource extends saveUserResource{
    private String Tbio;
    private String Tadress;

    public saveClientResource() {
        super();
    }

    public saveClientResource(String nuser, String cpassword, String tmail, Integer cdni, String nname, String nlastname, Integer isAdmin, String tbio, String tadress) {
        super(nuser, cpassword, tmail, cdni, nname, nlastname, isAdmin);
        Tbio = tbio;
        Tadress = tadress;
    }

    public String getTbio() {
        return Tbio;
    }

    public saveClientResource setTbio(String tbio) {
        Tbio = tbio;
        return this;
    }

    public String getTadress() {
        return Tadress;
    }

    public saveClientResource setTadress(String tadress) {
        Tadress = tadress;
        return this;
    }
}
