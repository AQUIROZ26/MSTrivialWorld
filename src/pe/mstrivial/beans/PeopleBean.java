package pe.mstrivial.beans;


import pe.mstrivial.models.Person;
import pe.mstrivial.models.TwService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PeopleBean implements Serializable {
    private TwService service;
    private Person person;

    public PeopleBean() {
        service = new TwService();
    }

    public List<Person> getPeople(){
        return service.findAllPeople();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public String editPerson (Person person){
        this.setPerson(person);
        return "success";
    }
    public String newPerson (){
        this.setPerson(new Person());
        return "success";

    }
    public String updatePerson(){
       service.updatePerson(this.getPerson());
       return "success";

}
}
;