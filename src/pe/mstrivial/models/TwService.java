package pe.mstrivial.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TwService {
    Connection connection;
    PeopleEntity peopleEntity;
    CategoriesEntity categoriesEntity;
    QuestionsEntity questionsEntity;
    AnswersEntity answersEntity;
    ScoresEntity scoresEntity;
    CompaniesEntity companiesEntity;

    private Connection getConnection(){
        if (connection == null){
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
    // PeopleEntity
    protected PeopleEntity getPeopleEntity(){
        if(getConnection() != null){
            if(peopleEntity == null){
                peopleEntity = new PeopleEntity();
                peopleEntity.setConnection(getConnection());
            }
        }
        return peopleEntity;
    }

    // CategoriesEntity
    protected CategoriesEntity getCategoriesEntity(){
        if(getConnection()!= null){
            if(categoriesEntity==null){
                categoriesEntity = new CategoriesEntity();
                categoriesEntity.setConnection(getConnection());
            }
        }
        return categoriesEntity;
    }

    protected  CompaniesEntity getCompaniesEntity(){
        if(getConnection() != null){
            if(companiesEntity == null) {
                companiesEntity = new CompaniesEntity();
                companiesEntity.setConnection((getConnection()));
            }
        }
        return  companiesEntity;
    }

    protected QuestionsEntity getQuestionsEntity(){
        if(getConnection() != null){
            if(questionsEntity == null){
                questionsEntity = new QuestionsEntity();
                questionsEntity.setConnection(getConnection());
            }
        }
        return questionsEntity;
    }

    public List<Company> findAllCompanies() {
        return getCompaniesEntity() != null ?
                getCompaniesEntity().findAll() : null;
    }


    public List<Category> findAllCategories(){
        return getCategoriesEntity() != null ? getCategoriesEntity().findAll() : null;
    }

    public List<Person> findAllPeople(){
        return (getPeopleEntity() != null &&
                getCompaniesEntity() != null ?
                getPeopleEntity().findAll(getCompaniesEntity()) : null);
    }
    public Person findPersonById (int id){
        return getPeopleEntity() != null ?
                getPeopleEntity().findById(id,getCompaniesEntity()) : null;
    }

    public Person findPersonByFirstName (String firstName){
        return getPeopleEntity() != null ?
                getPeopleEntity().findByFirstName(firstName, getCompaniesEntity()) : null ;
    }

    public Person findPersonByLastNameP (String lastNameP){
        return getPeopleEntity() != null ?
                getPeopleEntity().findByLastNameP(lastNameP, getCompaniesEntity()) : null;
    }

    public  Person findPersonByLastNameM (String lastNameM){
        return  getPeopleEntity() != null ?
                getPeopleEntity().findByLastNameM(lastNameM, getCompaniesEntity()) : null;
    }

    public Person findPersonByEmail (String email){
        return  getPeopleEntity() != null ?
                getPeopleEntity().findByEmail(email, getCompaniesEntity()) : null;
    }

    public  Person createPerson(Company company, String firstName, String lastNameP, String lastNameM, String country,
                                String email, String username,String password, Date createDate, Date modifyDate){
        return getPeopleEntity() != null ?
                getPeopleEntity().create(company,firstName,lastNameP,lastNameM, country,
                        email, username,password,createDate,modifyDate) : null;
    }

    //public Company createCompany(int id, String name, String ruc, Date createDate, Date modifyDate){
      //  return getCompaniesEntity() != null ?
        //        getCompaniesEntity().create(id,name,ruc,createDate,modifyDate) : null;
    //}

    public boolean deletePerson(int id){
        return getPeopleEntity() != null ?
                getPeopleEntity().delete(id) : false;
    }

    public boolean updatePerson (Person person, CompaniesEntity companiesEntity) {
            return getPeopleEntity() != null ?
                    getPeopleEntity().updateFirstName(person, companiesEntity) : false;
    }

    public boolean deleteCompany(int id){
        return getCompaniesEntity() != null ?
                getCompaniesEntity().delete(id) : false;
    }

    public boolean updateCompany (Company company) {
        return getCompaniesEntity() != null ?
                getCompaniesEntity().updateName(company) : false;
    }

    public Question findQuestionByDescriptionQuestion (String descriptionQuestion){
        return getQuestionsEntity() != null ?
                getQuestionsEntity().findByDescriptionQuestion(descriptionQuestion) : null;
    }

    public boolean updateDescriptionQuestion (Question question) {
        return getQuestionsEntity() != null ?
                getQuestionsEntity().updateDescriptionQuestion(question) : false;
    }

    protected AnswersEntity getAnswersEntity(){
        if(getConnection() != null){
            if(answersEntity == null){
                answersEntity = new AnswersEntity();
                answersEntity.setConnection(getConnection());
            }
        }
        return answersEntity;
    }

    public Answer findAnswerByDescriptionAnswer (String descriptionAnswer, QuestionsEntity questionsEntity){
        return getAnswersEntity() != null ?
                getAnswersEntity().findByDescriptionAnswer(descriptionAnswer, questionsEntity) : null;
    }

    public boolean updateDescriptionAnswer (Answer answer, QuestionsEntity questionsEntity) {
        return getAnswersEntity() != null ?
                getAnswersEntity().updateDescriptionAnswer(answer, questionsEntity) : false;
    }

    protected ScoresEntity getScoresEntity(){
        if(getConnection() != null){
            if(scoresEntity == null){
                scoresEntity = new ScoresEntity();
                scoresEntity.setConnection(getConnection());
            }
        }
        return scoresEntity;
    }

    public Score findScoreByVictory (int victory, PeopleEntity peopleEntity, CompaniesEntity companiesEntity){
        return getScoresEntity() != null ?
                getScoresEntity().findByVictory(victory, peopleEntity, companiesEntity) : null;
    }

    public Score findScoreByDefeat (int defeat, PeopleEntity peopleEntity){
        return getScoresEntity() != null ?
                getScoresEntity().findByDefeat(defeat, peopleEntity, companiesEntity) : null;
    }


}
