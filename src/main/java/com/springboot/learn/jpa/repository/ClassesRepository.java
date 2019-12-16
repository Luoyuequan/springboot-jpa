package com.springboot.learn.jpa.repository;

import com.springboot.learn.jpa.bean.Classes;
import com.springboot.learn.jpa.bean.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author luoyuequan
 * @time 2019/11/28 17:25
 */
public interface ClassesRepository extends JpaRepository<Classes, Long> {
    @Query(value = "select c.number,s.sName,s.sAge from Classes c left join Student s on c.id = s.classesId")
    StudentInfo getStudentInfoByClasses(Long id);
}
