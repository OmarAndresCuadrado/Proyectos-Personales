package testing;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Hasthag {


	public static void main(String[] args) {
		
		String ConsumerKey = "8jcsqfeCws1EpFms2zt2p2gdp";
		String ConsumerSecret = "GpDlvZvKVpf814eeRp4s82UC7GXYxo71rJqNcYk7ctYmh6Pfh2";
		String AccessToken = "1082632700245274624-nlkMHe9t1obJS87qtVaxYF4Ff76ifa";
		String TokenSecret = "OUEIxhZAXAhOAs4uc4j39pzwZsPOcaNvqXCf9FcyOElBs";
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(ConsumerKey).setOAuthConsumerSecret(ConsumerSecret)
				.setOAuthAccessToken(AccessToken).setOAuthAccessTokenSecret(TokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		try {
//			Query query = new Query("Cocaine");
//			QueryResult result;
//			result = twitter.search(query);
//			List<Status> tweets = result.getTweets();
			List<Status> statuses = twitter.getMentionsTimeline();
			for (Status status : statuses) {
				System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
			}

			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}
	}
}

// The factory instance is re-useable and thread safe.
// Twitter twitter = TwitterFactory.getSingleton();
// Query query = new Query("source:twitter4j yusukey");
// QueryResult result = twitter.search(query);
// for (Status status : result.getTweets()) {
// System.out.println("@" + status.getUser().getScreenName() + ":" +
// status.getText());
// }
