package pe.mstrivial.models;

import java.util.Date;

public class Answer {

    private int id;
    private int questionId;
    private String descriptionAnswer;
    private int flag;
    private Date createDate;
    private Date modifyDate;

    public Answer(int id, int questionId, String descriptionAnswer, int flag, Date createDate, Date modifyDate) {
        this.setId(id);
        this.setQuestionId(questionId);
        this.setDescriptionAnswer(descriptionAnswer);
        this.setFlag(flag);
        this.setCreateDate(createDate);
        this.setModifyDate(modifyDate);
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

    public int getQuestionId() {
        return questionId;
    }

    public Answer setQuestionId(int questionId) {
        this.questionId = questionId;
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
;