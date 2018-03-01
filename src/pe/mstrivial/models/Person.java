package pe.mstrivial.models;



import java.util.Date;
//Se crea una clase Person con el diseño de patrón DAO para los detalles específicos del usuario.
public class Person {
    private int id;
    private String firstName;
    private String lastNameF;
    private String lastNameM;
    private String country;
    private String email;
    private String userName;
    private String password;
    private Company company;

    public Person() {
    }

    public Person(int id, String firstName, String lastNameF, String lastNameM, String country, String email, String userName, String password, Company company) {
        this.id = id;
        this.firstName = firstName;
        this.lastNameF = lastNameF;
        this.lastNameM = lastNameM;
        this.country = country;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastNameF() {
        return lastNameF;
    }

    public Person setLastNameF(String lastNameF) {
        this.lastNameF = lastNameF;
        return this;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public Person setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Person setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Person setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Person setCompany(Company company) {
        this.company = company;
        return this;
    }

}