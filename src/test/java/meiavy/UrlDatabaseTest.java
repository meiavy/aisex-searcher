package meiavy;
import java.util.Set;

import junit.framework.TestCase;


public class UrlDatabaseTest extends TestCase {
	public void testUniqueSave()
	{
		UrlDatabase db=new MemoryDatabase();
		
		SearchResult sr=new SearchResult();
		String keyWord="a";
		String link1="link_a1";
		String link2="link_a2";
		sr.add(keyWord, link1);
		sr.add(keyWord, link2);
		db.uniqueSave(sr);
		
		Set<String> history=db.getHistory(keyWord);
		assertNotNull(history);
		assertEquals(2, history.size());
		assertTrue(history.contains(link1));
		assertTrue(history.contains(link2));
	}
	
}
