package utilities.classes;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


/**
 * Created by Todd on 11/9/2016.
 */
public class KeyStrokes {
    static Robot keystroke;

    public static void windowsCopy(){
        keystroke.keyPress(KeyEvent.VK_CONTROL);
        keystroke.keyPress(KeyEvent.VK_COPY);
        keystroke.keyRelease(KeyEvent.VK_COPY);
        keystroke.keyRelease(KeyEvent.VK_CONTROL);

    }

    public static void windowsPaste(){
        keystroke.keyPress(KeyEvent.VK_CONTROL);
        keystroke.keyPress(KeyEvent.VK_V);
        keystroke.keyRelease(KeyEvent.VK_V);
        keystroke.keyRelease(KeyEvent.VK_CONTROL);

    }

    public static void windowsCopyPaste(){
        keystroke.keyPress(KeyEvent.VK_CONTROL);
        keystroke.keyPress(KeyEvent.VK_COPY);
        keystroke.keyRelease(KeyEvent.VK_COPY);
        keystroke.keyRelease(KeyEvent.VK_CONTROL);

        keystroke.keyPress(KeyEvent.VK_CONTROL);
        keystroke.keyPress(KeyEvent.VK_V);
        keystroke.keyRelease(KeyEvent.VK_V);
        keystroke.keyRelease(KeyEvent.VK_CONTROL);
    }


}
