package com.recomendation.dao.searchTweet;


import org.springframework.data.repository.CrudRepository;

import com.recomendation.entity.searchTweetEntity.TweetEntity;

public interface ISearchTweetDao extends CrudRepository<TweetEntity, Long> {


}
