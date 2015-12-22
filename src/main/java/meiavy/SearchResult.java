package meiavy;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SearchResult {

	private HashMap<String, Set<String>> results=new HashMap<String, Set<String>>();
	
	public Collection<String> getKeyWordResult(String keyWord) {
		// TODO Auto-generated method stub
		return results.get(keyWord);
	}

	public void add(String keyWord, String link) {
		// TODO Auto-generated method stub
		Set<String> linkSet=results.get(keyWord);
		if(linkSet==null)
		{
			linkSet=new HashSet<String>();
			results.put(keyWord, linkSet);
		}
		linkSet.add(link);
	}

	public Set<String> getKeyWords() {
		// TODO Auto-generated method stub
		Set<String> keyWords=results.keySet();
		if(keyWords!=null)
		{
			return Collections.unmodifiableSet(keyWords);
		}
		return new HashSet<String>();
	}

}
