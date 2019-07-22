import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
	public int length = 0;
	private List<String> words = null;

	/**
	 * Dictionary default constructor, populates field "words" from default
	 * dictionary "./dictionary.txt"
	 */
	public Dictionary() {
		words = new ArrayList<String>();

		readFile("dictionary.txt");
	}

	/**
	 * Dictionary constructor, populates field "words" from dictionary "path"
	 * 
	 * @param path File path to read dictionary contents from
	 */
	public Dictionary(String path) {
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
			file = new Scanner(new File(path));
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
		
		for(int i = 0; i < wordCount; ++i) {
			System.out.println("Generating Word "+ (i + 1));
			
			if(i != 0) {
				output = output.concat(" ");
			}
					
			output = output.concat(words.get((int) (Math.random()*100)%length));
		}
		
		return output;
	}
}
