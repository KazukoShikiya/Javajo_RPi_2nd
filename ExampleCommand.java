import java.io.IOException;


public class ExampleCommand {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("fswebcam","--no-timestamp","--no-banner","/home/pi/test.jpg");
		Process p;
		try {
			p = pb.start();
			p.waitFor();

			System.out.println("finish!");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}

