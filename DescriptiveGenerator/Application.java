
public class Application {
	public static void main(String[] args) {
		boolean genNoun = false;
		int nouns = 0;
		int adjectives = 0;

		if (args.length == 1) {
			genNoun = true;
			adjectives = Integer.parseInt(args[0]);
		} else if (args.length != 2) {
			System.err.println("Unknown arguments, use: [number] [noun]<optional>");
			return;
		}
	
		Dictionary dict = new Dictionary("adjectives.txt");
		
		System.out.println(dict.genWords(Integer.parseInt(args[0])));
	}
}
