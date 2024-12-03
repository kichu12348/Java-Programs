public class secondSmall {
    public static void main(String[] args) {
        int[] arr = { 7, 2, 3, 4, 5, 6, 1, 8, 9, 10 };
        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < firstSmall) {
                secondSmall = firstSmall;
                firstSmall = arr[i];
            } else if (arr[i] < secondSmall && arr[i] != firstSmall) {
                secondSmall = arr[i];
            }
        }

        System.out.println("Second smallest element: " + secondSmall);
    }
}
