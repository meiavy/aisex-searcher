package meiavy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebPage {

	private URL url;
	private String strUrl;
	
	public WebPage(String url) throws MalformedURLException {
		// TODO Auto-generated constructor stub
		this.url=new URL(url);
		this.strUrl=url;
	}

	public String getHtmlContent() throws IOException {
		// TODO Auto-generated method stub
		Document document=Jsoup.connect(strUrl).timeout(5000).header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.111 Safari/537.36").get();
		//Document document= Jsoup.parse(url, 2*60*1000);
		return document.outerHtml();
	}

}
