/* Simple concept of cleaning console, however the mouse need to move to the console GUI so that it would do the action*/

package App;
import java.awt.*;
import java.awt.event.KeyEvent;

public class KBEvent {
	public static void clean_console() throws AWTException, InterruptedException {
		Robot robot = new Robot();
        //Clean the console
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_F10);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_F10);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
	}
}
