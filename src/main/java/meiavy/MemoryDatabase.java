package meiavy;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MemoryDatabase extends UrlDatabase {

	private HashMap<String, Set<String>> historys=new HashMap<String, Set<String>>();
	private HashMap<String, Set<String>> currents=new HashMap<String, Set<String>>();
	
	@Override
	protected void updateCurrent(String keyWord,
			Collection<String> keyWordResult) {
		// TODO Auto-generated method stub
		Set<String> current=currents.get(keyWord);
		if(current==null)
		{
			current=new HashSet<String>();
			currents.put(keyWord, current);
		}
		current.addAll(keyWordResult);
	}

	@Override
	protected void updateHistory(String keyWord,
			Collection<String> keyWordResult) {
		// TODO Auto-generated method stub
		Set<String> history=historys.get(keyWord);
		if(history==null)
		{
			history=new HashSet<String>();
			historys.put(keyWord, history);
		}
		history.addAll(keyWordResult);
	}

	@Override
	protected Set<String> getHistory(String keyWord) {
		Set<String> history=historys.get(keyWord);
		if(history!=null)
		{
			return Collections.unmodifiableSet(history);
		}
		return null;
	}

}
