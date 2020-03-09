package com.recomendation.service.searchTweet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.recomendation.dao.searchTweet.ISearchTweetDao;
import com.recomendation.entity.searchTweetEntity.TweetEntity;

@Service
public class ContadorTweetsAlgo {
	
	@Autowired
	ISearchTweetDao searchTweetDao;
	
	@Bean
//	@Qualifier("contadorTweetsPositivee")
	public Long contadorTweetsPositive () {
		
		Long cantidadPositivo = (long) 0;
		String positivo = "positivo";
		List<TweetEntity> arrayEntity = (List<TweetEntity>) searchTweetDao.findAll();
		
		for (int i = 0; i < arrayEntity.size(); i++) {
			TweetEntity tweetEntity = arrayEntity.get(i);
			String sentimiento = tweetEntity.getSentimentTweet();

			if (sentimiento.equals(positivo)) {
				cantidadPositivo++;
			} 
			
		}
		return cantidadPositivo;
	}
	
	
	@Bean
//	@Qualifier("contadorTweetsNegative")
	public Long contadorTweetsNegative () {
		
		Long cantidadNegativo = (long) 0;
		String negativo = "negativo";
		List<TweetEntity> arrayEntity = (List<TweetEntity>) searchTweetDao.findAll();
		
	
		for (int i = 0; i < arrayEntity.size(); i++) {
			TweetEntity tweetEntity = arrayEntity.get(i);
			String sentimiento = tweetEntity.getSentimentTweet();

			if (sentimiento.equals(negativo)) {
				cantidadNegativo++;} 
		}
		return cantidadNegativo;
	}
	
	
	@Bean
//	@Qualifier("contadorTweetsNeutral")
	public Long contadorTweetsNeutral () {

		Long cantidadNuetro = (long) 0;
		String neutro = "neutro";
		List<TweetEntity> arrayEntity = (List<TweetEntity>) searchTweetDao.findAll();

		for (int i = 0; i < arrayEntity.size(); i++) {
			TweetEntity tweetEntity = arrayEntity.get(i);
			String sentimiento = tweetEntity.getSentimentTweet();

			if (sentimiento.equals(neutro)) {
				cantidadNuetro++;}		
		}
		return cantidadNuetro;
	}
	
	
//	@Bean
//	public Long contadorTweets () {
//		
//		Long cantidadPositivo = (long) 0;
//		Long cantidadNegativo = (long) 0;
//		Long cantidadNuetro = (long) 0;
//		String positivo = "positivo";
//		String negativo = "negativo";
//		String neutro = "neutro";
//		List<TweetEntity> arrayEntity = (List<TweetEntity>) searchTweetDao.findAll();
//		
//	
//		for (int i = 0; i < arrayEntity.size(); i++) {
//			TweetEntity tweetEntity = arrayEntity.get(i);
//			String sentimiento = tweetEntity.getSentimentTweet();
//
//			if (sentimiento.equals(positivo)) {
//				cantidadPositivo++;
//			} else if (sentimiento.equals(negativo)) {
//				cantidadNegativo++;
//			} else {
//				cantidadNuetro++;
//			}
//			
//		}
//		return cantidadPositivo;
//	}
	
	

}
