package com.recomendation.dao.sentiment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.recomendation.entity.sentiment.AzureSentimentEntity;

public interface IAzureSentimentDao extends JpaRepository<AzureSentimentEntity,Long>{





}
