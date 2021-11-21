package hbo.better.than.netflix.tecontrato.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "taksprojectcontrols")
public class taksProjectControl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ctaksproject")
    private Integer CtaksProject;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_projectControl_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private projectControl projectControl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_employees_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private employees employees;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_task_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private task task;

    public Integer getCtaksProject() {
        return CtaksProject;
    }

    public taksProjectControl setCtaksProject(Integer ctaksProject) {
        CtaksProject = ctaksProject;
        return this;
    }

    public projectControl getProjectControl() {
        return projectControl;
    }

    public taksProjectControl setProjectControl(projectControl projectControl) {
        this.projectControl = projectControl;
        return this;
    }

    public employees getEmployees() {
        return employees;
    }

    public taksProjectControl setEmployees(employees employees) {
        this.employees = employees;
        return this;
    }

    public task getTask() {
        return task;
    }

    public taksProjectControl setTask(task task) {
        this.task = task;
        return this;
    }
}
