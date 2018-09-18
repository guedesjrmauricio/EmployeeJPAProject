package com.example.model;


import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table( name = "EMPLOYEE" )
public class Employee
    implements Serializable{

    private static final long serialVersionUID = 1L;

    @SequenceGenerator( name = "EMP_ID_GEN", sequenceName = "EMP_ID_SEQ", allocationSize = 50 )
    @GeneratedValue( generator = "EMP_ID_GEN" )
    @Id
    @Column( name = "ID", nullable = false )
    private int id;
    
    @Column( name = "FIRSTNAME", nullable = false )
    private String firstName;
    
    @Column( name = "LASTNAME", nullable = false )
    private String lastName;
    
    @Temporal( TemporalType.DATE )
    @Column( name = "BIRTHDATE", nullable = false )
    private Date birthDate;
    
    @Transient
    private float salary;

    public Employee(String firstName, String lastName, Date birthDate, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public float getSalary() {
        return salary;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID:   " + getId() + "\n"
                + "Employee Name: " + getFirstName() + " " + getLastName() + "\n"
                + "Birth Date:    " + new SimpleDateFormat("MMM d, yyyy").format(getBirthDate()) + "\n"
                + "Salary:        " + NumberFormat.getCurrencyInstance().format((double) getSalary());
    }
}
