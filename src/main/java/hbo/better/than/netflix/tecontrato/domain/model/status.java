package hbo.better.than.netflix.tecontrato.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "status")
public class status extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cstatus")
    private Integer Cstatus;

    @NotNull
    private String Nstatus;

    public status() {
    }

    public status(Integer cstatus, String nstatus) {
        Cstatus = cstatus;
        Nstatus = nstatus;
    }

    public Integer getCstatus() {
        return Cstatus;
    }

    public status setCstatus(Integer cstatus) {
        Cstatus = cstatus;
        return this;
    }

    public String getNstatus() {
        return Nstatus;
    }

    public status setNstatus(String nstatus) {
        Nstatus = nstatus;
        return this;
    }
}
