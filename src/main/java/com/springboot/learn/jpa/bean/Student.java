package com.springboot.learn.jpa.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author luoyuequan
 * @time 2019/11/28 10:16
 */
@Entity
public class Student implements Serializable {
    //    @ManyToOne
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JsonIgnore
//    @JoinColumn(name = "classes_id", referencedColumnName = "id")
//    private Classes classes;
    @Transient
    private static final long serialVersionUID = -3677722509454702826L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String sName;
    @Column
    private Byte sAge;
    @Column
    private Long classesId;

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Byte getsAge() {
        return sAge;
    }

    public void setsAge(Byte sAge) {
        this.sAge = sAge;
    }

    /**
     * 多对一关系
     * 级联操作
     * JoinColumn 指明该属性所关联的外键
     *
     * @return 班级
     */

//    public Classes getClasses() {
//        return classes;
//    }
//
//    public void setClasses(Classes classes) {
//        this.classes = classes;
//    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
