package com.myproject.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TaskNotes")
public class TaskNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seqNum;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Description")
	private String description;

	public TaskNote() {
		super();
	}

	public TaskNote(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Long getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Long seqNum) {
		this.seqNum = seqNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
