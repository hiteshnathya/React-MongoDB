package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class EmployeeController<e> {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = {"/create","/"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Employee e){
        employeeService.create(e);
    }


    @RequestMapping(value = {"/id"}, method = RequestMethod.GET)
    public ResponseEntity<Mono<Employee>> findById(@PathVariable("id")Integer id)
    {
        Mono<Employee> e= employeeService.findById(id);
        return new ResponseEntity<Mono<Employee>>(e,HttpStatus.FOUND);
    }


    @RequestMapping(value = {"/name{/name}"}, method = RequestMethod.GET)
    Flux<Employee>findByName(String name){

        return employeeService.findByName(name);
    }


    Flux<Employee>findAll(){
         Flux<Employee> emps=employeeService.findAll();
         return emps;
    }

    }

