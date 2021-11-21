package hbo.better.than.netflix.tecontrato.resource;

public class saveTaskResource {
    private String Ntask;

    public saveTaskResource() {
    }

    public saveTaskResource(String ntask) {
        Ntask = ntask;
    }

    public String getNtask() {
        return Ntask;
    }

    public saveTaskResource setNtask(String ntask) {
        Ntask = ntask;
        return this;
    }
}
