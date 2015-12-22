package meiavy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.LineNumberReader;

public class AppRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("args len:"+args.length);
		for(int i=0;i<args.length;i++)
		{
			System.out.println(args[i]);
		}
		
		if(args.length==1 && "-bat".equals(args[0]))
		{
			try {
				System.out.print("please enter preifx:");
				
				byte[] buf = new byte[1024];
				int count=System.in.read(buf);
				String prefix = new String(buf,0,count).trim();
				System.out.println("start to generate bat...");
				generateBat(prefix);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		
		try {
			System.out.print("please enter base url:");
			byte[] base = new byte[1024];
			int count=System.in.read(base);
			String baseUrl = new String(base,0,count).trim();

			System.out.print("please enter start page number:");
			byte[] start = new byte[1024];
			count=System.in.read(start);
			
			int startIndex = Integer.parseInt(new String(start,0,count).trim());

			System.out.print("please enter end page number:");
			byte[] end = new byte[1024];
			count=System.in.read(end);
			int endIndex = Integer.parseInt(new String(end,0,count).trim());
			
			SearcherApp app=new SearcherApp(baseUrl, startIndex, endIndex,getRunPath());
			app.doSearch();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void generateBat(String prefix) throws IOException {
		// TODO Auto-generated method stub
		File[] currentFiles=getFileEndWithCurrent();
		for(File f:currentFiles)
		{
			createBat(f,prefix);
		}
	}

	private static File[] getFileEndWithCurrent() {
		// TODO Auto-generated method stub
		File dir=new File(getRunPath());
		if(!dir.isDirectory())
		{
			return new File[0];
		}
		File[] currentFiles=dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".current");
			}
		});
		return currentFiles;
	}

	private static void createBat(File f, String prefix) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		LineNumberReader lr=new LineNumberReader(br);
		
		FileWriter fw=new FileWriter(getBatFile(f));
		BufferedWriter bw=new BufferedWriter(fw);
		
		while(true)
		{
			String line=lr.readLine();
			if(line==null)
			{
				break;
			}
			bw.append(prefix+line);
			bw.newLine();
		}
		bw.close();
		lr.close();
	}

	private static File getBatFile(File f) {
		// TODO Auto-generated method stub
		String current=f.getPath();
		String batPath=current.replace(".current", ".bat");
		System.out.println("bat path is:"+batPath);
		return new File(batPath);
	}

	private static String getRunPath() {
		// TODO Auto-generated method stub
		String jarPath = SearcherApp.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		File appFile=new File(jarPath);
		System.out.println("App run in "+appFile.getParent());
		
		return appFile.getParent();
	}

}
