package pe.mstrivial.models;

import java.util.Date;

public class Score {

    private int id;
    private int playerId;
    private int victories;
    private int defeats;
    private Date createDate;
    private Date modifyDate;

    public Score(int id, int playerId, int victories, int defeats, Date createDate, Date modifyDate) {
        this.id = id;
        this.playerId = playerId;
        this.victories = victories;
        this.defeats = defeats;
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

    public int getPlayerId() {
        return playerId;
    }

    public Score setPlayerId(int playerId) {
        this.playerId = playerId;
        return this;
    }

    public int getVictories() {
        return victories;
    }

    public Score setVictories(int victories) {
        this.victories = victories;
        return this;
    }

    public int getDefeats() {
        return defeats;
    }

    public Score setDefeats(int defeats) {
        this.defeats = defeats;
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
