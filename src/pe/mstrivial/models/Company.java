package pe.mstrivial.models;

import java.util.Date;

public class Company {
    private String  name;
    private int id;
    private String ruc;

    public Company() {
    }

    public Company(int id, String name, String ruc) {
        this.id = id;
        this.name = name;
        this.ruc = ruc;
    }

    public int getId() {
        return id;
    }

    public Company setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getRuc() {
        return ruc;
    }

    public Company setRuc(String ruc) {
        this.ruc = ruc;
        return this;
    }
}
