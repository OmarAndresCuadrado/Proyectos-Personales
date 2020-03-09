package com.recomendation.service.sentiment;

import java.util.List;
import java.util.Optional;

import com.recomendation.entity.searchTweetEntity.TweetEntity;
import com.recomendation.entity.sentiment.AzureSentimentEntity;

public interface IAzureSentimentService {

	public List<AzureSentimentEntity> findAll();
	
	public AzureSentimentEntity findById(Long id);
	
	public List<Documents> GetSentiment(TweetEntity tw);

	public List<AzureSentimentEntity> saveSentiment(AzureSentimentEntity azureSentimentEntity);
}
