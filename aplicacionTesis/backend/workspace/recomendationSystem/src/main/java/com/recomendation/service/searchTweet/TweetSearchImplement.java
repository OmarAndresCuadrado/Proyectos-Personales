package com.recomendation.service.searchTweet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.recomendation.dao.searchTweet.ISearchTweetDao;
import com.recomendation.dao.sentiment.IAzureSentimentDao;
import com.recomendation.entity.searchTweetEntity.TweetEntity;
import com.recomendation.entity.sentiment.AzureSentimentEntity;
import com.recomendation.service.sentiment.Documents;
import com.recomendation.service.sentiment.IAzureSentimentService;
import com.vdurmont.emoji.EmojiParser;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TweetSearchImplement implements ITweetSearchService {

	@Autowired
	ISearchTweetDao searchTweetDao;

	@Autowired
	IAzureSentimentService azureSentimentService;

	@Autowired
	ContadorTweetsAlgo contadorTweets;

	@Autowired
	IAzureSentimentDao azureSentimentDao;

	String hashtagRegex = "\\B(\\#[a-zA-Z]+\\b)(?!;)";
	List<TweetEntity> arrayEntity = new ArrayList<TweetEntity>();

	AzureSentimentEntity azureSentimentEntity = new AzureSentimentEntity();
	AzureSentimentEntity sentimiento = new AzureSentimentEntity();

	String ConsumerKey = "8jcsqfeCws1EpFms2zt2p2gdp";
	String ConsumerSecret = "GpDlvZvKVpf814eeRp4s82UC7GXYxo71rJqNcYk7ctYmh6Pfh2";
	String AccessToken = "1082632700245274624-nlkMHe9t1obJS87qtVaxYF4Ff76ifa";
	String TokenSecret = "OUEIxhZAXAhOAs4uc4j39pzwZsPOcaNvqXCf9FcyOElBs";
	
	//d10b101dd6ed414b80b4df4af24cdfc3

	@Override
	public List<TweetEntity> saveTweets(TweetEntity tweetEntity) {
		List<TweetEntity> arrayEntity = new ArrayList<TweetEntity>();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(ConsumerKey).setOAuthConsumerSecret(ConsumerSecret)
				.setOAuthAccessToken(AccessToken).setOAuthAccessTokenSecret(TokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		try {
			// TweetEntity tweetEntity = new TweetEntity(); // Objeto que se usa para
			// guardar un tue
			Query query = new Query(tweetEntity.getQuery());
			// Transformar el query a string
			String queryString = query.getQuery();
			QueryResult result;
			result = twitter.search(query);
			System.out.println(query);
			List<Status> tweets = result.getTweets();
			Long cantidadSentimientos = azureSentimentDao.count();
			System.out.println(cantidadSentimientos);
			Long contador = cantidadSentimientos;

			// List<Status> tweets = twitter.getUserTimeline("@WoWAura");
			for (Status tweet : tweets) {
				contador++;
				tweetEntity = new TweetEntity();

				if (tweet.getRetweetedStatus() != null) {

					// Quitar los emojis Contenido
					String tweetConEmojis = tweet.getRetweetedStatus().getText();
					String tweetSinEmojis = EmojiParser.removeAllEmojis(tweetConEmojis);
					tweetEntity.setTweetContect(tweetSinEmojis);

				} else {

					// Quitar los emojis Contenido
					String tweetConEmojis = tweet.getText();
					String tweetSinEmojis = EmojiParser.removeAllEmojis(tweetConEmojis);
					tweetEntity.setTweetContect(tweetSinEmojis);
				}

				tweetEntity.setQuery(queryString);
				
				tweetEntity.setLanguage(tweet.getLang());

				tweetEntity.setUrlProfileImage(tweet.getUser().getProfileImageURL());

				// Quitar los emojis Ubicacion
				String ubicacionConEmojis = tweet.getUser().getLocation();
				String ubicacionSinEmojis = EmojiParser.removeAllEmojis(ubicacionConEmojis);
				tweetEntity.setLocation(ubicacionSinEmojis);

				// Quitar los emojis Nombre
				String nombreConEmojis = tweet.getUser().getName();
				String nombreSinEmojis = EmojiParser.removeAllEmojis(nombreConEmojis);
				tweetEntity.setAccountName(nombreSinEmojis);

				// Quitar los emojis cuenta
				String cuentaConEmojis = tweet.getUser().getScreenName();
				String cuentaSinEmojis = EmojiParser.removeAllEmojis(cuentaConEmojis);
				tweetEntity.setUser(cuentaSinEmojis);

				System.out.println(tweetEntity.getTweetContect());

				// Anexar hasthag
				Pattern hashtagPattern = Pattern.compile(hashtagRegex);
				Matcher matcher = hashtagPattern.matcher(tweetEntity.getTweetContect());
				if (matcher.find()) {
					String hashtag = matcher.group();
					tweetEntity.setHashtag(hashtag);
				}

				List<Documents> response = azureSentimentService.GetSentiment(tweetEntity);
				Long id = (long) contador;

				try {

					sentimiento = azureSentimentService.findById(id);
				}

				catch (DataAccessException e) {
					System.out.println("error recolectando sentimientos" + e);
				}
				tweetEntity.setSentimentTweet(sentimiento.getSentiment());

				arrayEntity.add(tweetEntity);

			}

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
		}

		searchTweetDao.saveAll(arrayEntity);
		return arrayEntity;

	}

	@Override
	public List<TweetEntity> findAll() {

		return (List<TweetEntity>) searchTweetDao.findAll();
	}

	@Override
	public Long tweetCount() {
		return searchTweetDao.count();
	}

	@Override
	public Long tweetCountPositive() {
		return contadorTweets.contadorTweetsPositive();
	}

	@Override
	public Long tweetCountNegative() {
		return contadorTweets.contadorTweetsNegative();
	}

	@Override
	public Long tweetCountNeutral() {
		return contadorTweets.contadorTweetsNeutral();
	}

	@Override
	public List<TweetEntity> saveTweetsProfile(TweetEntity tweetEntity) {
		List<TweetEntity> arrayEntity = new ArrayList<TweetEntity>();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(ConsumerKey).setOAuthConsumerSecret(ConsumerSecret)
				.setOAuthAccessToken(AccessToken).setOAuthAccessTokenSecret(TokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		try {
			// TweetEntity tweetEntity = new TweetEntity(); // Objeto que se usa para
			// guardar un tue
			// Query query = new Query(tweetEntity.getQuery());
			// QueryResult result;
			// result = twitter.search(query.lang("es"));
			// System.out.println(query);
			// List<Status> tweets = result.getTweets();
			Long cantidadSentimientos = azureSentimentDao.count();
			System.out.println(cantidadSentimientos);
			Long contador = cantidadSentimientos;

			List<Status> tweets = twitter.getUserTimeline(tweetEntity.getQuery());
			for (Status tweet : tweets) {
				contador++;
				tweetEntity = new TweetEntity();

				if (tweet.getRetweetedStatus() != null) {

					// Quitar los emojis Contenido
					String tweetConEmojis = tweet.getRetweetedStatus().getText();
					String tweetSinEmojis = EmojiParser.removeAllEmojis(tweetConEmojis);
					tweetEntity.setTweetContect(tweetSinEmojis);

				} else {

					// Quitar los emojis Contenido
					String tweetConEmojis = tweet.getText();
					String tweetSinEmojis = EmojiParser.removeAllEmojis(tweetConEmojis);
					tweetEntity.setTweetContect(tweetSinEmojis);
				}

				tweetEntity.setLanguage(tweet.getLang());

				tweetEntity.setUrlProfileImage(tweet.getUser().getProfileImageURL());

				// Quitar los emojis Ubicacion
				String ubicacionConEmojis = tweet.getUser().getLocation();
				String ubicacionSinEmojis = EmojiParser.removeAllEmojis(ubicacionConEmojis);
				tweetEntity.setLocation(ubicacionSinEmojis);

				// Quitar los emojis Nombre
				String nombreConEmojis = tweet.getUser().getName();
				String nombreSinEmojis = EmojiParser.removeAllEmojis(nombreConEmojis);
				tweetEntity.setAccountName(nombreSinEmojis);

				// Quitar los emojis cuenta
				String cuentaConEmojis = tweet.getUser().getScreenName();
				String cuentaSinEmojis = EmojiParser.removeAllEmojis(cuentaConEmojis);
				tweetEntity.setUser(cuentaSinEmojis);

				System.out.println(tweetEntity.getTweetContect());

				// Anexar hasthag
				Pattern hashtagPattern = Pattern.compile(hashtagRegex);
				Matcher matcher = hashtagPattern.matcher(tweetEntity.getTweetContect());
				if (matcher.find()) {
					String hashtag = matcher.group();
					tweetEntity.setHashtag(hashtag);
				}

				List<Documents> response = azureSentimentService.GetSentiment(tweetEntity);
				Long id = (long) contador;

				try {

					sentimiento = azureSentimentService.findById(id);
				}

				catch (DataAccessException e) {
					System.out.println("error recolectando sentimientos" + e);
				}
				tweetEntity.setSentimentTweet(sentimiento.getSentiment());

				arrayEntity.add(tweetEntity);

			}

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
		}

		searchTweetDao.saveAll(arrayEntity);
		return arrayEntity;

	}

}
