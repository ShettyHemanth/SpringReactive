package com.hemanth.ReactivePostgressDemo.controller;

import com.hemanth.ReactivePostgressDemo.Dto.StudentDto;
import com.hemanth.ReactivePostgressDemo.model.Student;
import com.hemanth.ReactivePostgressDemo.repository.StudentRepository;
import com.hemanth.ReactivePostgressDemo.service.StudentService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


class StudentControllerTest
{


    /*
    @Test
    public void getTest()
    {

        webTestClient.get()
                .uri("/details")
                .exchange()
                .expectStatus()
                .isOk();

    }

    @Test
    public void testPut()
    {

        webTestClient.post()
                .uri("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk();
   }

    @Test
    public void testDelete()
    {
        webTestClient.delete()
                .uri("/delete/10")
                .exchange()
                .expectStatus()
                .isOk();
    }




    @Test
    public void testPost()
    {
        Student s=new Student();
        s.setId(1);
        s.setName("Hemanth");
        s.setBranch("Cse");
        s.setEmail("hemanth@gmail.com");

      Mockito.when(studentRepository.save(s)).thenReturn(Mono.just(s));

      webTestClient.post()
              .uri("/add")
              .contentType(MediaType.APPLICATION_JSON)
              .body(BodyInserters.fromObject(s))
              .exchange()
              .expectStatus()
              .isCreated();

    }

     */
    @Autowired
    WebTestClient webTestClient;


    @MockBean
    StudentService ss;




   @Test
   void testGetAll()
   {
         List<StudentDto> result= List.of(new StudentDto(1,"Hemanth","Cse","hemanth@gmail.com"),new StudentDto(2,"ram","ise","ram@gmail.com"));



       when(ss.getAllStudents()).thenReturn((Flux.fromIterable(result)));

       webTestClient.get()
               .uri("/details")
               .exchange()
               .expectStatus()
               .isOk()
               .expectBodyList(StudentDto.class)
               .hasSize(2);



   }


   //approach 2

    @Test
    void test_get_approach2()
    {
//        List<StudentDto> snew=List.of(new StudentDto(1,"Hemanth","cse","hemanth@gmail.com"),new StudentDto(2,"Rahul","ise","Mech"));
//
//        StudentDto s1=new StudentDto(1,"Hemanth","cse","hemanth@gmail.com");
//        StudentDto s2=new StudentDto(2,"Rahul","ise","Mech");
//


        webTestClient.get()
                .uri("/details")
                .exchange()
                .expectStatus()
                .isOk();
//                .returnResult(StudentDto.class)
//                .getResponseBody();

//        System.out.println(flux);
//
//        StepVerifier.create(flux)
//               // .expectNext(s1)
//              //  .expectNext(s2)
//                .verifyComplete();
//


    }






   @Test
   void testPost()
   {
       //List<StudentDto> result= List.of(new StudentDto(1,"Hemanth","Cse","hemanth@gmail.com"),new StudentDto(2,"ram","ise","ram@gmail.com"));
//StudentDto studentDto=new StudentDto(1,"H","d","f");
//       when(ss.addStudent(studentDto)).thenReturn((Mono.just(studentDto)));

       webTestClient.post()
               .uri("/add")
               .exchange()
               .expectStatus()
               .isCreated();



   }
















}