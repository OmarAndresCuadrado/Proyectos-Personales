package com.recomendation.entity.searchTweetEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.recomendation.entity.sentiment.AzureSentimentEntity;

@Entity
@Table(name = "Tweets")
public class TweetEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String user;

	@Column
	private String query;

	@Column
	private String accountName;

	@Column
	private String location;

	@Column
	private String tweetContect;

	@Column
	private String urlProfileImage;

	@Column
	private String language;

	@Column
	private String hashtag;

	@Column
	private String sentimentTweet;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSentimentTweet() {
		return sentimentTweet;
	}

	public void setSentimentTweet(String sentimentTweet) {
		this.sentimentTweet = sentimentTweet;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTweetContect() {
		return tweetContect;
	}

	public void setTweetContect(String tweetContect) {
		this.tweetContect = tweetContect;
	}

	public String getUrlProfileImage() {
		return urlProfileImage;
	}

	public void setUrlProfileImage(String urlProfileImage) {
		this.urlProfileImage = urlProfileImage;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// public String getHashtag() {
	// return hashtag;
	// }
	//
	// public void setHashtag(String hashtag) {
	// this.hashtag = hashtag;
	// }
	//

}
