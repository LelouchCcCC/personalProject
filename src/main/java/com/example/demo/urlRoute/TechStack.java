package com.example.demo.urlRoute;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;

public class TechStack {
    @TableId(type = IdType.AUTO)
    @Schema(description = "techStack id")
    private Integer id;
    @Schema(description = "techStack used")
    private String technology;

    @Override
    public String toString() {
        return "TechStack{" +
                "id=" + id +
                ", technology='" + technology + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public TechStack(Integer id, String technology) {
        this.id = id;
        this.technology = technology;
    }

    public TechStack() {
    }
}
