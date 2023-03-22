package examples.Advanced;
import java.util.Scanner;

public class Vowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        int vowelsCount = countVowels(sentence);
        System.out.println("Number of vowels: " + vowelsCount);
        scanner.close();
    }

    private static int countVowels(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = Character.toLowerCase(sentence.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
