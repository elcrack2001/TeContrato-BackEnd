package hbo.better.than.netflix.tecontrato.resource;

import java.time.LocalDate;

public class budgetResource {
    private Integer Cbudget;
    private String Tdescription;
    private Integer Mmonto;
    private LocalDate Dfecha;

    public budgetResource() {
    }

    public budgetResource(Integer cbudget, String tdescription, Integer mmonto, LocalDate dfecha) {
        Cbudget = cbudget;
        Tdescription = tdescription;
        Mmonto = mmonto;
        Dfecha = dfecha;
    }

    public Integer getCbudget() {
        return Cbudget;
    }

    public budgetResource setCbudget(Integer cbudget) {
        Cbudget = cbudget;
        return this;
    }

    public String getTdescription() {
        return Tdescription;
    }

    public budgetResource setTdescription(String tdescription) {
        Tdescription = tdescription;
        return this;
    }

    public Integer getMmonto() {
        return Mmonto;
    }

    public budgetResource setMmonto(Integer mmonto) {
        Mmonto = mmonto;
        return this;
    }

    public LocalDate getDfecha() {
        return Dfecha;
    }

    public budgetResource setDfecha(LocalDate dfecha) {
        Dfecha = dfecha;
        return this;
    }
}
