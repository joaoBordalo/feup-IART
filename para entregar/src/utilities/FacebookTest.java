package utilities;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;



public class FacebookTest {
	
	
	public static void main(String[] args)
	{
		
		//access token
		FacebookClient fbClient= new DefaultFacebookClient("CAACEdEose0cBAHoQBqtxcKVZCVnE8T5JpgXqJy5OoulUcGUdPCZCJzQggCF0buvk7vDYoznFUSWr28aiYeH3MyQlSzwbhHnffU2M5rWen9ZA8fKDtMKxZBftJfZCHT06x4MD5odkcxqGnZCM1dASNEUFEGa4p5R4F5PAT0ip7CpK3Uz8xEMDCEGqL2ypAfY7w4gxkqEPVAD6VaxATGHqKmZCHCmL2PrOZAsZD");
		
		//objectid, neste caso, user
		User me = fbClient.fetchObject("10204496452515179", com.restfb.types.User.class);
		
		if(me==null)
		{
			System.out.println("erro! nao apanhei o user");
		}
		else{
			System.out.println(me.getFirstName());
			
		}
	}

}
