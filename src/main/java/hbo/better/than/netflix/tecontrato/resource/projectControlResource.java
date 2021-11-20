package hbo.better.than.netflix.tecontrato.resource;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class projectControlResource {

    private Integer Ccontrol;
    private String Nproyect;
    private String Fstatus;
    @DateTimeFormat
    private LocalDate Dlastedited;
    private String Ttasks;
    private Integer Qemployees;
    private Integer Mbudget;
    private Integer Qprogress;

    public Integer getCcontrol() {
        return Ccontrol;
    }

    public projectControlResource setCcontrol(Integer ccontrol) {
        Ccontrol = ccontrol;
        return this;
    }

    public String getNproyect() {
        return Nproyect;
    }

    public projectControlResource setNproyect(String nproyect) {
        Nproyect = nproyect;
        return this;
    }

    public String getFstatus() {
        return Fstatus;
    }

    public projectControlResource setFstatus(String fstatus) {
        Fstatus = fstatus;
        return this;
    }

    public LocalDate getDlastedited() {
        return Dlastedited;
    }

    public projectControlResource setDlastedited(LocalDate dlastedited) {
        Dlastedited = dlastedited;
        return this;
    }

    public String getTtasks() {
        return Ttasks;
    }

    public projectControlResource setTtasks(String ttasks) {
        Ttasks = ttasks;
        return this;
    }

    public Integer getQemployees() {
        return Qemployees;
    }

    public projectControlResource setQemployees(Integer qemployees) {
        Qemployees = qemployees;
        return this;
    }

    public Integer getMbudget() {
        return Mbudget;
    }

    public projectControlResource setMbudget(Integer mbudget) {
        Mbudget = mbudget;
        return this;
    }

    public Integer getQprogress() {
        return Qprogress;
    }

    public projectControlResource setQprogress(Integer qprogress) {
        Qprogress = qprogress;
        return this;
    }
}
