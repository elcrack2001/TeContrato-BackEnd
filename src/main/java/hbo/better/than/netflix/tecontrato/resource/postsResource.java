package hbo.better.than.netflix.tecontrato.resource;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class postsResource {

    private Integer Cposts;
    private String Ntitle;
    private String Tbody;
    @DateTimeFormat
    private LocalDate create_at;
    private Integer Mbuget;
    private Integer views;
    private Integer pic;

    public Integer getCposts() {
        return Cposts;
    }

    public postsResource setCposts(Integer cposts) {
        Cposts = cposts;
        return this;
    }

    public String getNtitle() {
        return Ntitle;
    }

    public postsResource setNtitle(String ntitle) {
        Ntitle = ntitle;
        return this;
    }

    public String getTbody() {
        return Tbody;
    }

    public postsResource setTbody(String tbody) {
        Tbody = tbody;
        return this;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public postsResource setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
        return this;
    }

    public Integer getMbuget() {
        return Mbuget;
    }

    public postsResource setMbuget(Integer mbuget) {
        Mbuget = mbuget;
        return this;
    }

    public Integer getViews() {
        return views;
    }

    public postsResource setViews(Integer views) {
        this.views = views;
        return this;
    }

    public Integer getPic() {
        return pic;
    }

    public postsResource setPic(Integer pic) {
        this.pic = pic;
        return this;
    }
}
