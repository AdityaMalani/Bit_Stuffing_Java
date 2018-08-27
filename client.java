import java.io.*;
import java.net.*;
import java.util.Scanner;
class client {


static char[] enc = new char[100];
    public static void main(String[] args) throws IOException
    {
        // Opens a socket for connection
        Socket socket = new Socket("localhost", 6789);
 
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        
 	func();
 	
 	String s = new String(enc);
 	String flagbit = "01111110";
 	String ns = flagbit+s+flagbit;
        dos.writeUTF(ns);
        
    }    
    
    public static void func(){
    
    	Scanner scn = new Scanner(System.in);
    	System.out.println("Enter data line: ");
    	String dataline = scn.next();
    	char[] data = dataline.toCharArray();
    	int i;
    	int count=0;
    	int iter=0;
    	for(i=0;i<data.length;i++){
    	
    		if(data[i]=='1'){
    		count++;
    			
    			if(count%5==0){
    				enc[iter++]=data[i];
    				enc[iter++]='0';
    				}
    			else
    				enc[iter++]=data[i];
    		
    		}
    		else{
    		
    		count=0;
    		enc[iter++] = data[i];
    		
    		}
    	
    	}
    
    }
}
