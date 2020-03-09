package com.recomendation.controller.searchTweet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recomendation.entity.searchTweetEntity.TweetEntity;
import com.recomendation.service.searchTweet.ITweetSearchService;

@RestController
//@Secured({"ROLE_ADMIN"})
@RequestMapping("/dashboard")
@CrossOrigin(origins ="*")
public class TweetSearchController {

	@Autowired
	ITweetSearchService tweetService;


//	@Secured({"ROLE_ADMIN"})
	@PostMapping("/tweetStatsPost")	
	public List<TweetEntity> query(@RequestBody TweetEntity tweetEntity) {
		return tweetService.saveTweets(tweetEntity);
	}
	
//	@Secured({"ROLE_ADMIN"})
	@PostMapping("/tweetStatsPostProfile")	
	public List<TweetEntity> postProfile(@RequestBody TweetEntity tweetEntity) {
		return tweetService.saveTweetsProfile(tweetEntity);
	}
	
//	@Secured({"ROLE_ADMIN"})
	@GetMapping("/tweetStats")
	public List<TweetEntity> findAll() {
		return tweetService.findAll();
	}
	
//	@Secured({"ROLE_ADMIN"})
	@GetMapping("/tweetStatsCount")
	public Long tweetCount() {
		return tweetService.tweetCount();
	}
	
//	@Secured({"ROLE_ADMIN"})
	@GetMapping("/tweetStatsCountPositive")
	public Long tweetCountPositive() {
		return tweetService.tweetCountPositive();
	}
//	@Secured({"ROLE_ADMIN"})
	@GetMapping("/tweetStatsCountNegative")
	public Long tweetCountNegative() {
		return tweetService.tweetCountNegative();
	}

//	@Secured({"ROLE_ADMIN"})
	@GetMapping("/tweetStatsCountNeutral")
	public Long tweetCountNeutral() {
		return tweetService.tweetCountNeutral();
	}



}
