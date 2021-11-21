package hbo.better.than.netflix.tecontrato.resource;

import java.time.LocalDate;

public class saveBudgetResource {
    private String Tdescription;
    private Integer Mmonto;
    private LocalDate Dfecha;

    public saveBudgetResource() {
    }

    public saveBudgetResource(String tdescription, Integer mmonto, LocalDate dfecha) {
        Tdescription = tdescription;
        Mmonto = mmonto;
        Dfecha = dfecha;
    }

    public String getTdescription() {
        return Tdescription;
    }

    public saveBudgetResource setTdescription(String tdescription) {
        Tdescription = tdescription;
        return this;
    }

    public Integer getMmonto() {
        return Mmonto;
    }

    public saveBudgetResource setMmonto(Integer mmonto) {
        Mmonto = mmonto;
        return this;
    }

    public LocalDate getDfecha() {
        return Dfecha;
    }

    public saveBudgetResource setDfecha(LocalDate dfecha) {
        Dfecha = dfecha;
        return this;
    }
}
