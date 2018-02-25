package pe.mstrivial.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleEntity extends BaseEntity{
    private static String DEFAULT_SQL= "SELECT * FROM trivial_world.people";

    private List<Person> findByCriteria (String sql, CompaniesEntity companiesEntity){
        List<Person> people = new ArrayList<>();
        if(getConnection() != null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Person person = new Person(
                            resultSet.getInt("id"),
                            companiesEntity.findById(resultSet.getInt("id_company")),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name_p"),
                            resultSet.getString("last_name_m"),
                            resultSet.getString("country"),
                            resultSet.getString("email"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getDate("create_date"),
                            resultSet.getDate("modify_create"));
                    people.add(person);
                }
                return people;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Person> findAll(CompaniesEntity companiesEntity) {

        return findByCriteria(DEFAULT_SQL,companiesEntity);
    }

    public Person findById(int id, CompaniesEntity companiesEntity) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id),companiesEntity);
        return (people != null ? people.get(0) : null);
    }

    public List<Person> findByCompany(Company company, CompaniesEntity companiesEntity) {
        String criteria = "company_id = " + company.getId();
        return findByCriteria(criteria, companiesEntity);
    }


    public Person findByFirstName(String firstName, CompaniesEntity companiesEntity) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE first_name = '" + firstName+ "'",companiesEntity);
        return (people != null ? people.get(0) : null);
    }

    public Person findByLastNameP(String lastNameP, CompaniesEntity companiesEntity) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE last_name_p = '" + lastNameP+ "'", companiesEntity);
        return (people != null ? people.get(0) : null);
    }

    public Person findByLastNameM (String lastNameM, CompaniesEntity companiesEntity) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE last_name_m = '" + lastNameM+ "'", companiesEntity);
        return (people != null ? people.get(0) : null);
    }

    public Person findByCountry (String country, CompaniesEntity companiesEntity) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE country = '" +country+ "'", companiesEntity);
        return (people != null ? people.get(0) : null);
    }

    public Person findByEmail (String email, CompaniesEntity companiesEntity) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE email = '" +email+ "'", companiesEntity);
        return (people != null ? people.get(0) : null);
    }

    private int updateByCriteria(String sql) {
        if (getConnection() != null) {
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
        public boolean delete(int id) {
            return updateByCriteria("DELETE FROM people WHERE id = " + String.valueOf(id)) > 0;
        }


    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM people";
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ?
                        resultSet.getInt("max_id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public Person create (Company company, String firstName, String lastNameP, String lastNameM, String country, String email, String username,
                          String password, Date createDate, Date modifyDate){
        //if (findByEmail(email) == null){
            if (getConnection() != null) {
                String sql = "INSERT INTO people (id, id_company, first_name, last_name_p, last_name_m,country, " +
                        "email,username,password,create_date, modify_date) VALUES ("+
                        String.valueOf(getMaxId()+1)+", '"+firstName+"' , "+company.getId()+", '"+firstName+"' , '"+lastNameP+"' ,  '"+lastNameM+"' , '"+country+"' , '"+email+"' , '"+username+"' , '"+password+"' ,"+createDate+", "+modifyDate+")";
                int results = updateByCriteria(sql);
                if (results > 0){
                    Person person = new Person(getMaxId(), company, firstName,lastNameP, lastNameM, country,email, username,
                            password, createDate, modifyDate);
                    return  person;
                }
            }
        //}
        return  null;
    }


    public boolean updateFirstName (Person person, CompaniesEntity companiesEntity){
        if(findByFirstName(person.getFirstName(),companiesEntity) != null) return false;
        return updateByCriteria(
                "UPDATE people SET fist_name = '"+person.getFirstName()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }


    public boolean updateLastNameP (Person person, CompaniesEntity companiesEntity){
        if(findByLastNameP(person.getLastNameP(),companiesEntity) != null) return false;
        return updateByCriteria(
                "UPDATE people SET last_name_p= '"+person.getLastNameP()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }

    public boolean updateLastNameM (Person person, CompaniesEntity companiesEntity){
        if(findByLastNameM(person.getLastNameM(), companiesEntity) != null) return false;
        return updateByCriteria(
                "UPDATE people SET last_name_m= '"+person.getLastNameM()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }

    public boolean updateCountry(Person person, CompaniesEntity companiesEntity){
        if(findByCountry(person.getCountry(), companiesEntity) != null) return false;
        return updateByCriteria(
                "UPDATE people SET country= '"+person.getCountry()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }

    public boolean updateEmail (Person person, CompaniesEntity companiesEntity){
        if(findByEmail(person.getEmail(), companiesEntity) != null) return false;
        return updateByCriteria(
                "UPDATE people SET email= '"+person.getEmail()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }

    public boolean updatePassword (Person person, CompaniesEntity companiesEntity){
        return updateByCriteria(
                "UPDATE people SET password= '"+person.getPassword()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }


}
