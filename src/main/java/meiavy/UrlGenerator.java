package meiavy;

public class UrlGenerator {

	private String baseUrl;
	private int startIndex;
	private int endIndex;
	
	private int currentIndex=0;
	
	public UrlGenerator(String baseUrl, int startIndex, int endIndex) {
		// TODO Auto-generated constructor stub
		this.baseUrl=baseUrl;
		this.startIndex=startIndex;
		this.endIndex=endIndex;
		this.currentIndex=startIndex;
	}

	public String getNext() {
		// TODO Auto-generated method stub
		if(currentIndex>endIndex)
		{
			return null;
		}
		String url=baseUrl+currentIndex;
		currentIndex++;
		return url;
	}

}
