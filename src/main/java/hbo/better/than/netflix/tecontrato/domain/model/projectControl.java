package hbo.better.than.netflix.tecontrato.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projectcontrols")
public class projectControl extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ccontrol")
    private Integer Ccontrol;

    @NotNull
    private String Nproyect;

    @NotNull
    private String Fstatus;

    @DateTimeFormat
    private LocalDate Dlastedited;

    @NotNull
    private String Ttasks;

    @NotNull
    private Integer Qemployees;

    @NotNull
    private Integer Mbudget;

    @NotNull
    private Integer Qprogress;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_project_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_status_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private status status;

    //Relacion muchos a muchos
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name ="ControlEmployees",
            joinColumns =  {@JoinColumn(name = "ccontrol_id")},
            inverseJoinColumns = {@JoinColumn(name = "cemployee_id")})
    private List<employees> employees;

    public projectControl() {
    }

    public projectControl(Integer ccontrol, String nproyect, String fstatus, LocalDate dlastedited, String ttasks, project project, Integer qemployees, Integer mbudget, Integer qprogress) {
        Ccontrol = ccontrol;
        Nproyect = nproyect;
        Fstatus = fstatus;
        Dlastedited = dlastedited;
        Ttasks = ttasks;
        this.project = project;
        Qemployees = qemployees;
        Mbudget = mbudget;
        Qprogress = qprogress;
    }

    //Funciones para el ControlEmployees
    public boolean isTaggedWith(employees tag) {
        return this.getEmployees().contains(tag);
    }

    public projectControl tagWith(employees tag) {
        if(!isTaggedWith(tag)) {
            this.getEmployees().add(tag);
        }
        return this;
    }

    public projectControl untagWith(employees tag) {
        if(this.isTaggedWith(tag))
            this.getEmployees().remove(tag);
        return this;
    }

    public Integer getCcontrol() {
        return Ccontrol;
    }

    public projectControl setCcontrol(Integer ccontrol) {
        Ccontrol = ccontrol;
        return this;
    }

    public String getNproyect() {
        return Nproyect;
    }

    public projectControl setNproyect(String nproyect) {
        Nproyect = nproyect;
        return this;
    }

    public String getFstatus() {
        return Fstatus;
    }

    public projectControl setFstatus(String fstatus) {
        Fstatus = fstatus;
        return this;
    }

    public LocalDate getDlastedited() {
        return Dlastedited;
    }

    public projectControl setDlastedited(LocalDate dlastedited) {
        Dlastedited = dlastedited;
        return this;
    }

    public String getTtasks() {
        return Ttasks;
    }

    public projectControl setTtasks(String ttasks) {
        Ttasks = ttasks;
        return this;
    }

    public project getProject() {
        return project;
    }

    public projectControl setProject(project project) {
        this.project = project;
        return this;
    }

    public Integer getQemployees() {
        return Qemployees;
    }

    public projectControl setQemployees(Integer qemployees) {
        Qemployees = qemployees;
        return this;
    }

    public Integer getMbudget() {
        return Mbudget;
    }

    public projectControl setMbudget(Integer mbudget) {
        Mbudget = mbudget;
        return this;
    }

    public Integer getQprogress() {
        return Qprogress;
    }

    public projectControl setQprogress(Integer qprogress) {
        Qprogress = qprogress;
        return this;
    }

    public status getStatus() {
        return status;
    }

    public projectControl setStatus(status status) {
        this.status = status;
        return this;
    }

    public List<employees> getEmployees() {
        return employees;
    }

    public projectControl setEmployees(List<employees> employees) {
        this.employees = employees;
        return this;
    }
}
