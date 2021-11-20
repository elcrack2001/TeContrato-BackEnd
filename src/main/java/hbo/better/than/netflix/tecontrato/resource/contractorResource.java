package hbo.better.than.netflix.tecontrato.resource;

public class contractorResource extends userResource{
    private String Tbio;
    private String Neducation;
    private String Numphone;

    public contractorResource() {
        super();
    }

    public contractorResource(Integer cuser, String nuser, String cpassword, String tmail, Integer cdni, String nname, String nlastname, Integer isAdmin, String tbio, String neducation, String numphone) {
        super(cuser, nuser, cpassword, tmail, cdni, nname, nlastname, isAdmin);
        Tbio = tbio;
        Neducation = neducation;
        Numphone = numphone;
    }
}
