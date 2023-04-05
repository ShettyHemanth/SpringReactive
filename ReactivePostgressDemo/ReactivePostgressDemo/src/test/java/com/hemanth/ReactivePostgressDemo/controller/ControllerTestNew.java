package com.hemanth.ReactivePostgressDemo.controller;

import com.hemanth.ReactivePostgressDemo.Dto.StudentDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ControllerTestNew
{
    @Autowired
    WebTestClient webTestClient;

    @MockBean
    StudentController studentController;

    @Test
   void testPost()
   {
       StudentDto snew=new StudentDto(1,"hemanth","cse","hemanth@gmail.com");

       when(studentController.addDetails(snew)).thenReturn(Mono.just(snew));

       webTestClient.post()
               .uri("/add")
               .contentType(MediaType.APPLICATION_JSON)
               .body(BodyInserters.fromObject(snew))
               .exchange()
               .expectStatus()
               .isCreated();

   }


   @Test
   void testGet()
   {
       List<StudentDto> result= List.of(new StudentDto(1,"hemanth","cse","hemanth@gmail.com"),new StudentDto(2,"rahul","cse","hemanth@gmail.com"));

       when(studentController.getDetails()).thenReturn(Flux.fromIterable(result));

       webTestClient.get()
               .uri("/details")
               .exchange()
               .expectStatus()
               .isOk()
               .expectBodyList(StudentDto.class)
               .hasSize(2);


   }

   @Test
   void testDelete()
   {
       Mono<Void> test=Mono.empty();

       when(studentController.deleteStudents(1)).thenReturn(test);

       webTestClient.delete()
               .uri("/delete/{id}",1)
               .exchange()
               .expectStatus()
               .isOk();

   }

   @Test
   void testUpdate()
   {
       StudentDto snew=new StudentDto(1,"hemanth","cse","hemanth@gmail.com");

       when(studentController.updateStudents(snew)).thenReturn(Mono.just(snew));

       webTestClient.put()
               .uri("/update")
               .contentType(MediaType.APPLICATION_JSON)
               .body(BodyInserters.fromObject(snew))
               .exchange()
               .expectStatus()
               .isCreated();

   }
}
