package hbo.better.than.netflix.tecontrato.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "budgets")
public class budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cbudget")
    private Integer Cbudget;

    private String Tdescription;

    private Integer Mmonto;

    @DateTimeFormat
    private LocalDate Dfecha;

    public budget() {
    }

    public budget(Integer cbudget, String tdescription, Integer mmonto, LocalDate dfecha) {
        Cbudget = cbudget;
        Tdescription = tdescription;
        Mmonto = mmonto;
        Dfecha = dfecha;
    }

    public Integer getCbudget() {
        return Cbudget;
    }

    public budget setCbudget(Integer cbudget) {
        Cbudget = cbudget;
        return this;
    }

    public String getTdescription() {
        return Tdescription;
    }

    public budget setTdescription(String tdescription) {
        Tdescription = tdescription;
        return this;
    }

    public Integer getMmonto() {
        return Mmonto;
    }

    public budget setMmonto(Integer mmonto) {
        Mmonto = mmonto;
        return this;
    }

    public LocalDate getDfecha() {
        return Dfecha;
    }

    public budget setDfecha(LocalDate dfecha) {
        Dfecha = dfecha;
        return this;
    }
}
