package hbo.better.than.netflix.tecontrato.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class task extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ctask")
    private Integer Ctask;

    @NotNull
    private String Ntask;

    public task() {
    }

    public task(Integer ctask, String ntask) {
        Ctask = ctask;
        Ntask = ntask;
    }

    public Integer getCtask() {
        return Ctask;
    }

    public task setCtask(Integer ctask) {
        Ctask = ctask;
        return this;
    }

    public String getNtask() {
        return Ntask;
    }

    public task setNtask(String ntask) {
        Ntask = ntask;
        return this;
    }
}
