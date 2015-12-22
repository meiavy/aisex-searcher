package meiavy;

import java.util.HashSet;
import java.util.Set;

public class KeyWordMatcher {

	
	private Set<String> keyWords=new HashSet<String>();
	
	public void addKeyWord(String string) {
		// TODO Auto-generated method stub
		keyWords.add(string);
	}

	public String match(String title) {
		// TODO Auto-generated method stub
		
		for(String keyWord:keyWords)
		{
			if(title.contains(keyWord))
			{
				return keyWord;
			}
		}
		return null;
	}

}
