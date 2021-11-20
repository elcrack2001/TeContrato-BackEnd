package hbo.better.than.netflix.tecontrato.resource;

public class employeesResource {
    public Integer getCemployee() {
        return Cemployee;
    }

    public employeesResource setCemployee(Integer cemployee) {
        Cemployee = cemployee;
        return this;
    }

    public String getNemployee() {
        return Nemployee;
    }

    public employeesResource setNemployee(String nemployee) {
        Nemployee = nemployee;
        return this;
    }

    public String getTposition() {
        return Tposition;
    }

    public employeesResource setTposition(String tposition) {
        Tposition = tposition;
        return this;
    }

    public Integer getMpayment() {
        return Mpayment;
    }

    public employeesResource setMpayment(Integer mpayment) {
        Mpayment = mpayment;
        return this;
    }

    public String getTworks() {
        return Tworks;
    }

    public employeesResource setTworks(String tworks) {
        Tworks = tworks;
        return this;
    }

    private Integer Cemployee;
    private String Nemployee;
    private String Tposition;
    private Integer Mpayment;
    private String Tworks;
}
