
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class TextAreaInputStream extends InputStream{
    private JTextArea textControl;
    //ArrayBlockingQueue<Integer> queue;
    public TextAreaInputStream( JTextArea control ) {
        textControl = control;
       // queue=new ArrayBlockingQueue<Integer>(1024);
    }
    
    @Override
    public int read() throws IOException {
       /*Integer i=null;
            try {
                i = queue.take();
            } catch (InterruptedException ex) {
                Logger.getLogger(Console.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            if(i!=null)
                return i;*/
            return 0;
      
    }
}
