package sjsu.cmpe172.karaf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import sjsu.cmpe172.karaf.JavaServlet;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.User;
import twitter4j.api.TimelinesResources;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class JavaTest {

	static String consumerKeyStr = "SzZycoyCzjQv6MsS7cJ2L4rHe";
	static String consumerSecretStr = "lIhrJ11TYGMF6ODQEwG5L0jwJ7cc9k1hMKURG8d649D34Gbl7D";
	static String accessTokenStr = "1040353464868454402-0wCNY4usPRvsCYzx0EFvwikXzikPQM";
	static String accessTokenSecretStr = "OIosmBKuXAOsn35ojlrZAydLLzAr9fgZ93WjrwkK6WdPL";
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Starting the test Twitter Rest API v1.1...");
		Twitter twitter = new TwitterFactory().getInstance();
	}
	
	@Test
	public void testTimeline() {
		Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);
		twitter.setOAuthAccessToken(accessToken);

		TimelinesResources response = twitter.timelines();
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testPost() throws Exception {
		Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);
		twitter.setOAuthAccessToken(accessToken);
		

		String statusActual = twitter.getScreenName() + " Test Update Status";
		Status status = twitter.updateStatus(statusActual);
		assertEquals(statusActual, status.getText());
	}
	
	@Test
	public void testshowUser() throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);
		twitter.setOAuthAccessToken(accessToken);

		User response = twitter.showUser("ziyun88595080");
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testcreateFriendship() throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);
		twitter.setOAuthAccessToken(accessToken);

		User response = twitter.createFriendship("johnhall");
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testcreateMute() throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);
		twitter.setOAuthAccessToken(accessToken);

		User response = twitter.createMute("johnhall");
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testcreateBlock() throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);
		twitter.setOAuthAccessToken(accessToken);

		User response = twitter.createBlock("johnhall");
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testgetUserID() throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);
		twitter.setOAuthAccessToken(accessToken);

		long response = twitter.getId();
		Assert.assertNotNull(response);
	}
	
	@Test
	public void testdestroyBlock() throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
    	twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
		AccessToken accessToken = new AccessToken(accessTokenStr,
				accessTokenSecretStr);
		twitter.setOAuthAccessToken(accessToken);

		User response = twitter.destroyBlock("johnhall");
		Assert.assertNotNull(response);
	}
	
}