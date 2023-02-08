import java.util.Scanner;

public class LastLetterCount {

    private static String[] firstInstanceS;
    private static String[] firstInstanceY;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        int countS = countWordsEndingWithS(sentence);
        int countY = countWordsEndingWithY(sentence);
        String newSentence = switchWords(sentence, Integer.valueOf(firstInstanceS[1]), 
                Integer.valueOf(firstInstanceY[1]));
        System.out.println("The new sentence is: " + newSentence);
        scanner.close();
    }

    private static int countWordsEndingWithS(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;
        for (int x=0;x<words.length-1;x++) {
            if (words[x].endsWith("s")) {
                if (count==0){firstInstanceS= new String[]{words[x],String.valueOf(x)};}
                count++;
            }
        }
        System.out.println("First word : " + firstInstanceS[0]+" | Index : " + firstInstanceS[1]
                + " | Count : " + count);
        return count;
    }

    private static int countWordsEndingWithY(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;
        for (int x = 0; x < words.length - 1; x++) {
            if (words[x].endsWith("y")) {
                if (count == 0) {firstInstanceY = new String[]{words[x],String.valueOf(x)};  }
                count++;
            }
        }
        System.out.println("First word : " + firstInstanceY[0] + " | Index : "
                + firstInstanceY[1] + " | Count : " + count);
        return count;
    }

    private static String switchWords(String sentence, int firstIndex, int secondIndex) {
        String[] words = sentence.split(" ");
        String temp = words[firstIndex];
        words[firstIndex] = words[secondIndex];
        words[secondIndex] = temp;
        StringBuilder newSentence = new StringBuilder();
        for (String word : words) {
            newSentence.append(word).append(" ");
        }
        return newSentence.toString();
    }
}
