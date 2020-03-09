package com.recomendation.service.searchTweet;

import java.util.List;

import com.recomendation.entity.searchTweetEntity.TweetEntity;

import twitter4j.Status;

public interface ITweetSearchService {

	public List<TweetEntity> findAll();

	public List<TweetEntity> saveTweets(TweetEntity tweetEntity);

	public Long tweetCount();
	
	public Long tweetCountPositive();
	
	public Long tweetCountNegative();
	
	public Long tweetCountNeutral();
	
	public List<TweetEntity> saveTweetsProfile(TweetEntity tweetEntity);
	
	

	

}
