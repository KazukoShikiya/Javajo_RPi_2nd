import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Example{ 

    public static void main(String[] args) {

        Twitter twitter = new TwitterFactory().getInstance();

        while (true) {
            ProcessBuilder pb = new ProcessBuilder("fswebcam","--no-timestamp","--no-banner","/home/pi/photo/test.jpg"); // xxxx is OS Command
            try {
                Process p = pb.start();
                p.waitFor(10, TimeUnit.SECONDS); // Process finish wait 10sec

                // get file data
                FileSystem fs = FileSystems.getDefault();
                Path path = fs.getPath("/home/pi/photo/test.jpg");
                File file = path.toFile();
                // tweet
                twitter.updateStatus(new StatusUpdate("RPiテスト中").media(file));

                Thread.sleep(1_800_000); // wait 30min

            } catch (IOException | InterruptedException | TwitterException e) {
            }
        }
    }
}

