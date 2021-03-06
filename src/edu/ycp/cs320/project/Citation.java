package edu.ycp.cs320.project;

import java.util.Observable;


import edu.ycp.cs320.project.controller.CitationController;

public class Citation extends Observable{

	private FormatType format;
	private Source source;
	private Website website;
	private Book book;
	private Journal journal;
	private Periodical periodical;
	private SourceType type;
	private String formattedCite;

	
	/**
	 * Constructor for a book citation.
	 * 
	 * @param book     the book
	 * @param format   the format in which to generation the citation
	 * @param source2  additional source associated with the book (for example, the book's website)
	 */

	public Citation(Source source,FormatType format) {
		this.source=source;
		this.format=format;
	}

	

	public Citation() {
		// TODO Auto-generated constructor stub
	}



	public FormatType getformat() {
		
		return format;
	}
	public SourceType getsourcetype() {
		
		return type;
	}

	public Source getSource(){
		return this.source;
	}
	public Book getbook(){
		return (Book)source;
	}
	public Website getwebsite(){
		return (Website)source;
	}
	public Journal getjournal(){
		return (Journal)source;
	}
	public Periodical getmagazine(){
		return (Periodical)source;
	}

	public void setSource(Source source) {
		this.source = source;
		
		if(source.getSourceType() == SourceType.BOOK){
			this.setbook((Book) source);
		}

		if(source.getSourceType() == SourceType.PERIODICAL){
			this.setmagazine((Periodical) source);
		}
		if(source.getSourceType() == SourceType.WEBSITE){
			this.setwebsite((Website) source);
		}
		if(source.getSourceType() == SourceType.JOURNAL){
			this.setjournal((Journal) source);
		}
		
		setChanged();
		notifyObservers();
		
	}
	public void setwebsite(Website website){
		
		this.website=website;
		setChanged();
		notifyObservers();
	
	}
	public void setjournal(Journal journal){
		this.journal=journal;
		setChanged();
		notifyObservers();
		
	}
	public void setmagazine(Periodical periodical){
		this.periodical=periodical;
		setChanged();
		notifyObservers();
	}	
	public void setbook(Book book){
		System.out.print("a");
		this.book=book;
		setChanged();
		notifyObservers();
	}	

	public void setformattype(FormatType format){
		this.format=format;
		setChanged();
		notifyObservers();
	}
	public void setsourcettype(SourceType type) {
		this.type=type;
		setChanged();
		notifyObservers();
		
	}
	public String getFormattedCite(){
		return formattedCite;
	}


	public void formatcit() {
		
		if(getformat().equals(FormatType.MLA)){
			formattedCite=printmla();
		}
		if(getformat().equals(FormatType.APA)){
			formattedCite=printapa();
		}
		if(getformat().equals(FormatType.CHICAGO)){
			formattedCite=printchicago();
		}
	}

	private String printchicago() {
		String cit = null;

		if(source.getSourceType() == SourceType.BOOK){
			cit=source.getlast()+", "+getbook().getfirst()+". "+getbook().gettitle()+" "+getbook().getcity()+": "+getbook().getpublisher()+", "+getbook().getdate()+".";
		}

		if(source.getSourceType() == SourceType.PERIODICAL){
			cit=getmagazine().getlast()+", "+getmagazine().getfirst()+". \""+getmagazine().gettitle()+"\". "+getmagazine().getmagazine()+", "+getmagazine().getdate()+".";
		}
		if(source.getSourceType() == SourceType.WEBSITE){
			cit=getwebsite().getlast()+", "+getwebsite().getfirst()+". \""+getwebsite().gettitle()+"\". "+getwebsite().getwebsite()+", Last modified "+getwebsite().getdate()+". "+"Accessed"+" "+((Website) source).getmonth(getwebsite().getaccess().substring(0,2))+" "+getwebsite().getaccess().substring(3,5)+", "+getwebsite().getaccess().substring(6,10)+". "+getwebsite().geturl()+".";
		}
		if(source.getSourceType() == SourceType.JOURNAL){
			cit=getjournal().getlast()+", "+getjournal().getfirst()+". \""+getjournal().gettitle()+"\". "+getjournal().getjournal()+" "+getjournal().getvolume()+" ("+getjournal().getdate()+"): "+getjournal().getpagenumber();

		}
		return cit;
	}
	
	private String printapa() {
		String cit=null;

		if(source.getSourceType() == SourceType.BOOK){
			cit=getbook().getlast()+", "+getbook().getfirst().charAt(0)+". ("+getbook().getdate()+"). "+getbook().gettitle()+". "+getbook().getcity()+": "+getbook().getpublisher()+".";
		}

		if(source.getSourceType() == SourceType.PERIODICAL){

			cit=getmagazine().getlast()+", "+getmagazine().getfirst().charAt(0)+". ("+getmagazine().getdate()+"). \""+ getmagazine().gettitle()+"\". "+getmagazine().getmagazine()+", "+getmagazine().getvolumenumber()+", "+getmagazine().getpagenumber()+".";
		}
		if(source.getSourceType() == SourceType.WEBSITE){
			cit=getwebsite().getlast()+", "+getwebsite().getfirst().charAt(0)+". ("+getwebsite().getdate()+"). \""+getwebsite().gettitle()+"\". Retrieved from "+getwebsite().geturl();
		}
		if(source.getSourceType() == SourceType.JOURNAL){

			cit=getjournal().getlast()+", "+getjournal().getfirst().charAt(0)+". ("+getjournal().getdate()+"). \""+getjournal().gettitle()+"\". "+getjournal().getjournal()+", "+getjournal().getvolume()+", "+getjournal().getpagenumber()+".";

		}

		return cit;
	}



	private String printmla(){
		String cit=null;
		if(source.getSourceType() == SourceType.BOOK){
		cit=getbook().getlast()+", "+getbook().getfirst()+". "+getbook().gettitle()+". "+getbook().getcity()+": "+getbook().getpublisher()+", "+getbook().getdate()+". "+getbook().getmedium()+".";
		}
		if(source.getSourceType() == SourceType.PERIODICAL){
			cit=getmagazine().getlast()+", "+getmagazine().getfirst()+". \""+getmagazine().gettitle()+"\". "+getmagazine().getmagazine()+" "+getmagazine().getdate()+": "+getmagazine().getpagenumber()+". "+getmagazine().getmedium()+".";
		}
		if(source.getSourceType() == SourceType.WEBSITE){
			cit=getwebsite().getlast()+", "+getwebsite().getfirst()+". \""+getwebsite().gettitle()+"\". "+getwebsite().getwebsite()+". "+getwebsite().getpublisher()+", " +getwebsite().getdate()+". "+getwebsite().getmedium()+". "+getwebsite().getaccess().substring(3,5)+" "+((Website) source).getmonth(getwebsite().getaccess().substring(0,2))+" "+getwebsite().getaccess().substring(6,10)+". <"+getwebsite().geturl()+">.";
		}
		if(source.getSourceType() == SourceType.JOURNAL){
			cit=getjournal().getlast()+", "+getjournal().getfirst()+". \""+getjournal().gettitle()+"\". "+getjournal().getjournal()+" "+getjournal().getvolume()+" ("+getjournal().getdate()+"): "+getjournal().getpagenumber()+". "+getjournal().getmedium()+".";
		}
		return cit;

	}


}








