package com.hemanth.ReactivePostgressDemo.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StudentDto
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
