package pe.mstrivial.models;

import java.util.Date;

public class Trivia {

    private int id;
    private Person person1;
    private Person person2;
    private Category category;
    private int winner;
    private int scorePlayer1;
    private int scorePlayer2;
    private Date startDate;
    private Date endDate;


    public Trivia() {
    }

    public Trivia(int id, Person person1, Person person2, Category category, int winner, int scorePlayer1, int scorePlayer2, Date startDate, Date endDate) {
        this.id = id;
        this.person1 = person1;
        this.person2 = person2;
        this.category = category;
        this.winner = winner;
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public Trivia setId(int id) {
        this.id = id;
        return this;
    }

    public Person getPerson1() {
        return person1;
    }

    public Trivia setPerson1(Person person1) {
        this.person1 = person1;
        return this;
    }

    public Person getPerson2() {
        return person2;
    }

    public Trivia setPerson2(Person person2) {
        this.person2 = person2;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Trivia setCategory(Category category) {
        this.category = category;
        return this;
    }

    public int getWinner() {
        return winner;
    }

    public Trivia setWinner(int winner) {
        this.winner = winner;
        return this;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public Trivia setScorePlayer1(int scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
        return this;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public Trivia setScorePlayer2(int scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Trivia setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Trivia setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }



}
