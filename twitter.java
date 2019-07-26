import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class twitter {
    private final static String CONSUMER_KEY = "dC95NpnwdUuKK6a7xenXxhpmY";
    private final static String CONSUMER_KEY_SECRET = "wj4Cs2ECPBwhwfO8ujgjfseCyOXbrwvq7icEqb3AFJABBUHj3v";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("saya lelah pak dosen");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "hxqVZI8gRMc9q6HJ7gV9z0uC5dZ2W6UCkwjRVG1i5anoy";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1139545610200084480-hFV2AlDckrt0m4s9SLKeK6IctdAIV7";
    }

    public static void main(String[] args) throws Exception {
	new twitter().start();
    }
}