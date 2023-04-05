package com.hemanth.ReactivePostgressDemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")

public class Student
{

@Id
@Column(value = "usn")
int id;

    @Column(value="name")
String name;

    @Column(value="branch")
String branch;

    @Column(value="email")
    String email;

}
