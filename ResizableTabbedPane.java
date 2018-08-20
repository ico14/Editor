
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.*;
import javax.swing.border.BevelBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class ResizableTabbedPane extends JComponent{
     private JScrollPane jscrollPane;  
     private JTabbedPane jtabbedPane;
     //JTextArea ta;
     private volatile int screenX = 0;
  private volatile int screenY = 0;
  private volatile int myX = 0;
  private volatile int myY = 0;

     private boolean drag = false;
     private Point dragLoaction = new Point();
     public ResizableTabbedPane(JScrollPane jscrollPane,JTabbedPane jtabbedPane){
         this.jtabbedPane = jtabbedPane;
         this.jscrollPane = jscrollPane;
         //jscrollPane.setBorder(new LineBorder(Color.GRAY,2));
           /*jscrollPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
           jscrollPane.setPreferredSize(new Dimension(500, 500));*/
           jtabbedPane.addMouseListener(new MouseAdapter() {
               public void mousePressed(MouseEvent evt)
               {
                   drag = true;
                   dragLoaction = evt.getPoint();
                   screenX = evt.getXOnScreen();
                   screenY = evt.getYOnScreen();
                  myX = jscrollPane.getWidth();
                 myY = jscrollPane.getHeight();
               }
           public void mouseReleased(MouseEvent evt)
           {
               drag = false;
           }
});
        jtabbedPane.addMouseMotionListener(new MouseMotionAdapter() {
               
           public void mouseDragged(MouseEvent evt)
           {
               //if(drag)
               //{
                   /*if(dragLoaction.getX()>getWidth()-10 && dragLoaction.getY()>getHeight()-10)
                   {
                       System.err.println("in");
                       jscrollPane.setSize((int)(getWidth() + evt.getPoint().getX() - dragLoaction.getX()),(int)(getHeight() + evt.getPoint().getY() - dragLoaction.getY()));
                        dragLoaction = evt.getPoint();
                   }*/
                   int deltaX = evt.getXOnScreen() - screenX;
                   int deltaY = evt.getYOnScreen() - screenY;
                   jtabbedPane.setSize(myX + deltaX, myY + deltaY);
                   jscrollPane.setSize(myX + deltaX, myY + deltaY);
                   
              // }
           }
        });
     // this.setLayout(new BorderLayout());
       
     }
}