package com.cmp_student.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cmp_student.dto.HeadersDto;
import com.cmp_student.dto.StudentDto;

import reactor.core.publisher.Flux;

@Service
public class StudentService {

    @Value("${url.base.alumno}")
    private final String customerUrl;
    private final WebClient webClient;

    public StudentService(String customerUrl, WebClient webClient) {
        this.customerUrl = customerUrl;
        this.webClient = webClient;
    }

    public Flux<StudentDto> findAll(HeadersDto headersDto) {
        return webClient.get()
                .uri(customerUrl)
                .retrieve()
                .bodyToFlux(StudentDto.class);
    }

}