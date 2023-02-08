import java.util.Random;
import java.util.Scanner;

public class RotateString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        int size= sentence.length()-1;
        Random random = new Random(System.currentTimeMillis());
        int number = random.nextInt(size) + 1;
        String rotatedWord = rotateWord(sentence, number);
        System.out.println("Count: "+number+"\nNew Word: " + rotatedWord);
        scanner.close();
    }

    private static String rotateWord(String word, int n ) {
        return word.substring(n) + word.substring(0, n);
    }
    
}
