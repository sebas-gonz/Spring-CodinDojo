package com.codingdojo.events.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "El nombre es requerido.")
	@Column(nullable = false)
	private String first_name;

	@NotEmpty(message = "El apellido es requerido.")
	@Column(nullable = false)
	private String last_name;

	@Email(message = "Debe ser un correo valido.")
	@Column(nullable = false)
	private String email;

	@NotEmpty(message = "La ubicacion es Requerida.")
	@Column(nullable = false)
	private String location;

	@Column(nullable = false)
	private String state;

	@Size(min = 5, message = "Contraseña debe ser más grande que 5 caracteres.")
	@Column(nullable = false)
	private String password;

	@Transient
	@Column(nullable = false)
	private String passwordConfirmation;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "rspvs",
    	joinColumns = @JoinColumn(name = "user_id",nullable = false),
    	inverseJoinColumns = @JoinColumn(name = "event_id")
    	)
    private List<Event> events;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Comment> comments;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Event> eventsUser;
    
	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Event> getEventsUser() {
		return eventsUser;
	}

	public void setEventsUser(List<Event> eventsUser) {
		this.eventsUser = eventsUser;
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
	
    
    
}
