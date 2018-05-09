import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.border.*;
import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class sam 
{  
    public static void main(String[] args) throws Exception 
	{  
        try { 
			String input=null;
            // Process p = Runtime.getRuntime().exec("javac tt.java");
             Process p2 = Runtime.getRuntime().exec("java c8");
             BufferedReader in = new BufferedReader(  
             new InputStreamReader(p2.getInputStream()));

            // OutputStream out = p.getOutputStream();
             String line = null; 
             line = in.readLine();
             System.out.println(line);
             input=input+"\n";
             //out.write(input.getBytes());
             //p.wait(10000);
             //out.flush();
        }catch (IOException e) {  
             e.printStackTrace();  
        }  
    }  
}  