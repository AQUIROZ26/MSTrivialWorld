package pe.mstrivial.beans;


import pe.mstrivial.models.Person;
import pe.mstrivial.models.TwService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class PeopleBean implements Serializable {
    private TwService service;
    private Person person;

    public TwService getService() {
        return service;
    }

    public void setService(TwService service) {
        this.service = service;
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
