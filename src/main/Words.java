import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        int wordCount = countWords(sentence);
        System.out.println("Number of words: " + wordCount);
    }
    
    private static int countWords(String sentence) {
        String[] words = sentence.split(" ");
        return words.length;
    }
    
}
