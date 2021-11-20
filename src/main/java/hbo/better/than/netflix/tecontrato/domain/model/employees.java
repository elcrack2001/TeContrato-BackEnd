package hbo.better.than.netflix.tecontrato.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "employees")
public class employees extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cemployee")
    private Integer Cemployee;

    @NotNull
    private String Nemployee;

    @NotNull
    private String Tposition;

    @NotNull
    private Integer Mpayment;

    @NotNull
    private String Tworks;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_job_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private job job;

    public List<projectControl> getProjectControls() {
        return projectControls;
    }

    public employees setProjectControls(List<projectControl> projectControls) {
        this.projectControls = projectControls;
        return this;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "employees")
    private List<projectControl> projectControls;

    public employees() {
    }

    public employees(Integer cemployee, String nemployee, String tposition, Integer mpayment, String tworks, job job) {
        Cemployee = cemployee;
        Nemployee = nemployee;
        Tposition = tposition;
        Mpayment = mpayment;
        Tworks = tworks;
        this.job = job;
    }

    public Integer getCemployee() {
        return Cemployee;
    }

    public employees setCemployee(Integer cemployee) {
        Cemployee = cemployee;
        return this;
    }

    public String getNemployee() {
        return Nemployee;
    }

    public employees setNemployee(String nemployee) {
        Nemployee = nemployee;
        return this;
    }

    public String getTposition() {
        return Tposition;
    }

    public employees setTposition(String tposition) {
        Tposition = tposition;
        return this;
    }

    public Integer getMpayment() {
        return Mpayment;
    }

    public employees setMpayment(Integer mpayment) {
        Mpayment = mpayment;
        return this;
    }

    public String getTworks() {
        return Tworks;
    }

    public employees setTworks(String tworks) {
        Tworks = tworks;
        return this;
    }

    public job getJob() {
        return job;
    }

    public employees setJob(job job) {
        this.job = job;
        return this;
    }
}
