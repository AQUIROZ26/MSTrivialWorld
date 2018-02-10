package pe.mstrivial.models;

import java.util.Date;

public class Person {
    private int id;
    private String firstName;
    private String lastNameP;
    private String lastNameM;
    private String gender;
    private String country;
    private String province;
    private String phoneNumber;
    private String email;
    private Date createDate;
    private Date modifyDate;

    public Person (){

    }

    public Person (int id, String firstName, String lastNameP, String lastNameM, String gender, String country,
                   String province, String phoneNumber, String email, Date createDate, Date modifyDate){
        this.id= id;
        this.firstName= firstName;
        this.lastNameP= lastNameP;
        this.lastNameM= lastNameM;
        this.gender= gender;
        this.country= country;
        this.province= province;
        this.phoneNumber= phoneNumber;
        this.email= email;
        this.createDate= createDate;
        this.modifyDate= modifyDate;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return  this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return  this;
    }

    public String getLastNameP() {
        return lastNameP;
    }

    public Person setLastNameP(String lastNameP) {
        this.lastNameP = lastNameP;
        return  this;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public Person setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
        return  this;
    }

    public String getGender() {
        return gender;
    }

    public Person setGender(String gender) {
        this.gender = gender;
        return  this;
    }

    public String getCountry() {
        return country;
    }

    public Person setCountry(String country) {
        this.country = country;
        return  this;
    }

    public String getProvince() {
        return province;
    }

    public Person setProvince(String province) {
        this.province = province;
        return  this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return  this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return  this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Person setCreateDate(Date createDate) {
        this.createDate = createDate;
        return  this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public Person setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return  this;
    }
}
