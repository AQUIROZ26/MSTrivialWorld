package pe.mstrivial.models;

import java.util.Date;

public class Serie {

    private int id;
    private int categoryId;
    private String descriptionSerie;
    private String type;
    private String director;
    private String url;
    private Date createDate;
    private Date modifyDate;

    public Serie(int id, int categoryId, String descriptionSerie, String type, String director, String url, Date createDate, Date modifyDate) {
        this.id = id;
        this.categoryId = categoryId;
        this.descriptionSerie = descriptionSerie;
        this.type = type;
        this.director = director;
        this.url = url;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public Serie() {
    }


    public int getId() {
        return id;
    }

    public Serie setId(int id) {
        this.id = id;
        return this;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Serie setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getDescriptionSerie() {
        return descriptionSerie;
    }

    public Serie setDescriptionSerie(String descriptionSerie) {
        this.descriptionSerie = descriptionSerie;
        return this;
    }

    public String getType() {
        return type;
    }

    public Serie setType(String type) {
        this.type = type;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public Serie setDirector(String director) {
        this.director = director;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Serie setUrl(String url) {
        this.url = url;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Serie setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Serie setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }
}
