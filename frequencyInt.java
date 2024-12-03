import java.util.*;


public class frequencyInt {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 8, 3, 2, 2, 2, 5, 1 };
        Map <Integer,Integer> map = new HashMap<>();

        for(int n:arr){
            int count = map.getOrDefault(n, 0);
            map.put(n, count+1);
        }

        for(int n:map.keySet()){
            System.out.println("Frequency of " + n + " is " + map.get(n));
        }
    }
}
