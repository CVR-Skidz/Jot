
public class Application {
	public static void main(String[] args) {
		boolean genNoun = false;

		if (args.length == 1) {
			genNoun = true;
		} else if (args.length != 2) {
			System.err.println("Unknown arguments, use: [number] [noun]<optional>");
			return;
		}
	
		Dictionary dict = new Dictionary();
		
		System.out.println(dict.genWords(Integer.parseInt(args[0])));
	}
}
