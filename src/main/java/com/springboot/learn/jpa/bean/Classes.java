package com.springboot.learn.jpa.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * classes
 *
 * @author luo
 */
@Entity
public class Classes implements Serializable {
    //    @OneToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinColumn(name = "classes_id", referencedColumnName = "id")
//    @JsonIgnore
//    private Collection<Student> students = new HashSet<>();
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * 班级id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 班级号
     */
    @Column
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 注解模式
     * 一对多关系
     * joinColumns 表示当前实体在多的一方中的外键
     * 启用二级缓存
     *
     * @return 学生集合
     */
//    public Collection<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Collection<Student> students) {
//        this.students = students;
//    }
    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}