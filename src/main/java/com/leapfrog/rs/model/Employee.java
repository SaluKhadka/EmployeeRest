package com.leapfrog.rs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity

public class Employee {
    @Id
    private int id;
    private String name,address;
    private Date created;

    public Employee() {
    }

    public Employee(int id,String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.created = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", created=" + created +
                '}';
    }
}
