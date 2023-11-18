package com.example.demo.urlRoute;

public class TechStack {
    private Integer id;
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
