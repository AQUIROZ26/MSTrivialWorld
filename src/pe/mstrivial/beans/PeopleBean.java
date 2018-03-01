package pe.mstrivial.beans;

import pe.mstrivial.models.CompaniesEntity;
import pe.mstrivial.models.Company;
import pe.mstrivial.models.Person;
import pe.mstrivial.models.TwService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PeopleBean implements Serializable{
    private Person person = new Person();
    private TwService service;
    private Company company;
    private CompaniesEntity companiesEntity;

    public PeopleBean() {
        setService(new TwService());
    }

    public List<Person> getPeople(){
        return getService().findAllPeople();
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getFirstName(){
        return this.getPerson().getFirstName();
    }

    public void setFirstName(String firstName){
        this.getPerson().setFirstName(firstName);
    }

    public String getLastNameF(){
        return  this.getPerson().getLastNameF();
    }

    public void setLastNameF(String lastNameF){
        this.getPerson().setLastNameF(lastNameF);
    }

    public String getLastNameM(){
        return  this.getPerson().getLastNameM();
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

    public String getUserName(){
        return this.getPerson().getUserName();
    }

    public void setUserName(String userName){
        this.getPerson().setUserName(userName);
    }

    public String getPassword(){
        return this.getPerson().getPassword();
    }

    public void setPassword(String password){
        this.getPerson().setPassword(password);
    }

    public String newPerson(){
        this.setPerson(new Person());
        return "success";
    }

    public String createPerson(){
        getService().createPerson(this.getFirstName(),this.getLastNameF(),this.getLastNameM(),
                this.getCountry(),this.getEmail(),this.getUserName(),this.getPassword(), this.getCompany(), this.companiesEntity);
        return "success";
    }

    public String editPerson(Person person){
        this.setPerson(person);
        return "success";
    }

    public String updatePerson(CompaniesEntity companiesEntity){
        getService().updatePerson(this.getPerson(), companiesEntity);
        return "success";
    }

    public String deletePerson (Person person){
        getService().deletePerson(person.getId());
        return "success";
    }


    public CompaniesEntity getCompaniesEntity() {
        return companiesEntity;
    }

    public void setCompaniesEntity(CompaniesEntity companiesEntity) {
        this.companiesEntity = companiesEntity;
    }

    public TwService getService() {
        return service;
    }

    public void setService(TwService service) {
        this.service = service;
    }
}
