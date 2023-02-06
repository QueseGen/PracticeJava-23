import java.util.Scanner;

public class Palindrome {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        Boolean isPalindrome = reverseSentence(word);   
        System.out.println("Palindrome: " + isPalindrome); 
    }

     private static boolean reverseSentence(String original) {
        StringBuilder origin = new StringBuilder(original);
        return original.equals(origin.reverse().toString());
    }
}
