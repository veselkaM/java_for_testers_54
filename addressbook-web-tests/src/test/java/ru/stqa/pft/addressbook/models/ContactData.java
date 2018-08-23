package ru.stqa.pft.addressbook.models;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id;

    @Expose
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Expose
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "company")
    private String company;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;

    @Column(name = "email")
    @Type(type = "text")
    private String emailOne;

    @Column(name = "email2")
    @Type(type = "text")
    private String emailTwo;

    @Column(name = "email3")
    @Type(type = "text")
    private String emailThree;

    @Column(name = "notes")
    @Type(type = "text")
    private String notes;

    @Transient
    private String group;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getMiddlename() {
        return middlename;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }


    public String getEmailOne() {
        return emailOne;
    }

    public ContactData withEmailOne(String emailOne) {
        this.emailOne = emailOne;
        return this;
    }

    public String getEmailTwo() {
        return emailTwo;
    }

    public ContactData withEmailTwo(String emailTwo) {
        this.emailTwo = emailTwo;
        return this;
    }

    public String getEmailThree() {
        return emailThree;
    }

    public ContactData withEmailThree(String emailThree) {
        this.emailThree = emailThree;
        return this;
    }


    public String getGroup() {
        return group;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, lastname);
    }
}
