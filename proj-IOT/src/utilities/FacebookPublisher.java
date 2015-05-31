
package utilities;

import java.util.Arrays;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.exception.FacebookException;
import com.restfb.types.FacebookType;
import com.restfb.types.FriendList;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;



public class FacebookPublisher {
	
	
	 private final FacebookClient facebookClient;
	 public AccessToken appToken;

	  /**
	   * Entry point. You must provide a single argument on the command line: a
	   * valid Graph API access token.
	   * 
	   * @param args
	   *          Command-line arguments.
	   * @throws FacebookException
	   *           If an error occurs while talking to the Facebook Graph API.
	   */
	  public static void main(String[] args) throws FacebookException {
	    new FacebookPublisher("CAACEdEose0cBAC8RMZBZCVBHqVvkQ8ldz3Es3sl9WTvjZAZBLgTVDZBria0XwUuyQJ6Ah1sjwvoY9WuVPxPENq9SfQZAq2BRpyxsYqZC5398NWpBUOP3ifqEQJrVAB7bZAXZBUi0t0ZBIDFwpPkg26PCUZAj1Y7CvowrHZB9xCRXQ76PZAWgp1PLix3nw6ENFZBoJz8jd0yxH3bJ8BZCwOGaHg8yibAJAkku4GrOmkZD",
	    		 "IOT NOTIFICATION");
	  }

	  public FacebookPublisher(String accessToken, String message) {
	    facebookClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_3);
	   // appToken = facebookClient.obtainAppAccessToken("581857885287963", "6ef4f1f0a9c32b43283dc08f06fcbe0a");
	   // facebookClient.obtainExtendedAccessToken("581857885287963", "6ef4f1f0a9c32b43283dc08f06fcbe0a", appToken.getAccessToken());
	    sendWallNotification(message);
	    System.out.println("Facebook notification sent!");
	    
	  }

	  void sendWallNotification(String message) throws FacebookException {
		  facebookClient.publish("me/feed", User.class, Parameter.with("message", message));
	  }

	 

}
