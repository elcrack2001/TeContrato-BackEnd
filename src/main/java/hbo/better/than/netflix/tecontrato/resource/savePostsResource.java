package hbo.better.than.netflix.tecontrato.resource;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class savePostsResource {
    private String Ntitle;
    private String Tbody;
    @DateTimeFormat
    private LocalDate create_at;
    private Integer Mbuget;
    private Integer views;
    private Integer pic;

    public String getNtitle() {
        return Ntitle;
    }

    public savePostsResource setNtitle(String ntitle) {
        Ntitle = ntitle;
        return this;
    }

    public String getTbody() {
        return Tbody;
    }

    public savePostsResource setTbody(String tbody) {
        Tbody = tbody;
        return this;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public savePostsResource setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
        return this;
    }

    public Integer getMbuget() {
        return Mbuget;
    }

    public savePostsResource setMbuget(Integer mbuget) {
        Mbuget = mbuget;
        return this;
    }

    public Integer getViews() {
        return views;
    }

    public savePostsResource setViews(Integer views) {
        this.views = views;
        return this;
    }

    public Integer getPic() {
        return pic;
    }

    public savePostsResource setPic(Integer pic) {
        this.pic = pic;
        return this;
    }
}
