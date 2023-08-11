package com.codingdojo.events.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "El nombre del evento es requerido.")
	@Size(max = 45, message = "El nombre debe ser menor a 45 caracteres.")
	@Column(nullable = false)
	private String name;

	@Future(message = "La fecha debe ser futura.")
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@NotEmpty(message = "La ubicacion es requerida.")
	@Size(max = 45, message = "La ubicacion debe ser menor a 45 caracteres.")
	@Column(nullable = false)
	private String location;
	
	@Column(nullable = false)
	private String state;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        	name = "rspvs",
        	joinColumns = @JoinColumn(name = "event_id", nullable = false),
        	inverseJoinColumns = @JoinColumn(name = "user_id")
        	)
        private List<User> users;
    
    @OneToMany(mappedBy="event", fetch = FetchType.LAZY)
    private List<Comment> comments;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id", nullable = false)
    private User user;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Event() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
    
	
}
