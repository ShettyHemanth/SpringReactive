package com.hemanth.ReactivePostgressDemo.controller;

import com.hemanth.ReactivePostgressDemo.Dto.StudentDto;
import com.hemanth.ReactivePostgressDemo.model.Student;
import com.hemanth.ReactivePostgressDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentController
{
    StudentService ss;

    @Autowired
    public StudentController(StudentService studentService)
    {
        ss=studentService;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/details")
    @ResponseStatus(value=HttpStatus.OK)
    public Flux<StudentDto> getDetails()
    {
        return ss.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<StudentDto> addDetails(@RequestBody StudentDto studentDto)
    {
        return ss.addStudent(studentDto);
    }


    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteStudents(@PathVariable int id)
    {
        return ss.deleteById(id);

    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update")
    @ResponseStatus(value = HttpStatus.CREATED)

    public Mono<StudentDto> updateStudents(@RequestBody StudentDto stud)
    {
        return ss.updateById(stud);

    }

    @RequestMapping(method = RequestMethod.DELETE,value="/delete/all")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteAll()
    {
        return ss.deleteAll();
    }



}
