
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;



public class OutputDisplayer implements Runnable {
    
   InputStream inn,err;
   OutputStream out;
   
   InputStreamReader reader,readerr;
  // OutputStreamWriter writer;
   
   BufferedReader bufferedReader,bufferedReaderr;
   BufferedWriter bufferedWriter;
   
   PrintWriter writer;
   String input;
   public OutputDisplayer(Process proc) {
     inn = proc.getInputStream();
     err = proc.getErrorStream();
     out = proc.getOutputStream();
     
    //to give output
    reader = new InputStreamReader(inn);
    bufferedReader = new BufferedReader(reader);
    
    //to give error
    readerr = new InputStreamReader(err);
    bufferedReaderr = new BufferedReader(readerr);
    
    //to take input
    writer = new PrintWriter(out,true);
    //bufferedWriter = new BufferedWriter(writer);
    
    Thread thread = new Thread(this);
    
    thread.start();
    //thread1.start();
  }

   public OutputDisplayer(Process proc,String input) {
       this.input = input;
     inn = proc.getInputStream();
     err = proc.getErrorStream();
     out = (BufferedOutputStream) proc.getOutputStream();
     
    //to give output
    reader = new InputStreamReader(inn);
    bufferedReader = new BufferedReader(reader);
    
    //to give error
    readerr = new InputStreamReader(err);
    bufferedReaderr = new BufferedReader(readerr);
    
    //to take input
    writer = new PrintWriter(out,true);
    //bufferedWriter = new BufferedWriter(writer);
    try
    {
        writer.println(input);
    }
    catch(Exception e)
    {
        System.out.println("exc in input");
    }
       
     Thread thread = new Thread(this);
    
    thread.start();
    //thread1.start();
  }

 
   public void run() {
       String line ="";
    //StringBuilder buf = new StringBuilder();
    try {
        
         while( (line = bufferedReader.readLine()) != null ) {
           System.out.println( line );
           //writer.print(System.in.toString());
        }
           while( (line = bufferedReaderr.readLine()) != null ) {
           System.out.println( line );
           }
       /* while( (line = System.in.toString()) != null)
        {
             bufferedWriter.write(line);
        }*/
       
               
    } catch ( IOException ioe ) {
        line = "ERROR: "+ioe.toString();
        System.out.println( line );
    } finally {
        try {
            
            reader.close();
            readerr.close();
            writer.close();
        } catch ( IOException ioe ) {
            ioe.printStackTrace();
        }
    }
  }
}

