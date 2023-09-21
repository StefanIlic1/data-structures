import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        Set<String> dictionaryWords = readWords("Chapter 15 Class Notes/src/words");
        // System.out.println(System.getProperty("user.dir"));
        Set<String> novelWords = readWords("Chapter 15 Class Notes/src/throughTheLookingGlass.txt");

        // print all the words from the novel , not in the dictionary
        for (String word: novelWords) {
            if (!dictionaryWords.contains(word)) {
                System.out.println(word);
            }
        }

        // print the number of words in the novel
        System.out.println("There are " + novelWords.size() + " unique words in the novel");

        // print the number of unique words that are greater than 3 letters
        Iterator<String> iterator = novelWords.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().length() <= 3) {
                iterator.remove();
            }
        }
        System.out.println("There are " + novelWords.size() + " unique words with  more than 3 letters in the novel");



    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename), "UTF-8");
        
        // use any character other than letters as delimiters
        // (consider that the end of a word if it is anything but a letter)
        in.useDelimiter("[^a-zA-Z]+");

        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }

        return words;
    }
}
