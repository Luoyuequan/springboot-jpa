package com.springboot.learn.jpa.controller;

import com.springboot.learn.jpa.bean.Classes;
import com.springboot.learn.jpa.bean.Student;
import com.springboot.learn.jpa.repository.ClassesRepository;
import com.springboot.learn.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author luoyuequan
 * @time 2019/11/28 10:29
 */
@RestController
@RequestMapping
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassesRepository classesRepository;

    @RequestMapping
    public Page<Student> search(int page) {
        Pageable pageRequest = PageRequest.of(page, 5, Sort.by("id"));
        return studentRepository.findAll(pageRequest);
    }

    @RequestMapping(value = "getStudent")
    public Student getStudent(Long id) {

        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    @RequestMapping(value = "getClasses")
    public Optional<Classes> getClasses(Long id) {
        return classesRepository.findById(id);
    }
}
