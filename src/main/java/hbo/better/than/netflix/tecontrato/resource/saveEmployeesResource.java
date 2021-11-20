package hbo.better.than.netflix.tecontrato.resource;

public class saveEmployeesResource {
    private String Nemployee;
    private String Tposition;
    private Integer Mpayment;
    private String Tworks;

    public String getNemployee() {
        return Nemployee;
    }

    public saveEmployeesResource setNemployee(String nemployee) {
        Nemployee = nemployee;
        return this;
    }

    public String getTposition() {
        return Tposition;
    }

    public saveEmployeesResource setTposition(String tposition) {
        Tposition = tposition;
        return this;
    }

    public Integer getMpayment() {
        return Mpayment;
    }

    public saveEmployeesResource setMpayment(Integer mpayment) {
        Mpayment = mpayment;
        return this;
    }

    public String getTworks() {
        return Tworks;
    }

    public saveEmployeesResource setTworks(String tworks) {
        Tworks = tworks;
        return this;
    }
}
