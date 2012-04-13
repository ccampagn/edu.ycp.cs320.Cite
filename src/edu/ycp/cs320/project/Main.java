package edu.ycp.cs320.project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Main {
	

	public static void main(String[] args) throws IOException {
	
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What type of Source are you using ?");
		String source = keyboard.next().toLowerCase();
		enterinformation(source);
		
			
		
	
}

	public static void enterinformation(String source) throws IOException {
		Citation citation = null;
		Book book = null;
		Website website1=null;
		Magazine magazine1=null;
		Journal journal1=null;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What is the author first name?");
		String first = keyboard.next().toLowerCase();
		System.out.print("What is the author last name?");
		String last = keyboard.next().toLowerCase();
		System.out.print("What is the title?");
		String title = keyboard.next().toLowerCase();
		System.out.print("What is the date?");
		String date = keyboard.next().toLowerCase();
		System.out.print("Who is the publisher?");
		String publisher = keyboard.next().toLowerCase();
		if(source.equals("book")){
			System.out.print("What is the city?");
			String city = keyboard.next().toLowerCase();
			 book=new Book(source,first, last, title, date, publisher, city);
			 String format=enterformat();
			citation=new Citation(book,format,source);
			
			
			
			
		}
		if(source.equals("website")){
			System.out.print("What is the url?");
			String url = keyboard.next().toLowerCase();
			System.out.print("What is the access?");
			String access = keyboard.next().toLowerCase();
			System.out.print("What is the website?");
			String website= keyboard.next().toLowerCase();
			website1=new Website(source,first,last,title,date, publisher,url,access,website);
			String format=enterformat();
			citation=new Citation(website1,format, source);
			
		}	
		
		if(source.equals("magazine")){
			System.out.print("What is the magazine?");
			String magazine = keyboard.next().toLowerCase();
			System.out.print("What is the page number?");
			String pagenumber= keyboard.next().toLowerCase();
			System.out.print("What is the volume number?");
			String volumenumber= keyboard.next().toLowerCase();
			magazine1=new Magazine(source,first, last,  title,date,publisher,magazine, pagenumber, volumenumber);
			String format=enterformat();
			citation=new Citation(magazine1,format, source);
			
		}
		if(source.equals("journal")){
			System.out.print("What is the journal?");
			String journal = keyboard.next().toLowerCase();
			System.out.print("What is the volume?");
			String volume = keyboard.next().toLowerCase();
			System.out.print("What is the pagenumber?");
			String pagenumber= keyboard.next().toLowerCase();
			journal1= new Journal(source,first,last,title,  date, publisher, journal, volume,  pagenumber);
			String format=enterformat();
			citation=new Citation(journal1,format,source);
			
		}
		String cit=citation.formatcit();
		System.out.print(cit);
		writetextfile(cit);
	}

	

	public static void writetextfile(String cit) throws IOException {
		  FileWriter writer = new FileWriter("pandp.txt");

          writer.write(cit);
         

          writer.close();

          System.out.println("File written successfully!");
  }
		
	

	private static String enterformat() {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What kind of format do you want?");
		String format= keyboard.next().toLowerCase();
		return format;
	}
}

