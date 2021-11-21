package hbo.better.than.netflix.tecontrato.resource;

public class taskResource {
    private Integer Ctask;
    private String Ntask;

    public taskResource() {
    }

    public taskResource(Integer ctask, String ntask) {
        Ctask = ctask;
        Ntask = ntask;
    }

    public Integer getCtask() {
        return Ctask;
    }

    public taskResource setCtask(Integer ctask) {
        Ctask = ctask;
        return this;
    }

    public String getNtask() {
        return Ntask;
    }

    public taskResource setNtask(String ntask) {
        Ntask = ntask;
        return this;
    }
}
