package pe.mstrivial.beans;

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
public class CompaniesBean implements Serializable {
    private TwService service;
    private Company company;

    public CompaniesBean() {

        service = new TwService();
    }

    public List<Company> getCompanies() {

        return service.findAllCompanies();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public String get(){
        return this.getPerson().getFirstName();
    }

    public String getLastNameP(){
        return this.getPerson().getLastNameP();
    }

    public String getLastNameM(){
        return this.getPerson().getLastNameM();
    }

    public String getCountry(){
        return this.getPerson().getCountry();
    }

    public String getEmail(){
        return this.getPerson().getEmail();
    }

    public String getUsername(){
        return this.getPerson().getUsername();
    }

    public String getPassword(){
        return this.getPerson().getPassword();
    }

    public Date getCreateDate(){
        return this.getPerson().getCreateDate();
    }

    public Date getModifyDate(){
        return this.getPerson().getModifyDate();
    }





}

