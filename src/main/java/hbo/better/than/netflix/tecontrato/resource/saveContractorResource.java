package hbo.better.than.netflix.tecontrato.resource;

public class saveContractorResource extends saveUserResource {
    private String Tbio;
    private String Neducation;
    private String Numphone;

    public saveContractorResource() {
        super();
    }

    public saveContractorResource(String nuser, String cpassword, String tmail, Integer cdni, String nname, String nlastname, Integer isAdmin, String tbio, String neducation, String numphone) {
        super(nuser, cpassword, tmail, cdni, nname, nlastname, isAdmin);
        Tbio = tbio;
        Neducation = neducation;
        Numphone = numphone;
    }

    public String getTbio() {
        return Tbio;
    }

    public saveContractorResource setTbio(String tbio) {
        Tbio = tbio;
        return this;
    }

    public String getNeducation() {
        return Neducation;
    }

    public saveContractorResource setNeducation(String neducation) {
        Neducation = neducation;
        return this;
    }

    public String getNumphone() {
        return Numphone;
    }

    public saveContractorResource setNumphone(String numphone) {
        Numphone = numphone;
        return this;
    }
}
