package com.example.demo.urlRoute;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
@Schema(description = "Basic information for the user")
public class Basic {
    @Schema(description = "user name")
    private String name;
    @Schema(description = "date of birth")
    private Date birth;
    @Schema(description = "studying school")
    private String School;
    @Schema(description = "main phone number")
    private Double phone;
    @Schema(description = "sub phone number")
    private Double subphone;
    @Schema(description = "main mail")
    private String mailbox;
    @Schema(description = "sub mail")
    private String submailbox;
    @Schema(description = "personal photo")
    private String photo;
    @Schema(description = "github link")
    private String githubLink;
    @Schema(description = "linkedIn link")
    private String linkedInLink;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public Double getPhone() {
        return phone;
    }

    public void setPhone(Double phone) {
        this.phone = phone;
    }

    public Double getSubphone() {
        return subphone;
    }

    public void setSubphone(Double subphone) {
        this.subphone = subphone;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getSubmailbox() {
        return submailbox;
    }

    public void setSubmailbox(String submailbox) {
        this.submailbox = submailbox;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }
}
