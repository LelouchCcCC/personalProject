package com.example.demo.urlRoute;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;

public class Tech {
    @TableId(type = IdType.AUTO)
    @Schema(description = "the only id")
    private Integer id;
    @Schema(description = "the technology stack")
    private String techName;

    public Integer getId() {
        return id;
    }

    public Tech(Integer id, String techName) {
        this.id = id;
        this.techName = techName;
    }

    @Override
    public String toString() {
        return "Tech{" +
                "id=" + id +
                ", techName='" + techName + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public Tech() {
    }
}
