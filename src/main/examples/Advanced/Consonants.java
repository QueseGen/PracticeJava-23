package examples.Advanced;
import java.util.Scanner;

public class Consonants {

    private static String[] cConsonants;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] cConsonants = countConsonants(sentence);
        System.out.println("Number of consonants: " + cConsonants[1]+"\t| New sentence: "+ cConsonants[0]);
        scanner.close();
    }

    private static String[] countConsonants(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = Character.toLowerCase(sentence.charAt(i));
            if (c >= 'a' && c <= 'z' && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                sentence=sentence.replace(sentence.charAt(i),'*');
                count++;
            }
        }
        return new String[]{sentence, String.valueOf(count)};
    }
}
