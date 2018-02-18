package pe.mstrivial.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TwService {
    Connection connection;
    PeopleEntity peopleEntity;
    CategoriesEntity categoriesEntity;
    QuestionsEntity questionsEntity;

    private Connection getConnection(){
        if (connection == null){
            try {
                connection = ((DataSource) InitialContext
                .doLookup("jdbc/MySQLDataSource"))
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
        return getPeopleEntity() != null ? getPeopleEntity().findById(id) : null;
    }


}
