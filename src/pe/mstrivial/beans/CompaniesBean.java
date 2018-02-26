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
    private Company company;
    private TwService service;

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

    public String getName() {
        return this.getCompany().getName();
    }

    public void setName(String name) {

        this.getCompany().setName(name);
    }

    public String getRuc(){
        return this.getCompany().getRuc();
    }

    public void setRuc(String ruc){
        this.getCompany().setRuc(ruc);
    }

    public String newCompany() {
        this.setCompany(new Company());
        return "success";
    }

    public String createCompany() {
        service.createCompany(this.getName(),this.getRuc());
        return "success";
    }

    public String editCompany(Company company) {
        this.setCompany(company);
        return "success";
    }

    public String updateCompany() {
        service.updateCompany(this.getCompany());
        return "success";
    }

    public String deleteCompany(Company company) {
        service.deleteCompany(company.getId());
        return "success";
    }

}
