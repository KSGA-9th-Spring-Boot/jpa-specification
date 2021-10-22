package com.example.springdatajpaspecification;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentCriteria {
    private Long universityId;
    private String studentName;
}
