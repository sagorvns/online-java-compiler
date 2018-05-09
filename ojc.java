//ojc 1

import p1.*; 

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

class editor extends JFrame
{
	//public Static String IP=null;
JFrame f4=new JFrame();
JTextField textf=new JTextField(30);
JButton b2=new JButton("SUBMIT");
FontChooser fontDialog=null;
JLabel l1;
//JTextArea Ta;
JMenuBar mb;
JMenu File,Edit,View;
JMenu project;
JMenuItem Exit,Cut,Copy,Paste,Select,Save,Load,Open,New,Status,SaveAs,Find,Del,Replace,Font,AboutUs,Test;
JMenuItem RunCUI,RunGUI,Compile;
String filename;
FindDialog findReplaceDialog=null;   
JTextArea Ta=new JTextArea(35,55);
JLabel statusBar;
 String path=null;

int lineNumber=0, column=0, pos=0;

    
																												//For find dailog
																												JTextArea tx=new JTextArea(10,20);
																												JButton  b1=new JButton();
																												JFrame f1=new JFrame();
																												JFrame f2=new JFrame();
																												JFrame f3=new JFrame();

						public editor()//constructor call
						{	
/*
        File files = new File("C:\\myjava\\client");
        if (!files.exists()) {
            if (files.mkdirs()) {
              //  System.out.println("Multiple directories are created!");
            } else {
                //System.out.println("Failed to create multiple directories!");
            }

	*/					

								Ta=new JTextArea(); 
								mb= new JMenuBar(); 
								
								File= new JMenu("File"); 
								Edit= new JMenu("Edit"); 
								View= new JMenu("View"); 
								project=new JMenu("Project");
								
								 New=new JMenuItem("New       Ctrl+N");
								 Open=new JMenuItem("Open     Ctrl+O");
								 Save=new JMenuItem("Save      Ctrl+S");
								 SaveAs=new JMenuItem("SaveAs");
								 Exit=new JMenuItem("Exit        Ctrl+Q");
								 SaveAs=new JMenuItem("SaveAs");
								 Compile=new JMenuItem("Compile");
								 RunCUI=new JMenuItem("Run(CUI)");
								  RunGUI=new JMenuItem("Run(GUI)");
								 
								  Del= new JMenuItem("Del");
								  Find= new JMenuItem("Find");
								  Replace=new JMenuItem("Replace");
								  Select = new JMenuItem("Select All"); 
								  
								  Cut = new JMenuItem("Cut");
								  Copy = new JMenuItem("Copy");
								  Paste = new JMenuItem("Paste");
								  Select = new JMenuItem("Select All"); 

								  Status= new JMenuItem("Status"); 
								  Font= new JMenuItem("Font"); 
								    Test= new JMenuItem("Test"); 
								  AboutUs= new JMenuItem("AboutUs"); 
statusBar=new JLabel("||       Ln 1, Col 1  ",JLabel.RIGHT);

																												
								setJMenuBar(mb);
								mb.add(File);
								mb.add(Edit);
								mb.add(View);
								mb.add(project);
								
								File.add(New);
								File.add(Open);
								File.add(Save);
								File.add(SaveAs);
								File.add(Exit);
								
								project.add(Compile);
								project.add(RunCUI);
								project.add(RunGUI);
								
								Edit.add(Cut);
								Edit.add(Copy);
								Edit.add(Paste);        
								Edit.add(Select);
								Edit.add(Find); 
								Edit.add(Replace);     
								Edit.add(Del);
                                
	 							View.add(Status);
								View.add(Font);
								View.add(AboutUs);
								View.add(Test);
	 							add(Ta);
								add(statusBar,BorderLayout.SOUTH);								
								
add(new JScrollPane(Ta),BorderLayout.CENTER);
pack();
setSize(600,600);
	

SaveAs.addActionListener(new evt());
Open.addActionListener(new evt());
Cut.addActionListener(new evt());
Copy.addActionListener(new evt());
Paste.addActionListener(new evt());
Select.addActionListener(new evt());
New.addActionListener(new evt());
Exit.addActionListener(new evt());
Del.addActionListener(new evt());
Find.addActionListener(new evt());
Replace.addActionListener(new evt());
Compile.addActionListener(new evt());
Save.addActionListener(new evt());
Status.addActionListener(new evt());
Font.addActionListener(new evt());
Test.addActionListener(new evt());
AboutUs.addActionListener(new evt());
RunCUI.addActionListener(new evt());
RunGUI.addActionListener(new evt());


setVisible(true);

//server ip
try
{
	//JLabel textl=new JLabel("ENTER SERVER IP");
	f4.setSize(500,100);
	f4.setLayout(new FlowLayout());
	
	JOptionPane.showMessageDialog(f4," MAIN CLASS NAME SHOULD BE PUBLIC AND NAMED tt");
	//f4.add(textf);
	//f4.add(textl);
	//f4.add(b2);
	//f4.setVisible(true);
	
	
																				
}
catch(Exception ew)
{}
/*																				//for ip	
																				class evt3 implements ActionListener
																				{    
																				
																					public void actionPerformed(ActionEvent ae1)
																						{    
																						if(ae1.getSource()==b2)
																						{
																						
																						IP=textf.getText();
																						System.out.print(IP);
																						}
																					}
																				}
																				b2.addActionListener(new evt3());*/
																				
						}//constructor editor close
																					
																	
				class evt  implements ActionListener
				{    
								public evt()
					            {
									super();
								}
								
								public void actionPerformed(ActionEvent e) 
								{
										JMenuItem choice=(JMenuItem)e.getSource();
										
					                    if(choice==SaveAs)
										{
											JFileChooser s=new JFileChooser();
											              
											s.addChoosableFileFilter(new MyFileFilter(".kz","MyNotePadFiles(*.kz)"));
											s.addChoosableFileFilter(new MyFileFilter(".java","MyNotePadFiles(*.java)"));
											s.addChoosableFileFilter(new MyFileFilter(".txt","NotePadFiles(*.txt)"));
											s.addChoosableFileFilter(new MyFileFilter(".*","AllFiles(*.*)"));
											int option=s.showSaveDialog(Save);
											
														if(option==JFileChooser.APPROVE_OPTION) 
														{
															
																		try 
																		{
																				BufferedWriter out=new BufferedWriter(new FileWriter(s.getSelectedFile().getPath()));
																				out.write(Ta.getText()); 
																				out.close();
																		}
																		catch(Exception ex) 
																		{ 
																			System.out.println(ex.getMessage());
																	    }
														}
										}//saveAs close
																		else if(choice==Open)
																		{
																			JFileChooser o=new JFileChooser(); 
																			int option=o.showOpenDialog(Open);
																			
																			if (option==JFileChooser.APPROVE_OPTION) 
																			{
																				Ta.setText(""); 
																					try {
													
																							Scanner scan = new Scanner(new FileReader(o.getSelectedFile().getPath()));
																							while (scan.hasNext()) 
																							Ta.append(scan.nextLine() + "\n");
																						} catch (Exception ex) {
																							
																							System.out.println(ex.getMessage());
																						}
																			}
																		}//open close
																		   
																											else if(choice==Exit)
																											{
																																																							
																														JFrame par1=new JFrame();
																														JOptionPane.showMessageDialog(par1,"MAKE SURE YOUR PROGRAM IS SAVE");
																												
																												
																													//System.exit(0);
																																																								
																											}//exit close
																											
																											else if(choice==Cut)
																											{
																												Ta.cut();
																											}
																											else if(choice == Copy)
																											{	
																												Ta.copy();
																											}
																											else if(choice==Paste)
																											{				  
																												  Ta.paste();
																											}
																											 else if(choice==Select)
																											 {
																												 Ta.selectAll();
																											 }
																											 else if(choice==New)
																										     {
																												  Ta.setText(" ");
																												  setTitle(filename);
																											 }
																											 else if(choice==Del)
																											 {
																												int i=0;
																												String msg=Ta.getSelectedText();
																												i=Ta.getText().indexOf(msg);
																												Ta.replaceRange(" ",i,i+msg.length());
																											 }	
																										
																											 
																											 else if(choice==Save)
																											 {
																												
																												
											JFileChooser s=new JFileChooser();
											              
											s.addChoosableFileFilter(new MyFileFilter(".kz","MyNotePadFiles(*.kz)"));
											s.addChoosableFileFilter(new MyFileFilter(".java","MyNotePadFiles(*.java)"));
											s.addChoosableFileFilter(new MyFileFilter(".txt","NotePadFiles(*.txt)"));
											s.addChoosableFileFilter(new MyFileFilter(".*","AllFiles(*.*)"));
											
											 if(path==null)
											 {
																 int option=s.showSaveDialog(Save);
											
														if(option==JFileChooser.APPROVE_OPTION) 
														{
																		try 
																		{
																				BufferedWriter out=new BufferedWriter(new FileWriter(s.getSelectedFile().getPath()));
																				out.write(Ta.getText()); 
																				out.close();
																				path=s.getSelectedFile().getPath();
																		}
																		catch(Exception ex) 
																		{ 
																			System.out.println(ex.getMessage());
																	    }
														}
											}//if nulll close
																 else
																 {
																	 try
																	 {
																		BufferedWriter out=new BufferedWriter(new FileWriter(path));
																					out.write(Ta.getText()); 
																					out.close();
																	 }
																	 catch(Exception exp)
																	 {															
																		System.out.println(exp.getMessage());
																	 }
																 }
																 
													
																											 
																												 }//save close
																												
																												
																											 
																											else if(choice==Find)
																											 {
																												if(Ta.getText().length()==0)
																												return;	
																												if(findReplaceDialog==null)
																												findReplaceDialog=new FindDialog(Ta);
																												findReplaceDialog.showDialog(f1,true);
																											}//close find
																											
																											else if(choice==Replace)
																											 {
																												 if(Ta.getText().length()==0)
																													return;	

																												if(findReplaceDialog==null)
																												findReplaceDialog=new FindDialog(Ta);
																												findReplaceDialog.showDialog(f1,false);
																											 }//close replace
																										
																											 else if(choice==RunCUI)
																											 {
																/*												 
													 Runtime rs=Runtime.getRuntime();
													try 
													{
													  rs.exec(new String[]{"cmd.exe","/c","start"}); 
													}
													catch (IOException ex) 
													{
													  System.out.println(ex);
													}   
															*/													
																														try { 
																														String input=null;
																														//Process p = Runtime.getRuntime().exec("javac j2.java");
																														 Process p2 = Runtime.getRuntime().exec("ojc.bat");
																														 BufferedReader in = new BufferedReader(
																														 new InputStreamReader(p2.getInputStream()));

																														//OutputStream out = p.getOutputStream();
																														 String line = null; 
																														 line = in.readLine();
																														 System.out.println(line);
																														 input=input+"\n";
																														// out.write(input.getBytes());
																														// p.wait(10000);
																														 //out.flush();
																													}catch (IOException ee) {  
																														 ee.printStackTrace();  
																													}  
																											 }//RunCUI close
																											 
    																										 else if(choice==RunGUI)
																											 {	
																										               Runtime rs=Runtime.getRuntime();

																														  try 
																														  {
																															  //rs.exec("javac j2.java");
																															  rs.exec("java tt");
																														  }
																															catch (IOException en) 
																															{
																															  System.out.println(en);
																															} 
																											 }//RunGUI close																																																				
																										
																										     else if(choice==Compile)
																											 {
                                                                                                             send se=new send();
																											 se.sen();
																											
																											try
																											{
																												 Thread.sleep(10000);
																											 }
																											 
																											 catch(Exception exc){}
																												
																										     recive re=new recive();
																											 re.run();
																											
																											//for error
																											/*JFrame par=new JFrame();
	    
																													try 
																													{
																														BufferedReader br=new BufferedReader(new FileReader("file.txt"));
																														StringBuilder sb=new StringBuilder();
																														String line=br.readLine();

																														while (line != null) 
																														{
																															sb.append(line);
																															sb.append(System.lineSeparator());
																															line = br.readLine();
																														}
																														String everything=sb.toString();
																														
																													   JLabel lb=new JLabel(everything);	
																											
																														JOptionPane.showMessageDialog(par,lb);
																														
																													}
																													catch(Exception ex)
																													 {
																														System.out.print(ex.getMessage());
																													}
																										*/
																										
																																																				
																											 }//compiled close 
																																											
																											
																											 else if(choice==Status)
																											 {
																												try
																												{
																												 pos=Ta.getCaretPosition();
																												 lineNumber=Ta.getLineOfOffset(pos);
																												column=pos-Ta.getLineStartOffset(lineNumber);
																												}
																												catch(Exception excp)
																												{}
																												if(Ta.getText().length()==0)
																												{
																													lineNumber=0; column=0;
																											    }
																												statusBar.setText("||       Ln "+(lineNumber+1)+", Col "+(column+1));
																												//JCheckBoxMenuItem temp=(JCheckBoxMenuItem)e.getSource();
																												//statusBar.setVisible(temp.isSelected());
																												
																											}//status close*/
																										
																										 else if(choice==Font)
																											 {
																														if(fontDialog==null)
																														fontDialog=new FontChooser(Ta.getFont());

																												if(fontDialog.showDialog(f2,"Choose a font"))
																												   Ta.setFont(fontDialog.createFont());
																												
																											}//Font close		

																										else if(choice==AboutUs)
																											 {
																												 JFrame f7=new JFrame();
																													 String about=
																													"<html><big>ONLINE JAVA COMPILER</big><hr><hr>"
																													
																													+"<p align=right>Prepared by BCA Students"
																													+"<hr><p align=left>SAGOR NEELESH SHARAD<br><br>"
																													+"<strong>Thanx 4 using OJC</strong><br>"
																													+"Ur Comments as well as bug reports r very welcome at<p align=center>"
																													+"<hr><em><big>ojc@gmail.com</big></em><hr><html>";
																													f7.setSize(400,500);
																															f7.setLayout(new FlowLayout());
																															
																													
																															JOptionPane.showMessageDialog(f7,about);
																	 
																												
																											}//ABOUTUS close
																											else if(choice==Test)
																											 {
																												 OnlineTest ot=new OnlineTest();
																												ot.online();
																											 }
				}//unknown
																											 															
				}//action perform close
}//evt class close

						//For Extension//
						class MyFileFilter  extends FileFilter
						{
							 String description;
							 String extension;
								public MyFileFilter(final String ext, final String desc)
								{
									setExtension(ext);
									setDescription(desc);
								}
										public void setDescription(String desc)
										{
											if(desc==null)
											{
												description=new String("ALL(*.*)");
											}
											else
											{
												description=new String(desc);
											}
										}
												public void setExtension(String ext)
												{
													if(ext==null)
													{
														extension=null;
														return;
													}
													extension=new String(ext).toLowerCase();
													if(!ext.startsWith(".")){
														extension="."+extension;
													}
												}
													public String getDescription()
													{
														return description;
													}
															public boolean accept(File f)
															{
																final String filename=f.getName();
																if(f.isDirectory() || extension==null || filename.toUpperCase().endsWith(extension.toUpperCase()))
																
																	return true;
																	return false;				
															}
												//Extension Close//
						}//editor class close
			
class M
{
		public static void main(String args[]) 
		{
		
	
				new editor();
				
		}
}