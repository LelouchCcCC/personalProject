package com.example.demo.urlRoute;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;

public class Tech {
    @TableId(type = IdType.AUTO)
    @Schema(description = "the only id")
    private Integer id;
    @Schema(description = "thinking id")
    private Integer thinkingId;
    @Schema(description = "the technology stack")
    private String tech;

    @Override
    public String toString() {
        return "Tech{" +
                "id=" + id +
                ", thinkingId=" + thinkingId +
                ", tech='" + tech + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThinkingId() {
        return thinkingId;
    }

    public void setThinkingId(Integer thinkingId) {
        this.thinkingId = thinkingId;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Tech(Integer id, Integer thinkingId, String tech) {
        this.id = id;
        this.thinkingId = thinkingId;
        this.tech = tech;
    }

    public Tech() {
    }
}



