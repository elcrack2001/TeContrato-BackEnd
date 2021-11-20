package hbo.better.than.netflix.tecontrato.resource;

public class clientResource extends userResource {
    private String Tbio;
    private String Tadress;

    public clientResource() {
        super();
    }

    public clientResource(Integer cuser, String nuser, String cpassword, String tmail, Integer cdni, String nname, String nlastname, Integer isAdmin, String tbio, String tadress) {
        super(cuser, nuser, cpassword, tmail, cdni, nname, nlastname, isAdmin);
        Tbio = tbio;
        Tadress = tadress;
    }

    public String getTbio() {
        return Tbio;
    }

    public clientResource setTbio(String tbio) {
        Tbio = tbio;
        return this;
    }

    public String getTadress() {
        return Tadress;
    }

    public clientResource setTadress(String tadress) {
        Tadress = tadress;
        return this;
    }
}
