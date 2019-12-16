package com.springboot.learn.jpa.repository;

import com.springboot.learn.jpa.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019/11/28 10:25
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "update Student set sName = ?0,sAge=?1 where id=?2")
    int updateById(String name, Byte age, Long id);

    /**
     * 条件查询，指定年龄后
     *
     * @param age 年龄
     * @return student集合
     */
    List<Student> findBysAgeAfter(Byte age);

    /**
     * <p>
     * 条件查询
     * age <= ?1 and id >= ?2
     * </p>
     *
     * @param age 年龄
     * @param id  id
     * @return student集合
     */
    List<Student> findBysAgeLessThanEqualAndIdGreaterThanEqual(Byte age, Long id);
}
