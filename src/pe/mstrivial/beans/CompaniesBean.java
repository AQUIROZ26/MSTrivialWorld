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


    public String getName(){
        return this.getCompany().getName();
    }

    public String getRuc(){
        return this.getCompany().getRuc();
    }


    public Date getCreateDate(){
        return this.getCompany().getCreateDate();
    }

    public Date getModifyDate(){
        return this.getCompany().getModifyDate();
    }

    public String createCompany(){
        service.createCompany(this.getCompany(),this.getName(),this.getRuc(),
                this.getCreateDate(),this.getModifyDate());
        return "success";
    }

    public String editCompany(Company company) {
        this.setCompany(company);
        return "success";
    }

    public String newCompany() {
        this.setCompany(new Company());
        return "success";
    }

    public String updateCompany() {
        service.updateCompany(this.getCompany());
        return "success";
    }



}

