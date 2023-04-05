package com.hemanth.ReactivePostgressDemo.repository;

import com.hemanth.ReactivePostgressDemo.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student,Integer>
{

}
