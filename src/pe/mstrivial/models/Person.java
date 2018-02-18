package pe.mstrivial.models;

import java.util.Date;

public class Person {
    private int id;
    private int companyId;
    private String firstName;
    private String lastNameP;
    private String lastNameM;
    private String country;
    private String email;
    private String username;
    private String password;
    private Date createDate;
    private Date modifyDate;

    public Person() {
    }

    public Person(int id, int companyId, String firstName, String lastNameP, String lastNameM, String country, String email,
                  String username, String password, Date createDate, Date modifyDate) {
        this.id = id;
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastNameP = lastNameP;
        this.lastNameM = lastNameM;
        this.country = country;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }


    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public int getCompanyId() {
        return companyId;
    }

    public Person setCompanyId(int companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastNameP() {
        return lastNameP;
    }

    public Person setLastNameP(String lastNameP) {
        this.lastNameP = lastNameP;
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

    public String getUsername() {
        return username;
    }

    public Person setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Person setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Person setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

}
