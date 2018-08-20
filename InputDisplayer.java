
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class InputDisplayer implements Runnable{
    OutputStream out;
    //OutputStreamWriter writer;
    //BufferedWriter bufferedWriter;
     PrintWriter writer;
   String input;
    //OutputStreamReader reader;
    public InputDisplayer(Process proc,String input) {
         out = proc.getOutputStream();
         writer = new PrintWriter(out,true);
         //bufferedWriter = new BufferedWriter(writer);
         Thread thread = new Thread(this);
         thread.start();
    }

    @Override
    public void run() {
       //String str = 
        try
    {
        writer.println(input);
    }
    catch(Exception e)
    {
        System.out.println("exc in input");
    }
       
    }
         
}
