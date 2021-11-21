package hbo.better.than.netflix.tecontrato.resource;

public class saveStatusResource {
    private String Nstatus;

    public saveStatusResource() {
    }

    public saveStatusResource(String nstatus) {
        Nstatus = nstatus;
    }

    public String getNstatus() {
        return Nstatus;
    }

    public saveStatusResource setNstatus(String nstatus) {
        Nstatus = nstatus;
        return this;
    }
}
