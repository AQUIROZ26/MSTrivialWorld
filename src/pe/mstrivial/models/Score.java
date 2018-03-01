package pe.mstrivial.models;


public class Score {

    private int id;
    private int victory;
    private int defeat;
    private int point;
    private Person person;

    public Score() {
    }

    public Score(int id, int victory, int defeat, int point, Person person) {
        this.id = id;
        this.victory = victory;
        this.defeat = defeat;
        this.point = point;
        this.person = person;
    }


    public int getId() {
        return id;
    }

    public Score setId(int id) {
        this.id = id;
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

    public int getPoint() {
        return point;
    }

    public Score setPoint(int point) {
        this.point = point;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Score setPerson(Person person) {
        this.person = person;
        return this;
    }

}
