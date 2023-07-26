package com.codingdojo.studentlist.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dormitories")
public class Dormitory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min = 2, max = 60)
    private String name;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="dormitory", fetch = FetchType.LAZY)
    private List<Student> students;

	public Dormitory() {

	}

	public Dormitory(String name, List<Student> students) {
		this.name = name;
		this.students = students;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void addStudent(Student student) {
        students.add(student);
        student.setDormitory(this); 
    }
	public void removeStudent(Student student) {
		student.setDormitory(null);
	}
    
	
	
    
    

}
