package meiavy;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebPageSearcher {

	
	private WebPage page;
	private KeyWordMatcher keyWords;
	
	public WebPageSearcher(WebPage page, KeyWordMatcher matcher) {
		// TODO Auto-generated constructor stub
		this.page=page;
		this.keyWords=matcher;
	}

	public SearchResult search() throws IOException {
		// TODO Auto-generated method stub
		String html=page.getHtmlContent();
		Document doc = Jsoup.parse(html);
		Elements links = doc.select("a");
		
		SearchResult sr=new SearchResult();
		for(Element e:links)
		{
			String title=e.html();
			String keyWord=keyWords.match(title);
			if(keyWord!=null)
			{
				sr.add(keyWord,e.attr("href"));
			}
		}	
		
		return sr;
	}

}
