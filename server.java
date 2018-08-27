
import java.io.*;
import java.net.*;
class server {

    public static void main(String[] args) throws IOException
    {
        ServerSocket skt = new ServerSocket(6789);
 
        Socket socket = skt.accept();
 
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
 
        String s = dis.readUTF();
        System.out.println("Stuffed data from client: " + s);
        String temp = s.substring(8,s.length()-8);
        System.out.println("Decoding data..... ");
        decode(temp);
        
    }
    static void decode(String stri){
    
    	char[] data = stri.toCharArray();
    	char[]dedata = new char[200];
    	int i;
    	int count=0;
    	int iter=0;
    	for(i=0;i<data.length;i++)
    	{
    	
    		if(data[i]=='1'){
    			
    			count++;
    			if(count%5==0)
    			{
    				dedata[iter++] = data[i];
    				i++;    			
    			}
    			else
    			{
    				dedata[iter++] = data[i];
    			}
    		}
    		else
    		{	
    			count=0;
    			dedata[iter++] = data[i];
    		}
    		
    	
    	}
    	String ns = new String(dedata);
    	
    	System.out.print("Decoded Data: ");
    	System.out.print(ns);
    
    }
    
}
