package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.Repository;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository <Employee, Integer>
{

    @Query("{'name':?0")
    Flux<Employee> findByName(String name);
}
