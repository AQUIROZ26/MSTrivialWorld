package pe.mstrivial.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TwService {
    private Connection connection;
    private CompaniesEntity companiesEntity;
    private PeopleEntity peopleEntity;
    private ScoresEntity scoresEntity;

    private Connection getConnection() {
        if(connection == null) {
            try {
                connection = ((DataSource) InitialContext
                        .doLookup("jdbc/MySQLDataSourceTw"))
                        .getConnection();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected CompaniesEntity getCompaniesEntity() {
        if(getConnection() != null) {
            if(companiesEntity == null) {
                companiesEntity = new CompaniesEntity();
                companiesEntity.setConnection(getConnection());
            }
        }
        return companiesEntity;
    }

    protected PeopleEntity getPeopleEntity() {
        if(getConnection() != null) {
            if(peopleEntity == null) {
                peopleEntity = new PeopleEntity();
                peopleEntity.setConnection(getConnection());
            }
        }
        return peopleEntity;
    }

    protected  ScoresEntity getScoresEntity(){
        if(getConnection() != null){
            if(scoresEntity == null){
                scoresEntity = new ScoresEntity();
                scoresEntity.setConnection(getConnection());
            }
        }
        return scoresEntity;
    }


    public List<Person> findAllPeople() {
        return (getPeopleEntity() != null &&
                getCompaniesEntity() != null) ?
                getPeopleEntity().findAll(getCompaniesEntity()) : null;

    }
    public List<Company> findAllCompanies() {

        return getCompaniesEntity() != null ?
                getCompaniesEntity().findAll() : null;
    }

    public List<Score> findAllScores(){
        return getScoresEntity() != null ?
                getScoresEntity().findAll(getPeopleEntity(),getCompaniesEntity()) : null;
    }
    public Company findCompanyById(int id) {
        return getCompaniesEntity() != null ?
                getCompaniesEntity().findById(id) : null;
    }

    public Company findCompanyByName(String name) {
        return getCompaniesEntity() != null ?
                getCompaniesEntity().findByName(name) : null;
    }

    public Company findPersonById(int id) {
        return getPeopleEntity() != null ?
                getCompaniesEntity().findById(id) : null;
    }


    public Company createCompany(String name, String ruc) {
        return getCompaniesEntity() != null ?
                getCompaniesEntity().create(name, ruc) : null;
    }

    public boolean deleteCompany(int id) {
        return getCompaniesEntity() != null ?
                getCompaniesEntity().delete(id) : false;
    }

    public boolean updateCompany(Company company) {
        return getCompaniesEntity() != null ?
                getCompaniesEntity().update(company) : false;
    }

    public Person createPerson(String firstName, String lastNameF, String lastNameM, String country,
                               String email, String userName, String password, Company company, CompaniesEntity companiesEntity){
        return getPeopleEntity() != null ?
                getPeopleEntity().create(firstName, lastNameF, lastNameM, country,
                        email, userName, password, company, companiesEntity) : null;
    }

    public boolean deletePerson(int id){
        return getPeopleEntity() != null ?
                getPeopleEntity().delete(id) : false;
    }

    public boolean updatePerson (Person person, CompaniesEntity companiesEntity){
        return getPeopleEntity() != null ?
                getPeopleEntity().update(person, companiesEntity) :false;
    }

    public Score createScore (int victory, int defeat, int point, Person person,
                              PeopleEntity peopleEntity, CategoriesEntity companiesEntity){
        return getScoresEntity() != null ?
                getScoresEntity().create(victory,defeat,point,person, peopleEntity, companiesEntity) :null;
    }

    public boolean updateScore (Score score, PeopleEntity peopleEntity, CategoriesEntity companiesEntity){
        return getScoresEntity() != null ?
                getScoresEntity().update(score,peopleEntity,companiesEntity):false;
    }

}
