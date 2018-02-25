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

    public String getFirstName(){
        return this.getPerson().getFirstName();
    }

    public void setFirstName(String firstName){
        this.getPerson().setFirstName(firstName);
    }

    public String getLastNameP(){
        return this.getPerson().getLastNameP();
    }

    public void setLastNameP(String lastNameP){
        this.getPerson().setLastNameP(lastNameP);
    }

    public String getLastNameM(){
        return this.getPerson().getLastNameM();
    }

    public void setLastNameM(String lastNameM){
        this.getPerson().setLastNameM(lastNameM);
    }

    public String getCountry(){
        return this.getPerson().getCountry();
    }

    public void setCountry(String country){
        this.getPerson().setCountry(country);
    }
    public String getEmail(){
        return this.getPerson().getEmail();
    }

    public void setEmail(String email){
        this.getPerson().setEmail(email);
    }

    public String getUsername(){
        return this.getPerson().getUsername();
    }

    public void setUsername(String username){
        this.getPerson().setUsername(username);
    }

    public String getPassword(){
        return this.getPerson().getPassword();
    }

    public void setPassword(String password){
        this.getPerson().setPassword(password);
    }

    public Date getCreateDate(){
        return this.getPerson().getCreateDate();
    }

    public void setCreateDate(Date createDate){
        this.getPerson().setCreateDate(createDate);
    }

    public Date getModifyDate(){
        return this.getPerson().getModifyDate();
    }

    public void setModifyDate(Date modifyDate){
        this.getPerson().setCreateDate(modifyDate);
    }

    public String createPerson(){
        service.createPerson(this.getCompany(),this.getFirstName(),this.getLastNameP(),
                this.getLastNameM(),this.getCountry(),this.getEmail(),this.getUsername(),
                this.getPassword(),this.getCreateDate(),this.getModifyDate());
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

    //public String updatePerson() {
      //      service.updatePerson(this.getPerson());
        //    return "success";
    //}

}