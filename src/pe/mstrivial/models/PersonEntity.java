package pe.mstrivial.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonEntity extends BaseEntity{
    private static String DEFAULT_SQL= "SELECT * FROM hr.people";

    private List<Person> findByCriteria (String sql){
        List<Person> people;
        if(getConnection() != null){
            people = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Person region = new Person()
                            .setId(resultSet.getInt("id"))
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastNameP(resultSet.getString("last_name_p"))
                            .setLastNameM(resultSet.getString("last_name_m"))
                            .setGender(resultSet.getString("gender"))
                            .setCountry(resultSet.getString("country"))
                            .setProvince(resultSet.getString("province"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .setEmail(resultSet.getString("email"))
                            .setCreateDate(resultSet.getDate("create_date"))
                            .setModifyDate(resultSet.getDate("modify_create"));
                    people.add(region);
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

    public Person (String firstName, String lastNameP, String lastNameM, String gender, String country, String province,
                   String phone_number, String email, Date create_date, Date modifiy_date) {
        if(findByFirstName(firstName) == null && findByLastNameP(lastNameP) == null && findByLastNameM(lastNameM)==null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO people(" +
                        "id, first_name, last_name_p,last_name_m," +
                        "gender, country, province, phone_number,email," +
                        "create_date,modify_date) " +
                        "VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '" +
                        firstName +","+lastNameP+","+lastNameM+ "')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    Person person = new Person(getMaxId(), firstName, lastNameP, lastNameM);
                    return person;
                }
            }
        }
        return null;
    }


}
