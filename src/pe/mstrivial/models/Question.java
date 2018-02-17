package pe.mstrivial.models;

import java.util.Date;

public class Question {
    private int id;
    private int id_category;
    private String descriptionQuestion;
    private int point;
    private Date createDate;
    private Date modifyDate;


    public Question(int id, String descriptionQuestion, int point){
        this.id = id;
        this.id_category = id_category;
        this.descriptionQuestion = descriptionQuestion;
        this.point = point;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
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

    public int getId_category() {
        return id_category;
    }

    public Question setId_category(int id_category) {
        this.id_category = id_category;
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
