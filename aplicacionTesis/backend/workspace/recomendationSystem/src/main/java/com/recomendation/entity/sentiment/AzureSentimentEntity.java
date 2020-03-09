package com.recomendation.entity.sentiment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sentiment")
public class AzureSentimentEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	@Column
	private String sentiment;
	
	
	
	public AzureSentimentEntity() {

	}
	

	public AzureSentimentEntity(long id, String sentiment) {
		this.id = id;
		this.sentiment = sentiment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}


	

}
