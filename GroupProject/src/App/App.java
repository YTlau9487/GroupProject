package App;
import java.awt.AWTException;

public class App {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.out.println("This is the java file that run the main game.");
		Thread.sleep(2000);
		KBEvent.clean_console();
	}

}