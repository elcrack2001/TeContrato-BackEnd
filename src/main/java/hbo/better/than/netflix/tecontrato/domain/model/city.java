package hbo.better.than.netflix.tecontrato.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cities")
public class city extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ccity")
    private Integer Ccity;

    @NotNull
    private String Ncity;

    public city() {
    }

    public city(Integer ccity, String ncity) {
        Ccity = ccity;
        Ncity = ncity;
    }

    public Integer getCcity() {
        return Ccity;
    }

    public city setCcity(Integer ccity) {
        Ccity = ccity;
        return this;
    }

    public String getNcity() {
        return Ncity;
    }

    public city setNcity(String ncity) {
        Ncity = ncity;
        return this;
    }
}
