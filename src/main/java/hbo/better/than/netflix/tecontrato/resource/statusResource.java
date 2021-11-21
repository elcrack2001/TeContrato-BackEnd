package hbo.better.than.netflix.tecontrato.resource;

public class statusResource {
    private Integer Cstatus;
    private String Nstatus;

    public statusResource() {
    }

    public statusResource(Integer cstatus, String nstatus) {
        Cstatus = cstatus;
        Nstatus = nstatus;
    }

    public Integer getCstatus() {
        return Cstatus;
    }

    public statusResource setCstatus(Integer cstatus) {
        Cstatus = cstatus;
        return this;
    }

    public String getNstatus() {
        return Nstatus;
    }

    public statusResource setNstatus(String nstatus) {
        Nstatus = nstatus;
        return this;
    }
}
