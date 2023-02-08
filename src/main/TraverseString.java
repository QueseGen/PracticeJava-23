import java.util.HashMap;
import java.util.Scanner;

public class TraverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        HashMap<Character, Integer> uniqueChars = countUniqueChars(sentence);
        StringBuilder together= new StringBuilder();
        for (char chars : uniqueChars.keySet()){
            together=together.append(chars);
        }
        System.out.print(together.toString());
        scanner.close();
    }

    private static HashMap<Character, Integer> countUniqueChars(String sentence) {
        HashMap<Character, Integer> occurrences = new HashMap<Character, Integer>();
        for (char i : sentence.toCharArray()) {
            int count = occurrences.getOrDefault(i, 0);
            occurrences.put(i, count + 1);
        }
        return occurrences;
    }
}