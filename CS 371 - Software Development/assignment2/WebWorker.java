/**
* Web worker: an object of this class executes in its own new thread
* to receive and respond to a single HTTP request. After the constructor
* the object executes on its "run" method, and leaves when it is done.
*
* One WebWorker object is only responsible for one client connection. 
* This code uses Java threads to parallelize the handling of clients:
* each WebWorker runs in its own thread. This means that you can essentially
* just think about what is happening on one client at a time, ignoring 
* the fact that the entirety of the webserver execution might be handling
* other clients, too. 
*
* This WebWorker class (i.e., an object of this class) is where all the
* client interaction is done. The "run()" method is the beginning -- think
* of it as the "main()" for a client interaction. It does three things in
* a row, invoking three methods in this class: it reads the incoming HTTP
* request; it writes out an HTTP header to begin its response, and then it
* writes out some HTML content for the response content. HTTP requests and
* responses are just lines of text (in a very particular format). 
*
**/

import java.net.Socket;
import java.lang.Runnable;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.TimeZone;
import java.util.*;

public class WebWorker implements Runnable
{

int fileFound = 0;
String file = "";
String fileType = "html";
private Socket socket;

/**
* Constructor: must have a valid open socket
**/
public WebWorker(Socket s)
{
   socket = s;
}

/**
* Worker thread starting point. Each worker handles just one HTTP 
* request and then returns, which destroys the thread. This method
* assumes that whoever created the worker created it with a valid
* open socket object.
**/
public void run()
{
   System.err.println("Handling connection...");
   try {
      InputStream  is = socket.getInputStream();
      OutputStream os = socket.getOutputStream();
      readHTTPRequest(is);
      writeHTTPHeader(os,"text/html");
      writeContent(os);
      os.flush();
      socket.close();
   } catch (Exception e) {
      System.err.println("Output error: "+e);
   }
   System.err.println("Done handling connection.");
   return;
}

/**
* Read the HTTP request header.
**/
private void readHTTPRequest(InputStream is)
{
   String line;
   BufferedReader r = new BufferedReader(new InputStreamReader(is));
   while (true) {
      try {
         while (!r.ready()) Thread.sleep(1);
         line = r.readLine();
         System.err.println("Request line: ("+line+")");
         
         StringTokenizer stringToken = new StringTokenizer(line);
         
         if((stringToken.nextToken()).equalsIgnoreCase("get")){
            if((file = "." + stringToken.nextToken()).equals("./")){
                fileFound = 2;
                break;
            }

         }
         
         try {
            FileInputStream fileStream = new FileInputStream(file);
            fileFound = 1;
            if (file.endsWith(".html")){
                fileType = "html";
            }
            if (file.endsWith(".gif")){
                fileType = "gif";
            }
            if (file.endsWith(".jpeg") || file.endsWith(".jpg")){
                fileType = "jpeg";
            }
            if (file.endsWith(".png")){
                fileType = "png";
            }


         }  
         catch (FileNotFoundException e) {
         fileFound = 0;
         }

         if (line.length()==0) break;
      } catch (Exception e) {
         System.err.println("Request error: "+e);
         break;
      }
   }
   return;
}

/**
* Write the HTTP header lines to the client network connection.
* @param os is the OutputStream object to write to
* @param contentType is the string MIME content type (e.g. "text/html")
**/
private void writeHTTPHeader(OutputStream os, String contentType) throws Exception
{

    if( fileFound > 0){
    Date d = new Date();
    DateFormat df = DateFormat.getDateTimeInstance();
    df.setTimeZone(TimeZone.getTimeZone("GMT"));
    os.write("HTTP/1.1 200 OK\n".getBytes());
    os.write("Date: ".getBytes());
    os.write((df.format(d)).getBytes());
    os.write("\n".getBytes());
    os.write("Server: Jon's very own server\n".getBytes());
    //os.write("Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT\n".getBytes());
    //os.write("Content-Length: 438\n".getBytes()); 
    os.write("Connection: close\n".getBytes());
    os.write("Content-Type: ".getBytes());
    if(fileType.equals("html")){
        os.write(contentType.getBytes());
    }
    if(fileType.equals("gif")){
        os.write("image/gif".getBytes());
    }
    if(fileType.equals("png")){
        os.write("image/png".getBytes());
    }
    if(fileType.equals("jpeg")){
        os.write("image/jpeg".getBytes());
    }
    os.write("\n\n".getBytes()); // HTTP header ends with 2 newlines
    return;
    }
    else{
    Date d = new Date();
    DateFormat df = DateFormat.getDateTimeInstance();
    df.setTimeZone(TimeZone.getTimeZone("GMT"));
    os.write("HTTP/1.0 404 Not Found\n".getBytes());
    os.write("Date: ".getBytes());
    os.write((df.format(d)).getBytes());
    os.write("\n".getBytes());
    os.write("Server: Jon's very own server\n".getBytes());
    //os.write("Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT\n".getBytes());
    //os.write("Content-Length: 438\n".getBytes()); 
    os.write("Connection: close\n".getBytes());
    os.write("Content-Type: ".getBytes());
    os.write(contentType.getBytes());
    os.write("\n\n".getBytes()); // HTTP header ends with 2 newlines
    return;
    }
}

/**
* Write the data content to the client network connection. This MUST
* be done after the HTTP header has been written out.
* @param os is the OutputStream object to write to
**/
private void writeContent(OutputStream os) throws Exception
{

    // If file is found
    if(fileFound == 1){
    
	// Handles html files
        if(fileType.equals("html")){
            Date date = new Date();
        
            BufferedReader br = new BufferedReader(new FileReader(file)); 
  
            String currentLine; 
            while ((currentLine = br.readLine()) != null){
        
                currentLine = currentLine.replace("{{cs371date}}", date.toString());
                currentLine = currentLine.replace("{{cs371server}}", 
                "Michael's Server");
                os.write((currentLine + "\n").getBytes()); 
            }
        }
	// Handles all image types
        else{
        
            InputStream input = new FileInputStream(file);
            byte[] data = new byte[4096];
            int x;
            while ((x = input.read(data))>0){
                os.write(data, 0, x);
            }
        }
    } 
        
    // if file is not found
    if(fileFound == 0){
    
        os.write("<html><head></head><body>".getBytes());
        os.write("<h3>404 not found\n</h3>".getBytes());
        //os.write("<h3>My web server works!</h3>\n".getBytes());
        os.write("</body></html>\n".getBytes());
    }
    // if no file is given
    if(fileFound == 2){
        os.write("<html><head></head><body>".getBytes());
        os.write("<h3>My web server works!</h3>\n".getBytes());
        os.write("</body></html>\n".getBytes());
    }
}

} // end class
