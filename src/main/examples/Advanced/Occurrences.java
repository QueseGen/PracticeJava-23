package examples.Advanced;
import java.util.HashMap;

public class Occurrences {

    public static void main(String[] args) {   
        int[] input = new int[] {10, 10, 5, 12, 3, 5};
        HashMap<Integer, Integer> occurrences = countOccurrences(input);
        
        System.out.print("{ ");
        occurrences.entrySet().forEach(entry -> {
        System.out.print(entry.getKey() + ":" + entry.getValue()+", ");});
        System.out.println("0 }");
    }

    private static HashMap<Integer, Integer> countOccurrences(int[] array) {
        HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int i : array) {
            int count = occurrences.getOrDefault(i, 0);
            occurrences.put(i, count + 1);
        }
        return occurrences;
    }
}