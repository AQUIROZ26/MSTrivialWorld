package pe.mstrivial.models;

import java.util.Date;

public class Answer {

    private int id;
    private Question question;
    private String descriptionAnswer;
    private int flag;
    private Date createDate;
    private Date modifyDate;

    public Answer(int id, Question question, String descriptionAnswer, int flag, Date createDate, Date modifyDate) {
        this.id = id;
        this.question = question;
        this.descriptionAnswer = descriptionAnswer;
        this.flag = flag;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public Answer() {
    }


    public int getId() {
        return id;
    }

    public Answer setId(int id) {
        this.id = id;
        return this;
    }

    public Question getQuestion() {

        return question;
    }

    public Answer setQuestionId(Question question) {
        this.question = question;
        return this;
    }

    public String getDescriptionAnswer() {
        return descriptionAnswer;
    }

    public Answer setDescriptionAnswer(String descriptionAnswer) {
        this.descriptionAnswer = descriptionAnswer;
        return this;
    }

    public int getFlag() {
        return flag;
    }

    public Answer setFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Answer setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Answer setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }
}
