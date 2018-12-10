package sjsu.cmpe172.karaf;

//Import required java libraries
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import twitter4j.IDs;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

import javax.servlet.*;
import javax.servlet.http.*;

//Extend HttpServlet class
public class JavaServlet extends HttpServlet {

	private static final long serialVersionUID = 2679773610486570838L;
	
	/**
	 * connect to twitter
	 * @return Twitter instance
	 */
	public Twitter createTwitter() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("SzZycoyCzjQv6MsS7cJ2L4rHe");
		cb.setOAuthConsumerSecret("lIhrJ11TYGMF6ODQEwG5L0jwJ7cc9k1hMKURG8d649D34Gbl7D");
		cb.setOAuthAccessToken("1040353464868454402-0wCNY4usPRvsCYzx0EFvwikXzikPQM");
		cb.setOAuthAccessTokenSecret("OIosmBKuXAOsn35ojlrZAydLLzAr9fgZ93WjrwkK6WdPL");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		return twitter;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("selectActions");
		
		if(action.equals("timeline")) {
			try {
				twtTimeline(request, response);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		} else if(action.equals("post")) {
			try {
				postTweet(request, response);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		} else if(action.equals("showUser")) {
			try {
				showUser(request, response);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		} else if(action.equals("createFriendship")) {
			try {
				createFriendship(request, response);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		} else if(action.equals("createMute")) {
			try {
				createMute(request, response);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		} else if(action.equals("createBlock")) {
			try {
				createBlock(request, response);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		} else if(action.equals("getUserID")) {
			try {
				getUserID(request, response);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		} else if(action.equals("destroyBlock")) {
			try {
				destroyBlock(request, response);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void twtTimeline(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TwitterException {
		
		Twitter twitter = createTwitter();
		
	    List<Status> statuses;
	    
		statuses = twitter.getHomeTimeline();
		ArrayList<String> array = new ArrayList<String>();
		
	    for (Status status : statuses) {
	        array.add(status.getUser().getName() + " : " +
                    status.getText());
	    }
	    
		request.setAttribute("array", array);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	public void postTweet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TwitterException {
		Twitter twitter = createTwitter();
		String text = request.getParameter("inputBox");
		
		Status status = twitter.updateStatus(text);
		
		request.setAttribute("message", status.getText());
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}
	
	private void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TwitterException {
		Twitter twitter = createTwitter();
		String text = request.getParameter("inputBox");
		User user = twitter.showUser(text);
		request.setAttribute("message", user.toString());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void createFriendship(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TwitterException {
		Twitter twitter = createTwitter();
		String text = request.getParameter("inputBox");
	    twitter.createFriendship(text);
	    request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void createMute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TwitterException {
        Twitter twitter = createTwitter();
        String text = request.getParameter("inputBox");
        twitter.createMute(text);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
	
    private void createBlock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TwitterException {
        Twitter twitter = createTwitter();
        String text = request.getParameter("inputBox");
        twitter.createBlock(text);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
	
    private void getUserID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TwitterException {
		Twitter twitter = createTwitter();
		request.setAttribute("message", twitter.getId());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
   
    private void destroyBlock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TwitterException {
		Twitter twitter = createTwitter();
		String text = request.getParameter("inputBox");
		twitter.destroyBlock(text);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}