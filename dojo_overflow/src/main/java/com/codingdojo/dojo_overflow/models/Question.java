package com.codingdojo.dojo_overflow.models;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "La Pregunta no puede estar vacía.")
	@Size(min = 1, max = 500)
	@Column(columnDefinition = "text")
	private String question;
	
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @Column(updatable=false)
	    private Date createdAt;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date updatedAt;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "tags_questions", 
	        joinColumns = @JoinColumn(name = "question_id"), 
	        inverseJoinColumns = @JoinColumn(name = "tag_id")
	    )     
	    private List<Tag> tag;
	    
	    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	    private List<Answer> answer;

		public Question() {
		}

		public Question(
				@NotBlank(message = "La Pregunta no puede estar vacía.") @Size(min = 1, max = 500) String question,
				List<Tag> tag, List<Answer> answer) {
			super();
			this.question = question;
			this.tag = tag;
			this.answer = answer;
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

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
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

		public List<Tag> getTag() {
			return tag;
		}

		public void setTag(List<Tag> tag) {
			this.tag = tag;
		}

		public List<Answer> getAnswer() {
			return answer;
		}

		public void setAnswer(List<Answer> answer) {
			this.answer = answer;
		}
	    
	    
}
