package hbo.better.than.netflix.tecontrato.resource;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class saveProjectResource {
    private String Nproject;
    @DateTimeFormat
    private LocalDate create_at;
    private String Tdescription;
    private String Fstatus;
    private Integer Mbudget;

    public String getNproject() {
        return Nproject;
    }

    public saveProjectResource setNproject(String nproject) {
        Nproject = nproject;
        return this;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public saveProjectResource setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
        return this;
    }

    public String getTdescription() {
        return Tdescription;
    }

    public saveProjectResource setTdescription(String tdescription) {
        Tdescription = tdescription;
        return this;
    }

    public String getFstatus() {
        return Fstatus;
    }

    public saveProjectResource setFstatus(String fstatus) {
        Fstatus = fstatus;
        return this;
    }

    public Integer getMbudget() {
        return Mbudget;
    }

    public saveProjectResource setMbudget(Integer mbudget) {
        Mbudget = mbudget;
        return this;
    }
}
