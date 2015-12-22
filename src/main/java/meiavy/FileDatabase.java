package meiavy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FileDatabase extends UrlDatabase {

	private File path;
	public FileDatabase(String path) {
		super();
		// TODO Auto-generated constructor stub
		this.path=new File(path);
	}

	@Override
	protected void updateCurrent(String keyWord,
			Collection<String> keyWordResult) {
		// TODO Auto-generated method stub
		String fileName=keyWord+"."+"current";
		File currrentFile=new File(path.getPath()+File.separator+fileName);
		try {
			FileWriter fWriter=new FileWriter(currrentFile,true);
			BufferedWriter bWriter=new BufferedWriter(fWriter);
			for(String url:keyWordResult)
			{
				bWriter.append(url);
				bWriter.append("\n");
			}
			bWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void updateHistory(String keyWord,
			Collection<String> keyWordResult) {
		// TODO Auto-generated method stub
		String fileName=keyWord+"."+"history";
		File historyFile=new File(path.getPath()+File.separator+fileName);
		try {
			FileWriter fWriter=new FileWriter(historyFile,true);
			BufferedWriter bWriter=new BufferedWriter(fWriter);
			for(String url:keyWordResult)
			{
				bWriter.append(url);
				bWriter.append("\n");
			}
			bWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected Set<String> getHistory(String keyWord) {
		// TODO Auto-generated method stub
		String fileName=keyWord+"."+"history";
		File historyFile=new File(path.getPath()+File.separator+fileName);
		try {
			FileReader fReader=new FileReader(historyFile);
			BufferedReader bReader=new BufferedReader(fReader);
			LineNumberReader lineReader=new LineNumberReader(bReader);
			Set<String> historySet=new HashSet<String>();
			while(true)
			{
				String line=lineReader.readLine();
				if(line==null)
				{
					break;
				}
				historySet.add(line);
			}
			lineReader.close();
			return historySet;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
