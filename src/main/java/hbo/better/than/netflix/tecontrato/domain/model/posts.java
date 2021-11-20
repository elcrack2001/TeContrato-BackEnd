package hbo.better.than.netflix.tecontrato.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class posts extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cposts")
    private Integer Cposts;

    @NotNull
    private String Ntitle;

    @NotNull
    private String Tbody;

    @DateTimeFormat
    private LocalDate create_at;

    @NotNull
    private Integer Mbuget;

    @NotNull
    private Integer views;

    @NotNull
    private Integer pic;

    public user getUser() {
        return user;
    }

    public posts setUser(user user) {
        this.user = user;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private user user;

    public posts() {
    }

    public posts(Integer cposts, String ntitle, String tbody, LocalDate create_at, Integer mbuget, Integer views, Integer pic) {
        Cposts = cposts;
        Ntitle = ntitle;
        Tbody = tbody;
        this.create_at = create_at;
        Mbuget = mbuget;
        this.views = views;
        this.pic = pic;
    }


    public Integer getCposts() {
        return Cposts;
    }

    public posts setCposts(Integer cposts) {
        Cposts = cposts;
        return this;
    }

    public String getNtitle() {
        return Ntitle;
    }

    public posts setNtitle(String ntitle) {
        Ntitle = ntitle;
        return this;
    }

    public String getTbody() {
        return Tbody;
    }

    public posts setTbody(String tbody) {
        Tbody = tbody;
        return this;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public posts setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
        return this;
    }

    public Integer getMbuget() {
        return Mbuget;
    }

    public posts setMbuget(Integer mbuget) {
        Mbuget = mbuget;
        return this;
    }

    public Integer getViews() {
        return views;
    }

    public posts setViews(Integer views) {
        this.views = views;
        return this;
    }

    public Integer getPic() {
        return pic;
    }

    public posts setPic(Integer pic) {
        this.pic = pic;
        return this;
    }
}
