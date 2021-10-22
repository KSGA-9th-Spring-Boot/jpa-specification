package com.example.springdatajpaspecification.repository.spec;

import com.example.springdatajpaspecification.StudentCriteria;
import com.example.springdatajpaspecification.entitiy.Student;
import com.example.springdatajpaspecification.entitiy.University;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class StudentSpecification implements Specification<Student> {
    private StudentCriteria studentCriteria;

    @Override
    public Predicate toPredicate(
            Root<Student> root,
            CriteriaQuery<?> query,
            CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        if (studentCriteria.getUniversityId() == null) return null;
        else {
            Join<Student, University> join = root.join("university", JoinType.INNER);
            predicates.add(cb.equal(join.get("id"), studentCriteria.getUniversityId()));
        }
        predicates.add(
                cb.like(cb.lower(root.get("name")),
                "%" + studentCriteria.getStudentName().toLowerCase() + "%")
        );

        Predicate[] pre = new Predicate[predicates.size()];
        return cb.and(predicates.toArray(pre));
    }
}
