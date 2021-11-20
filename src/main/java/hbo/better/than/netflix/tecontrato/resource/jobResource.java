package hbo.better.than.netflix.tecontrato.resource;

public class jobResource {
    private Integer Cjob;
    private String Njob;
    private String Tdescripcion;

    public Integer getCjob() {
        return Cjob;
    }

    public jobResource setCjob(Integer cjob) {
        Cjob = cjob;
        return this;
    }

    public String getNjob() {
        return Njob;
    }

    public jobResource setNjob(String njob) {
        Njob = njob;
        return this;
    }

    public String getTdescripcion() {
        return Tdescripcion;
    }

    public jobResource setTdescripcion(String tdescripcion) {
        Tdescripcion = tdescripcion;
        return this;
    }
}
