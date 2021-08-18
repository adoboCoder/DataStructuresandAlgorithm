class Qualtrics {
    public static int[] histogram(int[] arr, int x) {

        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            max = Math.max(max, arr[i]);
        }
        int slots = 0;

        if (max % x == 0) {
            slots = max / x;
        } else {
            slots = (max / x) + 1;
        }
        int result[] = new int[slots];

        for (int i = 0; i < arr.length - 1; i++) {
            int bucket = arr[i] % x != 0 ? ;
            result[bucket] += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {20, 2, 5, 24, 3, 7}; 
        int width = 5;
        int[] x = Qualtrics.histogram(input, width);

        for(int i = 0; i < x.length; i++) {
            System.out.println(i + ": " + x[i]);
        }
    }
}