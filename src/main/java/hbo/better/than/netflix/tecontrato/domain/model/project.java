package hbo.better.than.netflix.tecontrato.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
public class project extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cproyect")
    private Integer Cproyect;

    @NotNull
    private String Nproject;

    @DateTimeFormat
    private LocalDate create_at;

    @NotNull
    private String Tdescription;

    @NotNull
    private String Fstatus;

    @NotNull
    private Integer Mbudget;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_contractor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_budget_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private budget budget;

    public project() {
    }

    public project(Integer cproyect, String nproject, LocalDate create_at, String tdescription, String fstatus, client client, contractor contractor, Integer mbudget) {
        Cproyect = cproyect;
        Nproject = nproject;
        this.create_at = create_at;
        Tdescription = tdescription;
        Fstatus = fstatus;
        this.client = client;
        this.contractor = contractor;
        Mbudget = mbudget;
    }

    public Integer getCproyect() {
        return Cproyect;
    }

    public project setCproyect(Integer cproyect) {
        Cproyect = cproyect;
        return this;
    }

    public String getNproject() {
        return Nproject;
    }

    public project setNproject(String nproject) {
        Nproject = nproject;
        return this;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public project setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
        return this;
    }

    public String getTdescription() {
        return Tdescription;
    }

    public project setTdescription(String tdescription) {
        Tdescription = tdescription;
        return this;
    }

    public String getFstatus() {
        return Fstatus;
    }

    public project setFstatus(String fstatus) {
        Fstatus = fstatus;
        return this;
    }

    public client getClient() {
        return client;
    }

    public project setClient(client client) {
        this.client = client;
        return this;
    }

    public contractor getContractor() {
        return contractor;
    }

    public project setContractor(contractor contractor) {
        this.contractor = contractor;
        return this;
    }

    public Integer getMbudget() {
        return Mbudget;
    }

    public project setMbudget(Integer mbudget) {
        Mbudget = mbudget;
        return this;
    }

    public budget getBudget() {
        return budget;
    }

    public project setBudget(budget budget) {
        this.budget = budget;
        return this;
    }
}
