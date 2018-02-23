package pe.mstrivial.models;

import java.util.Date;

public class Score {

    private int id;
    private Person person;
    private int victory;
    private int defeat;
    private Date createDate;
    private Date modifyDate;

    public Score(int id, Person person, int victory, int defeat, Date createDate, Date modifyDate) {
        this.id = id;
        this.person = person;
        this.victory = victory;
        this.defeat = defeat;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }



    public Score() {
    }


    public int getId() {
        return id;
    }

    public Score setId(int id) {
        this.id = id;
        return this;
    }

    public Person getPerson() {

        return person;
    }

    public Score setPerson(Person person) {
        this.person = person;
        return this;
    }

    public int getVictory() {
        return victory;
    }

    public Score setVictory(int victory) {
        this.victory = victory;
        return this;
    }

    public int getDefeat() {
        return defeat;
    }

    public Score setDefeat(int defeat) {
        this.defeat = defeat;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Score setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Score setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }
}
