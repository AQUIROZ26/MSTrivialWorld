package pe.mstrivial.models;

import java.util.Date;

public class Company {
    private int     id;
    private String  name;
    private String  ruc;
    private Date    createDate;
    private Date    modifyDate;

    public Company() {
    }

    public Company(int id, String name, String ruc, Date createDate, Date modifyDate) {
        this.id = id;
        this.name = name;
        this.ruc = ruc;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
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

    public Date getCreateDate() {
        return createDate;
    }

    public Company setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Company setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }
}
