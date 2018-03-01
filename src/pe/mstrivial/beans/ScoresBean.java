package pe.mstrivial.beans;

import pe.mstrivial.models.*;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ScoresBean implements Serializable {
    private Score score;
    TwService service;
    private Person person;
    private PeopleEntity peopleEntity;
    private Category category;
    private CategoriesEntity categoriesEntity;

    public ScoresBean () {
        service = new TwService();
    }

    public List<Score> getScores(){
        return service.findAllScores();
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getVictory(){
        return this.getScore().getVictory();
    }

    public void setVictory(int victory){
        this.getScore().setVictory(victory);
    }

    public int getDefeat(){
        return this.getScore().getDefeat();
    }

    public void setDefeat(int defeat){
        this.getScore().setVictory(defeat);
    }

    public int getPoint(){
        return this.getScore().getPoint();
    }

    public void setPoint(int point){
        this.getScore().setVictory(point);
    }

    public String newScore() {
        this.setScore(new Score());
        return "success";
    }

    /*public String createScore() {
        service.createScore(this.getVictory(), this.getDefeat(), this.getPoint(),
                this.getPerson(), this.peopleEntity, this.categoriesEntity);
        return "success";
    }*/

    public String editScore(Score Score) {
        this.setScore(score);
        return "success";
    }

    /*public String updateScore() {
        service.updateScore(this.getScore(), this.getPeopleEntity(), this.getCategoriesEntity());
        return "success";
    }*/


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PeopleEntity getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoriesEntity getCategoriesEntity() {
        return categoriesEntity;
    }

    public void setCategoriesEntity(CategoriesEntity categoriesEntity) {
        this.categoriesEntity = categoriesEntity;
    }
}
