package meiavy;

import java.util.Collection;
import java.util.Set;

public abstract class UrlDatabase {

	public void uniqueSave(SearchResult searchResult) {
		// TODO Auto-generated method stub
		removeHistory(searchResult);
		updateHistory(searchResult);
		updateCurrent(searchResult);
	}

	private void updateCurrent(SearchResult searchResult) {
		// TODO Auto-generated method stub
		Set<String> keyWords = searchResult.getKeyWords();
		
		for (String keyWord : keyWords) {
			updateCurrent(keyWord, searchResult.getKeyWordResult(keyWord));
		}
	}

	private void updateHistory(SearchResult searchResult) {
		// TODO Auto-generated method stub
		Set<String> keyWords = searchResult.getKeyWords();
		
		for (String keyWord : keyWords) {
			updateHistory(keyWord, searchResult.getKeyWordResult(keyWord));
		}
	}

	private void removeHistory(SearchResult searchResult) {
		// TODO Auto-generated method stub
		Set<String> keyWords = searchResult.getKeyWords();

		for (String keyWord : keyWords) {
			Set<String> history = getHistory(keyWord);
			if(history!=null)
			{
				Collection<String> links = searchResult.getKeyWordResult(keyWord);
				links.removeAll(history);
			}
		}
	}

	protected abstract void updateCurrent(String keyWord,
			Collection<String> keyWordResult);

	protected abstract void updateHistory(String keyWord,
			Collection<String> keyWordResult);

	protected abstract Set<String> getHistory(String keyWord);
}
