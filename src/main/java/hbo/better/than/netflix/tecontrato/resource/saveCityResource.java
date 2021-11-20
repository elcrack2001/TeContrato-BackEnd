package hbo.better.than.netflix.tecontrato.resource;

public class saveCityResource {
    private String Ncity;

    public saveCityResource() {
    }

    public saveCityResource(String ncity) {
        Ncity = ncity;
    }

    public String getNcity() {
        return Ncity;
    }

    public saveCityResource setNcity(String ncity) {
        Ncity = ncity;
        return this;
    }
}
