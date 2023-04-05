package com.hemanth.ReactivePostgressDemo.Dto;

import com.hemanth.ReactivePostgressDemo.model.Student;
import org.springframework.stereotype.Component;

@Component
public class MapperClass
{
   public static StudentDto toDto(Student stud)
   {
       StudentDto studentDto=new StudentDto();
       studentDto.setId(stud.getId());
       studentDto.setName(stud.getName());
       studentDto.setBranch(stud.getBranch());
       studentDto.setEmail(stud.getEmail());

       return studentDto;

   }

   public static Student toStudent(StudentDto studentDto)
   {
       Student s=new Student();
       s.setId(studentDto.getId());
       s.setName(studentDto.getName());
       s.setBranch(studentDto.getBranch());
       s.setEmail(studentDto.getEmail());
       return s;

   }
}
