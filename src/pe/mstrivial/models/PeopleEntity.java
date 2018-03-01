package pe.mstrivial.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM people";
    private Company company;
    private List<Person> findByCriteria(String sql, CompaniesEntity companiesEntity) {
        List<Person> people = new ArrayList<>();
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while(resultSet.next()) {
                    Person person = new Person(
                            resultSet.getInt("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name_p"),
                            resultSet.getString("last_name_m"),
                            resultSet.getString("country"),
                            resultSet.getString("email"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            companiesEntity
                                    .findById(resultSet
                                            .getInt("company_id"))
                    );
                    people.add(person);
                }
                return people;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Person> findAll(CompaniesEntity companiesEntity) {
        return findByCriteria(DEFAULT_SQL, companiesEntity);
    }

    public Person findById (int id, CompaniesEntity companiesEntity){
        List<Person> people = findByCriteria(DEFAULT_SQL+
                " WHERE id = "+String.valueOf(id),companiesEntity);
        return (people != null && !people.isEmpty() ? people.get(0) : null);
    }

    public Person findByFirstName (String firstName, CompaniesEntity companiesEntity){
        List<Person> people = findByCriteria(DEFAULT_SQL+
                " WHERE first_name = "+String.valueOf(firstName),companiesEntity);
        return (people != null && !people.isEmpty() ? people.get(0) : null);
    }

    public Person findByLastNameF (String lastNameF, CompaniesEntity companiesEntity){
        List<Person> people = findByCriteria(DEFAULT_SQL+
                " WHERE last_name_p = "+String.valueOf(lastNameF),companiesEntity);
        return (people != null && !people.isEmpty() ? people.get(0) : null);
    }

    public Person findByLastNameM (String lastNameM, CompaniesEntity companiesEntity){
        List<Person> people = findByCriteria(DEFAULT_SQL+
                " WHERE last_name_m = "+String.valueOf(lastNameM),companiesEntity);
        return (people != null && !people.isEmpty() ? people.get(0) : null);
    }

    public Person findByCountry (String country, CompaniesEntity companiesEntity){
        List<Person> people = findByCriteria(DEFAULT_SQL+
                " WHERE country = "+String.valueOf(country),companiesEntity);
        return (people != null && !people.isEmpty() ? people.get(0) : null);
    }

    public Person findByEmail (String email, CompaniesEntity companiesEntity){
        List<Person> people = findByCriteria(DEFAULT_SQL+
                " WHERE email= "+String.valueOf(email),companiesEntity);
        return (people != null && !people.isEmpty() ? people.get(0) : null);
    }

    public Person findByUserName (String userName, CompaniesEntity companiesEntity){
        List<Person> people = findByCriteria(DEFAULT_SQL+
                " WHERE username= "+String.valueOf(userName),companiesEntity);
        return (people != null && !people.isEmpty() ? people.get(0) : null);
    }

    public Person findByPassword (String password, CompaniesEntity companiesEntity){
        List<Person> people = findByCriteria(DEFAULT_SQL+
                " WHERE password= "+String.valueOf(password),companiesEntity);
        return (people != null && !people.isEmpty() ? people.get(0) : null);
    }

    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
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
        return updateByCriteria("DELETE FROM companies WHERE id = " + String.valueOf(id)) > 0;
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

    public Person create(String firstName, String lastNameF, String lastNameM, String country, String email,
                         String userName, String password, Company company,CompaniesEntity companiesEntity) {
        if(findByFirstName(firstName, companiesEntity) == null &&
                findByLastNameF(lastNameF,companiesEntity)==null&&
                findByLastNameM(lastNameM,companiesEntity)==null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO people (id, first_name, last_name_p, last_name_m, " +
                        "country, email, username, password, company_id) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '"
                        +firstName + "', '"
                        +lastNameF+"', '"
                        +lastNameM+"', '"
                        +country+"', '"
                        +email+"', '"
                        +userName+"', '"
                        +password+"', "
                        +company+")";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    Person person = new Person (getMaxId(), firstName, lastNameF, lastNameM, country, email,
                            userName, password, company);
                    return person;
                }
            }
        }
        return null;
    }

    public boolean update(Person person, CompaniesEntity companiesEntity) {
        if(findByFirstName(person.getFirstName(), companiesEntity) !=null &&
                findByLastNameF(person.getLastNameF(),companiesEntity) != null &&
                findByLastNameM(person.getLastNameM(),companiesEntity) != null &&
                findByEmail(person.getEmail(),companiesEntity) !=null &&
                findByCountry(person.getCountry(),companiesEntity)!=null &&
                findByUserName(person.getUserName(),companiesEntity) != null &&
                findByPassword(person.getPassword(),companiesEntity) != null) return false;
        return updateByCriteria(
                "UPDATE people SET " +
                        "first_name  = '"+person.getFirstName()+ "', " +
                        "last_name_p = '"+person.getLastNameF()+"', "+
                        "last_name_m = '"+person.getLastNameM()+ "', " +
                        "email = '" +person.getEmail() + "', " +
                        "country = '" +person.getCountry() + "', " +
                        "username =  '" +person.getUserName() + "', " +
                        "password = '" +person.getPassword() + "', " +
                        "company_id = '" + person.getCompany() +
                        " WHERE id = " + String.valueOf(person.getId())) > 0;
    }



}
