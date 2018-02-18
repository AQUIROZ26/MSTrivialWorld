package pe.mstrivial.models;

import java.util.Date;

public class Question {
    private int id;
    private int categoryId;
    private String descriptionQuestion;
    private int point;
    private Date createDate;
    private Date modifyDate;

    public Question(int id, int categoryId, String descriptionQuestion, int point, Date createDate, Date modifyDate) {
        this.setId(id);
        this.setCategoryId(categoryId);
        this.setDescriptionQuestion(descriptionQuestion);
        this.setPoint(point);
        this.setCreateDate(createDate);
        this.setModifyDate(modifyDate);
    }

    public Question() {
    }


    public int getId() {
        return id;
    }

    public Question setId(int id) {
        this.id = id;
        return this;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Question setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getDescriptionQuestion() {
        return descriptionQuestion;
    }

    public Question setDescriptionQuestion(String descriptionQuestion) {
        this.descriptionQuestion = descriptionQuestion;
        return this;
    }

    public int getPoint() {
        return point;
    }

    public Question setPoint(int point) {
        this.point = point;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Question setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Question setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }
}
