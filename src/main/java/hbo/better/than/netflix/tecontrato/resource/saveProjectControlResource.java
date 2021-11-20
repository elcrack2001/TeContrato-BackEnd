package hbo.better.than.netflix.tecontrato.resource;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class saveProjectControlResource {

    private String Nproyect;
    private String Fstatus;
    @DateTimeFormat
    private LocalDate Dlastedited;
    private String Ttasks;
    private Integer Qemployees;
    private Integer Mbudget;
    private Integer Qprogress;

    public String getNproyect() {
        return Nproyect;
    }

    public saveProjectControlResource setNproyect(String nproyect) {
        Nproyect = nproyect;
        return this;
    }

    public String getFstatus() {
        return Fstatus;
    }

    public saveProjectControlResource setFstatus(String fstatus) {
        Fstatus = fstatus;
        return this;
    }

    public LocalDate getDlastedited() {
        return Dlastedited;
    }

    public saveProjectControlResource setDlastedited(LocalDate dlastedited) {
        Dlastedited = dlastedited;
        return this;
    }

    public String getTtasks() {
        return Ttasks;
    }

    public saveProjectControlResource setTtasks(String ttasks) {
        Ttasks = ttasks;
        return this;
    }

    public Integer getQemployees() {
        return Qemployees;
    }

    public saveProjectControlResource setQemployees(Integer qemployees) {
        Qemployees = qemployees;
        return this;
    }

    public Integer getMbudget() {
        return Mbudget;
    }

    public saveProjectControlResource setMbudget(Integer mbudget) {
        Mbudget = mbudget;
        return this;
    }

    public Integer getQprogress() {
        return Qprogress;
    }

    public saveProjectControlResource setQprogress(Integer qprogress) {
        Qprogress = qprogress;
        return this;
    }
}
