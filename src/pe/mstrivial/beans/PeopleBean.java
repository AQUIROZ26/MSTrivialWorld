package pe.mstrivial.beans;


import pe.mstrivial.models.CompaniesEntity;
import pe.mstrivial.models.Company;
import pe.mstrivial.models.Person;
import pe.mstrivial.models.TwService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class PeopleBean implements Serializable {
    private TwService service;
    private Person person;
    private Company company;

    public PeopleBean() {

        service = new TwService();
    }

    public List<Person> getPeople() {

        return service.findAllPeople();
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // public int getId(){
    //   return this.getCompany().getId();
    //}

    public String getFirstName() {
        return this.getPerson().getFirstName();
    }

    public String getLastNameP() {
        return this.getPerson().getLastNameP();
    }

    public String getLastNameM() {
        return this.getPerson().getLastNameM();
    }

    public String getCountry() {
        return this.getPerson().getCountry();
    }

    public String getEmail() {
        return this.getPerson().getEmail();
    }

    public String getUsername() {
        return this.getPerson().getUsername();
    }

    public String getPassword() {
        return this.getPerson().getPassword();
    }

    public Date getCreateDate() {
        return this.getPerson().getCreateDate();
    }

    public Date getModifyDate() {
        return this.getPerson().getModifyDate();
    }

    public String createPerson() {
        service.createPerson(this.getCompany(), this.getFirstName(), this.getLastNameP(),
                this.getLastNameM(), this.getCountry(), this.getEmail(), this.getUsername(),
                this.getPassword(), this.getCreateDate(), this.getModifyDate());
        return "success";
    }

    public String editPerson(Person person) {
        this.setPerson(person);
        return "success";
    }

    public String newPerson() {
        this.setPerson(new Person());
        return "success";
    }

    public String updatePerson(CompaniesEntity companiesEntity) {
          service.updatePerson(this.getPerson(), companiesEntity);
        return "success";

}
}