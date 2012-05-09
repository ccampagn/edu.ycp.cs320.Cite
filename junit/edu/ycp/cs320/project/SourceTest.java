package edu.ycp.cs320.project;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class SourceTest {
	private Source source;
	private Book book;
	private Journal journal;
	private Website website;
	private Periodical periodical;
	private Citation bookcite;
	private Citation websitecite;
	private Citation journalcite; 
	private Citation periodicalcite;
	private Citation ab;
	private Book a;
	private Website b;
	private Periodical c;
	private MapPersistance map;
	private Map<String,Citation> citeMap;
	

	private Journal d;



	@Before
	public void setUp() {
		map=new MapPersistance();
		ab=new Citation();
		a=new Book();
		b=new Website();
		c=new Periodical();
		d=new Journal();


		periodical=new Periodical (SourceType.PERIODICAL, "Chris","Campagnola", "York Science On The Rise","1999", "York College of Pennsylvania","York Science Reporter","55-67","5","Print");
		book=new Book("Chris","Campagnola", "York College Student Review","2013", "York College of Pennsylvania","York,Pa","Print");
		journal=new Journal(SourceType.JOURNAL, "Chris","Campagnola", "York Science On The Rise","1999", "York College of Pennsylvania","York Science Reporter","5","55-67","Print");
		website=new Website(SourceType.WEBSITE, "Chris","Campagnola", "York College Problems","1111", "York College of Pennsylvania","www.ycp.edu","04/20/2012","York College of Pennsylvania","Web");
		journalcite = new Citation(journal,FormatType.MLA);
		websitecite = new Citation(website,FormatType.MLA);
		periodicalcite= new Citation(periodical,FormatType.MLA);
		bookcite=new Citation(book,FormatType.MLA);
	
	
	}

	@Test

	public void testbook() throws Exception {
		bookcite.getSource();
		assertEquals("Chris", book.getfirst());
		assertEquals(SourceType.BOOK, book.getSourceType());
		assertEquals("Campagnola", book.getlast());
		assertEquals("York College Student Review", book.gettitle());
		assertEquals("2013", book.getdate());
		assertEquals("York College of Pennsylvania",book.getpublisher());
		assertEquals("York,Pa", book.getcity());
		assertEquals("Print",book.getmedium());
		assertEquals(FormatType.MLA,bookcite.getformat());
		bookcite.setsourcettype(SourceType.BOOK);
		assertEquals(SourceType.BOOK,bookcite.getsourcetype());
		assertEquals(book,bookcite.getbook());
		bookcite.setSource(book);
		bookcite.getFormattedCite();
		bookcite.setformattype(FormatType.CHICAGO);
		bookcite.formatcit();
		bookcite.setformattype(FormatType.MLA);
		bookcite.formatcit();
		bookcite.setformattype(FormatType.APA);
		bookcite.formatcit();
		map.saveCitation(bookcite);
		map.findCite("York College Student Review");
	}

	@Test
	public void testwebsite() throws Exception {
		assertEquals("Chris", website.getfirst());

		assertEquals(SourceType.WEBSITE, website.getSourceType());
		assertEquals("Campagnola", website.getlast());
		assertEquals("York College Problems", website.gettitle());
		assertEquals("1111", website.getdate());
		assertEquals("York College of Pennsylvania", website.getpublisher());
		assertEquals("www.ycp.edu", website.geturl());
		assertEquals("04/20/2012", website.getaccess());
		assertEquals("York College of Pennsylvania", website.getwebsite());
		assertEquals("Web",website.getmedium());
		assertEquals(FormatType.MLA,websitecite.getformat());
		websitecite.setsourcettype(SourceType.WEBSITE);
		assertEquals(SourceType.WEBSITE,websitecite.getsourcetype());
		assertEquals(website,websitecite.getwebsite());
		website.setaccess("04/23/2011");
		website.seturl("www.ycp.edu");
		website.setwebsite("YCP");
		websitecite.setSource(website);
		websitecite.setformattype(FormatType.CHICAGO);
		websitecite.formatcit();
		websitecite.setSource(website);
		websitecite.setformattype(FormatType.MLA);
		websitecite.formatcit();
		websitecite.setSource(website);
		websitecite.setformattype(FormatType.APA);
		websitecite.formatcit();
	
	}


	
	

	@Test
	public void testjournal() throws Exception {
		assertEquals("Chris", journal.getfirst());
		assertEquals(SourceType.JOURNAL, journal.getSourceType());
		assertEquals("Campagnola", journal.getlast());
		assertEquals("York Science On The Rise", journal.gettitle());
		assertEquals("1999", journal.getdate());
		assertEquals("York College of Pennsylvania",journal.getpublisher());
		assertEquals("York Science Reporter",journal.getjournal());
		assertEquals("55-67", journal.getpagenumber());
		assertEquals("5", journal.getvolume());
		assertEquals("Print",journal.getmedium());
		assertEquals(FormatType.MLA,journalcite.getformat());
		journalcite.setsourcettype(SourceType.JOURNAL);
		assertEquals(SourceType.JOURNAL,journalcite.getsourcetype());
		assertEquals(journal,journalcite.getjournal());
		journal.setjournal("A Journal");
		journal.setvolume("5");
		journalcite.setSource(journal);
		
		journalcite.setformattype(FormatType.CHICAGO);
		journalcite.formatcit();
	
		journalcite.setformattype(FormatType.MLA);
		journalcite.formatcit();
		
		journalcite.setformattype(FormatType.APA);
		journalcite.formatcit();
	}
	@Test
	public void testperiodical() throws Exception {
		assertEquals("Chris", periodical.getfirst());
		assertEquals(SourceType.PERIODICAL, periodical.getSourceType());
		assertEquals("Campagnola", periodical.getlast());
		assertEquals("York Science On The Rise", periodical.gettitle());
		assertEquals("1999", periodical.getdate());
		assertEquals("York College of Pennsylvania",periodical.getpublisher());
		assertEquals("York Science Reporter",periodical.getmagazine());
		assertEquals("55-67", periodical.getpagenumber());
		assertEquals("5", periodical.getvolumenumber());
		assertEquals("Print",periodical.getmedium());
		assertEquals(FormatType.MLA,periodicalcite.getformat());
		periodicalcite.setsourcettype(SourceType.PERIODICAL);
		assertEquals(SourceType.PERIODICAL,periodicalcite.getsourcetype());
		assertEquals(periodical,periodicalcite.getmagazine());
		periodical.setmagazine("A Wind Storm");
		periodical.setvolume("5");
		periodical.setpagenumber("55-67");
		periodicalcite.setSource(periodical);
	periodicalcite.setformattype(FormatType.CHICAGO);
	periodicalcite.formatcit();
	
		periodicalcite.setformattype(FormatType.MLA);
		periodicalcite.formatcit();
		
		periodicalcite.setformattype(FormatType.APA);
		periodicalcite.formatcit();
	}

	@Test
	public void testsetsource() throws Exception {
		book.setsource(SourceType.BOOK);
		book.setfirst("Joe");
		book.setlast("Bell");
		book.setdate("2013");
		book.settitle("The Wind");
		book.setpublisher("Book");
		book.setcity("New York");
		book.setmedium("Print");
		journal.setjournal("The Daily Planet");
		journal.setpagenumber("55-67");
		assertEquals("Joe", book.getfirst());
		assertEquals(SourceType.BOOK, book.getSourceType());
		assertEquals("Bell", book.getlast());
		assertEquals("The Wind", book.gettitle());
		assertEquals("2013", book.getdate());
		assertEquals("Book",book.getpublisher());
		assertEquals("New York", book.getcity());
		assertEquals("The Daily Planet",journal.getjournal());
		assertEquals("55-67",journal.getpagenumber());

	}
	@Test
	public void testsetbook() throws Exception {
		
	}
	@Test
	public void testgetmonth() throws Exception {

		assertEquals("Jan.", website.getmonth("01"));
		assertEquals("Feb.", website.getmonth("02"));
		assertEquals("Mar.", website.getmonth("03"));
		assertEquals("Apr.", website.getmonth("04"));
		assertEquals("May", website.getmonth("05"));
		assertEquals("Jun.", website.getmonth("06"));
		assertEquals("Jul.", website.getmonth("07"));
		assertEquals("Aug.", website.getmonth("08"));
		assertEquals("Sep.", website.getmonth("09"));
		assertEquals("Oct.", website.getmonth("10"));
		assertEquals("Nov.", website.getmonth("11"));
		assertEquals("Dec.", website.getmonth("12"));
		assertEquals(null, website.getmonth("121"));
	}
	@Test
	public void testcitation() throws Exception {

	}
}








