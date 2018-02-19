package pe.mstrivial.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleEntity extends BaseEntity{
    private static String DEFAULT_SQL= "SELECT * FROM trivial_world.people";

    private List<Person> findByCriteria (String sql){
        List<Person> people;
        if(getConnection() != null){
            people = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Person person = new Person()
                            .setId(resultSet.getInt("id"))
                            .setCompanyId(resultSet.getInt("id_company"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastNameP(resultSet.getString("last_name_p"))
                            .setLastNameM(resultSet.getString("last_name_m"))
                            .setCountry(resultSet.getString("country"))
                            .setEmail(resultSet.getString("email"))
                            .setUsername(resultSet.getString("username"))
                            .setPassword(resultSet.getString("password"))
                            .setCreateDate(resultSet.getDate("create_date"))
                            .setModifyDate(resultSet.getDate("modify_create"));
                    people.add(person);
                }
                return people;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Person> findAll() {

        return findByCriteria(DEFAULT_SQL);
    }

    public Person findById(int id) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (people != null ? people.get(0) : null);
    }

    public Person findByIdCompany(int companyId) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE id_company = '" + companyId+ "'");
        return (people != null ? people.get(0) : null);
    }


    public Person findByFirstName(String firstName) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE first_name = '" + firstName+ "'");
        return (people != null ? people.get(0) : null);
    }

    public Person findByLastNameP(String lastNameP) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE last_name_p = '" + lastNameP+ "'");
        return (people != null ? people.get(0) : null);
    }

    public Person findByLastNameM (String lastNameM) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE last_name_m = '" + lastNameM+ "'");
        return (people != null ? people.get(0) : null);
    }

    public Person findByCountry (String country) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE country = '" +country+ "'");
        return (people != null ? people.get(0) : null);
    }

    public Person findByEmail (String email) {
        List<Person> people = findByCriteria(DEFAULT_SQL +
                " WHERE email = '" +email+ "'");
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

    public Person create (int companyId, String firstName, String lastNameP, String lastNameM, String country, String email, String username,
    String password, Date createDate, Date modifyDate){
        if (findByFirstName(firstName) == null){
            if (getConnection() != null) {
                String sql = "INSERT INTO people (id, id_company, first_name, last_name_p, last_name_m,country, " +
                        "email,username,password,create_date, modify_date) VALUES ("+
                        String.valueOf(getMaxId()+1)+", '"+firstName+"' , '"+companyId+", '"+firstName+"' , '"+lastNameP+"' , '"
                        +"' , '"+lastNameM+"' , '"+country+"' , '"+email+"' , '"+username+"' , '"+password+"' ,"+createDate+", "+modifyDate+")";
                int results = updateByCriteria(sql);
                if (results > 0){
                    Person person = new Person(getMaxId(), companyId, firstName,lastNameP, lastNameM, country,email, username,
                            password, createDate, modifyDate);
                    return  person;
                }
            }
        }
        return  null;
    }

    public boolean updateFirstName (Person person){
        if(findByFirstName(person.getFirstName()) != null) return false;
        return updateByCriteria(
                "UPDATE people SET fist_name = '"+person.getFirstName()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }


    public boolean updateLastNameP (Person person){
        if(findByLastNameP(person.getLastNameP()) != null) return false;
        return updateByCriteria(
                "UPDATE people SET last_name_p= '"+person.getLastNameP()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }

    public boolean updateLastNameM (Person person){
        if(findByLastNameM(person.getLastNameM()) != null) return false;
        return updateByCriteria(
                "UPDATE people SET last_name_m= '"+person.getLastNameM()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }

    public boolean updateCountry(Person person){
        if(findByCountry(person.getCountry()) != null) return false;
        return updateByCriteria(
                "UPDATE people SET country= '"+person.getCountry()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }

    public boolean updateEmail (Person person){
        if(findByEmail(person.getEmail()) != null) return false;
        return updateByCriteria(
                "UPDATE people SET email= '"+person.getEmail()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }

    public boolean updatePassword (Person person){
        return updateByCriteria(
                "UPDATE people SET password= '"+person.getPassword()+"'"+
                        "WHERE id="+String.valueOf(person.getId())) > 0;
    }


}
