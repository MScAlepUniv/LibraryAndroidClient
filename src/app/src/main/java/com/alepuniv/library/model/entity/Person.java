package com.alepuniv.library.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.util.TableInfo;

import java.util.Date;

@Entity(tableName = "Persons")
public class Person {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id", typeAffinity = ColumnInfo.INTEGER)
    private int id;

    @ColumnInfo(name = "FirstName", typeAffinity = ColumnInfo.TEXT)
    private String firstName;

    @ColumnInfo(name = "FatherName", typeAffinity = ColumnInfo.TEXT)
    private String fatherName;

    @ColumnInfo(name = "LastName", typeAffinity = ColumnInfo.TEXT)
    private String lastName;

    @ColumnInfo(name = "Address", typeAffinity = ColumnInfo.TEXT)
    private String address;

    @ColumnInfo(name = "Image", typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    @ColumnInfo(name = "NationalId", typeAffinity = ColumnInfo.INTEGER)
    private int nationalId;

    public Person(int id, String firstName, String fatherName, String lastName, String address, byte[] image, int nationalId) {
        this.id = id;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.lastName = lastName;
        this.address = address;
        this.image = image;
        this.nationalId = nationalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }
}
