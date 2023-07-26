package com.codingdojo.studentlist.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 private String firstName;
	    
	 private String lastName;

	 private Long age;
	 
	 @Column(updatable=false)
	   private Date createdAt;
	   private Date updatedAt;
	 
	 @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	    private Contact contact;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="dormitory_id")
	    private Dormitory dormitory;

	public Student() {
	}
	
	
	public Student(String firstName, String lastName, Long age, Contact contact) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contact = contact;
	}
	
	


	public Student(String firstName, String lastName, Long age, Contact contact, Dormitory dormitory) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contact = contact;
		this.dormitory = dormitory;
	}


	public Dormitory getDormitory() {
		return dormitory;
	}


	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
	}


	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	 
    
	 
}
