package com.Scope.scopeapi.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
@EntityListeners(AuditingEntityListener.class)
public class Instructor {
    @Id
    private String NetId;
    @Column(name ="firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;



    public String getNetId() {
        return NetId;
    }
    public void setNetId(String netId) {
        NetId = netId;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return NetId + " " + firstName + " " + lastName;
    }
}
