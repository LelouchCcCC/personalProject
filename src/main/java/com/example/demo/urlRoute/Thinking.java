package com.example.demo.urlRoute;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class Thinking {
    @TableId(type = IdType.AUTO)
    @Schema(description = "the thinking id")
    private Integer id;
    @Schema(description = "user name")
    private String name;
    @Schema(description = "url")
    private String url;
    @Schema(description = "summary")
    private String summary;
    @Schema(description = "the date the content is posted")
    private Date date;
    @Schema(description = "the content for thinking")
    private String content;
    @Schema(description = "code for it")
    private String code;

    public Thinking(Integer id, String name, String url, String summary, Date date, String content, String code) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.summary = summary;
        this.date = date;
        this.content = content;
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Thinking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", summary='" + summary + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Thinking(Integer id, String name, String summary, Date date, String content, String code) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.date = date;
        this.content = content;
        this.code = code;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Thinking(Integer id, String name, Date date, String content, String code) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.content = content;
        this.code = code;
    }

    public Thinking() {
    }
}
