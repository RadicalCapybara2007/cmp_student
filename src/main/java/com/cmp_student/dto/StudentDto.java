package com.cmp_student.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @JsonIgnore
    private Integer id;
    private String matricula;
    private String name;
    private String lastName;
    private String phone;
    private String eMail;
    private String address;

}