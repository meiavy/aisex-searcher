package meiavy;

import junit.framework.TestCase;

public class UrlGeneratorTest extends TestCase {
	public void testGenerate()
	{
		UrlGenerator g=new UrlGenerator("http://www.aisex.com/bt/thread.php?fid=16&page=",1,3);
		assertEquals("http://www.aisex.com/bt/thread.php?fid=16&page=1", g.getNext());
		assertEquals("http://www.aisex.com/bt/thread.php?fid=16&page=2", g.getNext());
		assertEquals("http://www.aisex.com/bt/thread.php?fid=16&page=3", g.getNext());
		assertNull(g.getNext());
	}
}
