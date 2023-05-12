package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "uesrnic")
public class RestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="nic_number",length=12)
    private String nic;

    @Column(name = "Phone_Number")
    private String pno;
    @Column(name = "full_name",length = 50)
    private String name;
    @Column(name = "Address")
    private String Address;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "Birth_Day")
    private String birthday;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Age",nullable = false)
    private long age;

    public RestModel() {
    }

    public RestModel(Integer id, String nic, String pno, String name, String address, String nationality ,String birthday , String gender , long age) {
        this.id = id;
        this.nic = nic;
        this.pno = pno;
        this.name = name;
        this.Address = address;
        this.nationality = nationality;
        this.birthday = birthday ;
        this.gender = gender ;
        this.age = age ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
