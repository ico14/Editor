//package org.fife.ui.rsyntaxtextarea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class MyTextArea extends RSyntaxTextArea{
    //JTextArea textArea;
    RSyntaxTextArea textArea;
    String text="";

    public MyTextArea() {
    }

    
    public MyTextArea(int rows,int cols) {
        
		super(rows, cols);
	
    }
    
    protected UndoManager undoManager = new UndoManager();
    public UndoManager getUndoManager()
    {
        return undoManager;
    }
    public void addMethods()
    {
        //RSyntaxTextArea ta=new RSyntaxTextArea();
        this.textArea = this;
         addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                if(SwingUtilities.isRightMouseButton(e))
                    new PopUpMenu(textArea,e);
             }
        });
        getDocument().addUndoableEditListener(new UndoableEditListener() {

            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            undoManager.addEdit(e.getEdit());
            }
        });
        /*addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
               
                text=getText();
            }
        });*/
    }
    public void addListener()
    {
        
    }
    String getString()
    {
        return text;
    }
}
