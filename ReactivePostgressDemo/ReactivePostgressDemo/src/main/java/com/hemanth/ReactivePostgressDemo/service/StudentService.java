package com.hemanth.ReactivePostgressDemo.service;

import com.hemanth.ReactivePostgressDemo.Dto.MapperClass;
import com.hemanth.ReactivePostgressDemo.Dto.StudentDto;
import com.hemanth.ReactivePostgressDemo.model.Student;
import com.hemanth.ReactivePostgressDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService
{
    StudentRepository studentRepository;
    MapperClass mapperClass;

    @Autowired
    public StudentService(StudentRepository sr,MapperClass mp)
    {

        studentRepository=sr;
        mapperClass=mp;
    }


    public Flux<StudentDto> getAllStudents()
    {

        Flux<Student> studentData= studentRepository.findAll();
        return studentData.map((s)->mapperClass.toDto(s));



    }

    public Mono addStudent(StudentDto studentDto)
    {
        Student snew;

        snew=mapperClass.toStudent(studentDto);


         return studentRepository.save(snew).map(MapperClass::toDto);

    }

    public Mono<Void> deleteById(int id)
    {

        return studentRepository.deleteById(id);


    }

    public Mono<StudentDto>updateById(StudentDto sdto)
    {
        Student stud=mapperClass.toStudent(sdto);


        Mono<Student> result= studentRepository.findById(stud.getId())
                .switchIfEmpty(Mono.error(new Exception("User is not Found")))
                .flatMap(s->{
                    if(stud.getName()!=null)
                        s.setName(stud.getName());
                    if(stud.getBranch()!=null)
                        s.setBranch(stud.getBranch());
                    if(stud.getEmail()!=null)
                        s.setEmail(stud.getEmail());
//                    return s;
                    return studentRepository.save(s);

                });

        return result.map((s)-> mapperClass.toDto(s));
//                .flatMap(studentRepository::save);

    }

    public Mono<Void> deleteAll()
    {
        return studentRepository.deleteAll();
    }


}
