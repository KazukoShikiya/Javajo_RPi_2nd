import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import java.time.LocalDateTime;

public class TimeTweetSample{

	public static void main(String[] args){

		try{
			Twitter twitter = TwitterFactory.getSingleton();
			Status status = twitter.updateStatus(LocalDateTime.now().toString());
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
