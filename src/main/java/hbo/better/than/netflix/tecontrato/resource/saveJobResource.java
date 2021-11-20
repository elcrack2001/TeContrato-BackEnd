package hbo.better.than.netflix.tecontrato.resource;

public class saveJobResource {
    private String Njob;
    private String Tdescripcion;

    public String getNjob() {
        return Njob;
    }

    public saveJobResource setNjob(String njob) {
        Njob = njob;
        return this;
    }

    public String getTdescripcion() {
        return Tdescripcion;
    }

    public saveJobResource setTdescripcion(String tdescripcion) {
        Tdescripcion = tdescripcion;
        return this;
    }
}
