package hbo.better.than.netflix.tecontrato.resource;

import javax.validation.constraints.NotNull;

public class cityResource {
    private Integer Ccity;
    private String Ncity;

    public cityResource() {
    }

    public cityResource(Integer ccity, String ncity) {
        Ccity = ccity;
        Ncity = ncity;
    }

    public Integer getCcity() {
        return Ccity;
    }

    public cityResource setCcity(Integer ccity) {
        Ccity = ccity;
        return this;
    }

    public String getNcity() {
        return Ncity;
    }

    public cityResource setNcity(String ncity) {
        Ncity = ncity;
        return this;
    }
}
