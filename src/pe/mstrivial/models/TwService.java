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

    protected PeopleEntity getPeopleEntity(){
        if(getConnection() != null){
            if(peopleEntity == null){
                peopleEntity = new PeopleEntity();
                peopleEntity.setConnection(getConnection());
            }
        }
        return peopleEntity;
    }

    protected CategoriesEntity getCategoriesEntity(){
        if(getConnection()!= null){
            if(categoriesEntity==null){
                categoriesEntity = new CategoriesEntity();
                categoriesEntity.setConnection(getConnection());
            }
        }
        return categoriesEntity;
    }

    public List<Person> findAllPeople(){
        return getPeopleEntity() != null ? getPeopleEntity().findAll() : null;
    }

    public List<Category> findAllCategories(){
        return getCategoriesEntity() != null ? getCategoriesEntity().findAll() : null;
    }

    public Person findPersonById (int id){
        return getPeopleEntity() != null ?
                getPeopleEntity().findById(id) : null;
    }

    public Person findPersonByFirstName (String firstName){
        return getPeopleEntity() != null ?
                getPeopleEntity().findByFirstName(firstName) : null ;
    }

    public Person findPersonByLastNameP (String lastNameP){
        return getPeopleEntity() != null ?
                getPeopleEntity().findByLastNameP(lastNameP) : null;
    }

    public  Person findPersonByLastNameM (String lastNameM){
        return  getPeopleEntity() != null ?
                getPeopleEntity().findByLastNameM(lastNameM) : null;
    }

    public Person findPersonByEmail (String email){
        return  getPeopleEntity() != null ?
                getPeopleEntity().findByEmail(email) : null;
    }

    public  Person createPerson(int companyId, String firstName, String lastNameP, String lastNameM, String country,
                                String email, String username,String password, Date createDate, Date modifyDate){
        return getPeopleEntity() != null ?
                getPeopleEntity().create(companyId,firstName,lastNameP,lastNameM, country,
                        email, username,password,createDate,modifyDate) : null;
    }

    public boolean deletePerson(int id){
        return getPeopleEntity() != null ?
                getPeopleEntity().delete(id) : false;
    }

    public boolean updatePerson (Person person) {
            return getPeopleEntity() != null ?
                    getPeopleEntity().updateFirstName(person) : false;
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

    public Score findScoreByVictory (int victory, PeopleEntity peopleEntity){
        return getScoresEntity() != null ?
                getScoresEntity().findByVictory(victory, peopleEntity) : null;
    }

    public Score findScoreByDefeat (int defeat, PeopleEntity peopleEntity){
        return getScoresEntity() != null ?
                getScoresEntity().findByDefeat(defeat, peopleEntity) : null;
    }


}
