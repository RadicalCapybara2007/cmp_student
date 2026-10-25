package com.cmp_student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmp_student.dto.HeadersDto;
import com.cmp_student.dto.StudentDto;
import com.cmp_student.service.StudentService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping 
    public Flux<StudentDto> rent(@RequestHeader(name = "flow") String flow) {
        HeadersDto headersDto = HeadersDto.builder().flow(flow).build();
        return studentService.findAll(headersDto);
                
    }

}