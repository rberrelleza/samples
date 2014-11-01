package samples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class Words {

	public static Boolean shrink(String word, HashSet<String> lexicon, Stack<String> path)
	{
		if(word.isEmpty())
		{
			return true;
		}
		
		if(lexicon.contains(word))
		{
			path.push(word);
			for(int i = 0; i < word.length(); i++)
			{
				String sub = word.substring(0,  i) + word.substring(i + 1);
				if (Words.shrink(sub, lexicon, path))
				{
					return true;
				}
			}
			
		}else
		{
			return false;
		}
		
		return false;
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = null;
		HashSet<String> lexicon = null;
		try{
			br = new BufferedReader(new FileReader(new File("/usr/share/dict/words")));
			lexicon = new HashSet<String>();
			String line;
			
			while((line = br.readLine()) != null)
			{
				lexicon.add(line.toLowerCase());
			}
		}
		finally{
			br.close();
		}
		
		try{
			for(String word : lexicon)
			{
				Stack<String> path = new Stack<String>();
				if(Words.shrink(word, lexicon, path)){
					System.out.println(String.format("%s:%s", word, path));
				}
				else
				{
					System.out.println(String.format("%s: Nop", word));
				}
			}
			
			/**br = new BufferedReader(new InputStreamReader(System.in));
			String word = br.readLine();
			
			if (word.isEmpty()){
				System.err.println("Empty word!");
				return;
			}else{
				Stack<String> path = new Stack<String>();
				if(Words.shrink(word, lexicon, path)){
					System.out.println("there's a path");
					System.out.println(path);
				}
				else
				{
					System.out.println(String.format("There's no path for %s", word));
				}
			}**/
		}
		finally
		{
			//br.close();
		}
	}

}
