package EE7_7;
import java.util.ArrayList;



public class alphabetList {

	private static String readNextWord() {
		
		   char ch = TextIO.peek(); // Look at next character in input.
		   while (ch != TextIO.EOF && ! Character.isLetter(ch)) {
		          // Skip past non-letters.
		      TextIO.getAnyChar();  // Read the character.
		      ch = TextIO.peek();   // Look at the next character.
		   }
		   if (ch == TextIO.EOF) // Encountered end-of-file
		      return null;
		   // At this point, we know the next character is a letter, so read a word.
		   String word = "";  // This will be the word that is read.
		   while (true) {
		      word += TextIO.getAnyChar();  // Append the letter onto word.
		      ch = TextIO.peek();  // Look at next character.
		      if ( ch == '\'' ) {
		            // The next character is an apostrophe.  Read it, and
		            // if the following character is a letter, add both the
		            // apostrophe and the letter onto the word and continue
		            // reading the word.  If the character after the apostrophe
		            // is not a letter, the word is done, so break out of the loop.
		         TextIO.getAnyChar();   // Read the apostrophe.
		         ch = TextIO.peek();    // Look at char that follows apostrophe.
		         if (Character.isLetter(ch)) {
		            word += "\'" + TextIO.getAnyChar();
		            ch = TextIO.peek();  // Look at next char.
		         }
		         else
		            break;
		      }
		      if ( ! Character.isLetter(ch) ) {
		            // If the next character is not a letter, the word is
		            // finished, so break out of the loop.
		         break;
		      }
		      // If we haven't broken out of the loop, next char is a letter.
		   }
		   return word;  // Return the word that has been read.
		}
	public static void main(String [] args){
		
		TextIO.readUserSelectedFile();
		
		ArrayList<String> wordList = new ArrayList<String>();
		String word = readNextWord();
     while (word != null) {
        word = word.toLowerCase();  // convert word to lower case
        if ( !wordList.contains(word) ) { // test if word is not already in the arraylist
              // This is a new word, so add it to the list
           wordList.add(word);
        }
        word = readNextWord();
     }
     System.out.println("Number of different words found in file:  " 
             + wordList.size());
     for (String elem: wordList){
    	 System.out.println(elem);
     }
	}
	   
}
