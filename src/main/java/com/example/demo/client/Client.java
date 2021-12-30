package com.example.demo.client;
import javax.persistence.*;
/* Entity maps to the class that is essentially creating D.B. (this one) */
@Entity
@Table /* telling DB to make new table in the DB called client */
public class Client{
    @Id  // These are the id's auto assigned to new clients
    @SequenceGenerator(
            name = "clients_sequence",
            sequenceName = "clientIDs",  // They need to change so that clients are recognized by there phone or email
            allocationSize = 1  // Currently, just increments by one (long data type)
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clients_sequence" // The name of the sequence generator to be referenced by in the DB
    )
    private Long id;
    private String name;
    private String email;
    private String phone;
    private double freeQuote;
    private String toClean;
    private double sqFeet;
    private Integer stories;



    private Integer objects;
    private String notes;
    // This default constructor is critical to establishing DB retrieval in browser
    public Client(){
    }
    public Client(String phone, String email, String name,String toClean, Integer sqFeet, Integer stories,Integer objects, String notes) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.notes = notes;
        this.sqFeet = sqFeet;
        this.toClean = toClean;
        this.stories = stories;
        this.objects = objects;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public double getSqFeet() {
        return sqFeet;
    }
    public void setSqFeet(Integer sqFeet) {
        this.sqFeet = sqFeet;
    }
    public double getFreeQuote() {
        return freeQuote;
    }
    public void setFreeQuote(double freeQuote) {
        this.freeQuote = freeQuote;
    }
    public String getToClean() {
        return toClean;
    }
    public void setToClean(String toClean) {
        this.toClean = toClean;
    }
    public Integer getStories() {
        return stories;
    }
    public Integer getObjects() {
        return objects;
    }
    public void setObjects(Integer objects) {
        this.objects = objects;
    }

    public void setStories(Integer stories) {
        this.stories = stories;
    }
    // This method seems to not even do anything
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id + '\n' +
                "phone= " + phone + '\n' +
                ", email= " + email + '\n' +
                ", name= " + name + '\n' +
                ", notes= " + notes+ '\n'+
                '}';
    }
}
