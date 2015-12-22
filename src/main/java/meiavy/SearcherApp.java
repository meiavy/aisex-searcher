package meiavy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;

public class SearcherApp {

	private String baseUrl;
	private int startIndex;
	private int endIndex;
	private String runPath;
	private KeyWordMatcher matcher;
	private UrlDatabase db;

	public SearcherApp(String baseUrl, int startIndex, int endIndex,
			String runPath) throws IOException {
		// TODO Auto-generated constructor stub
		this.baseUrl = baseUrl;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.runPath = runPath;
		this.matcher = getKewWordMatcher();
		this.db = new FileDatabase(runPath);
	}

	void doSearch() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		UrlGenerator g = new UrlGenerator(baseUrl, startIndex, endIndex);
		Random rand=new Random();
		while (true) {
			String url = g.getNext();
			if (url == null) {
				break;
			}
			System.out.println(url + "is searching...");
			try
			{
				searchOnePage(url);
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("retry...............................................");
				searchOnePage(url);
			}
			Thread.sleep(rand.nextInt(1000));
		}
	}

	private void searchOnePage(String url) throws IOException{
		// TODO Auto-generated method stub
		WebPage page = new WebPage(url);
		// System.out.println(page.getHtmlContent());
		WebPageSearcher searcher = new WebPageSearcher(page, matcher);
		SearchResult sr = searcher.search();
		db.uniqueSave(sr);
	}

	private KeyWordMatcher getKewWordMatcher() throws IOException {
		// TODO Auto-generated method stub
		String fileName = "keyWords";
		File keyWordFile = new File(runPath + File.separator + fileName);
		FileReader fReader = new FileReader(keyWordFile);
		BufferedReader bReader = new BufferedReader(fReader);
		LineNumberReader lineReader = new LineNumberReader(bReader);
		KeyWordMatcher matcher = new KeyWordMatcher();
		while (true) {
			String line = lineReader.readLine();
			System.out.println(line);
			if (line == null) {
				break;
			}
			matcher.addKeyWord(line);
		}
		lineReader.close();
		return matcher;
	}

}
