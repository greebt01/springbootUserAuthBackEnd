package com.greene.userauth.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="userpwordauth")
public class People {
    @Id
    @Column(name = "user_Name", nullable = false)
    private String userName;

    @Column(name="pword")
    private String pword;
}
