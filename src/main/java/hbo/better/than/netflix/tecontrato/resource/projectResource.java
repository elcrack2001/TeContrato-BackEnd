package hbo.better.than.netflix.tecontrato.resource;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class projectResource {
    private Integer Cproyect;
    private String Nproject;
    @DateTimeFormat
    private LocalDate create_at;
    private String Tdescription;
    private String Fstatus;
    private Integer Mbudget;

    public Integer getCproyect() {
        return Cproyect;
    }

    public projectResource setCproyect(Integer cproyect) {
        Cproyect = cproyect;
        return this;
    }

    public String getNproject() {
        return Nproject;
    }

    public projectResource setNproject(String nproject) {
        Nproject = nproject;
        return this;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public projectResource setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
        return this;
    }

    public String getTdescription() {
        return Tdescription;
    }

    public projectResource setTdescription(String tdescription) {
        Tdescription = tdescription;
        return this;
    }

    public String getFstatus() {
        return Fstatus;
    }

    public projectResource setFstatus(String fstatus) {
        Fstatus = fstatus;
        return this;
    }

    public Integer getMbudget() {
        return Mbudget;
    }

    public projectResource setMbudget(Integer mbudget) {
        Mbudget = mbudget;
        return this;
    }
}
