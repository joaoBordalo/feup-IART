
package utilities;


import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.exception.FacebookException;
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
	    new FacebookPublisher("CAACEdEose0cBAD7uuON4YGC2npM2IwZBwdhWfdVgwBvUZCnAzTsbG3ZCZBRXUFJbetDd5VkgCvPPXRwQLR1AvGsocb5I3hNh4ELmH9xIHasJQeYtahGDuKbTCF9HYX5vW8UgwIKPrFMfarNcMeEX1l0HLyXGhhs5blCG6ZB4ISmIX6DVeMjSiNeHahZChZC5pWLkwPBZCEEUzdJYlVa07G3VsrbthmZBaeAgZD",
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
