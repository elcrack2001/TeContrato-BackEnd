package hbo.better.than.netflix.tecontrato.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
public class job extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cjob")
    private Integer Cjob;

    private String Njob;
    private String Tdescripcion;

    public job() {
    }

    public job(Integer cjob, String njob, String tdescripcion) {
        Cjob = cjob;
        Njob = njob;
        Tdescripcion = tdescripcion;
    }

    public Integer getCjob() {
        return Cjob;
    }

    public job setCjob(Integer cjob) {
        Cjob = cjob;
        return this;
    }

    public String getNjob() {
        return Njob;
    }

    public job setNjob(String njob) {
        Njob = njob;
        return this;
    }

    public String getTdescripcion() {
        return Tdescripcion;
    }

    public job setTdescripcion(String tdescripcion) {
        Tdescripcion = tdescripcion;
        return this;
    }
}
