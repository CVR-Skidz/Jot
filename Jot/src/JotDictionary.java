import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JotDictionary {
	public int length = 0;
	private List<String> words = null;

	/**
	 * JotDictionary default constructor, populates field "words" from default
	 * dictionary "./dictionary.txt"
	 */
	public JotDictionary() {
		words = new ArrayList<String>();

		readFile("Dictionaries/dictionary.txt");
	}

	/**
	 * JotDictionary constructor, populates field "words" from dictionary "path"
	 * 
	 * @param path File path to read dictionary contents from
	 */
	public JotDictionary(String path) {
		words = new ArrayList<String>();

		readFile(path);
	}

	/**
	 * Read file from path into 'words"
	 * 
	 * @param path File path
	 */
	private void readFile(String path) {
		Scanner file = null;

		// check file exists
		try {
			file = new Scanner(new File("Dictionaries/"+path));
		} catch (FileNotFoundException exception) {
			System.err.println(path + " does not exist ... aborting");
			return;
		}

		// read file until no more lines
		while (file.hasNext()) {
			words.add(file.nextLine());
		}
		
		file.close();
		length = words.size();
	}

	/**
	 * Print contents of dictionary
	 */
	public void printContents() {
		for (String i : words) {
			System.out.println("[" + words.indexOf(i) + "] " + i);
		}
	}
	
	public String genWords(int wordCount) {
		String output = "";
		Random numberGen = new Random(new Date().getTime());
		
		System.out.println("[New Pass]");
		
		for(int i = 0; i < wordCount; ++i) {
			System.out.println("["+ (i + 1) + "]");
			
			int localIndex = Math.abs(numberGen.nextInt())%length;
			
			output = output.concat(words.get(localIndex%length) + " ");
		}
		
		System.out.println("[End Pass]");
		return output;
	}
}
