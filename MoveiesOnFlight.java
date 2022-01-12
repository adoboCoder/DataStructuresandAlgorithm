import java.util.*;

class MoveiesOnFlight {
    public static List<Integer> findMovies(int[] list, int target) {
        target = target - 30;
        List<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);

        int[][] movies = new int[list.length][2];
        for (int i = 0; i < list.length; i++) {
            movies[i][0] = list[i]; // Movie duration
            movies[i][1] = i; // Original index of the movie
        }
        Arrays.sort(movies, (a, b) -> a[0] - b[0]);

        int left = 0;
        int right = list.length - 1;
        int max = 0;

        while (left < right) {
            if (movies[left][0] + movies[right][0] > target) {
                right--;
            } else {
                if (movies[left][0] + movies[right][0] > max) {
                    max = movies[left][0] + movies[right][0];
                    result.set(0, movies[left][1]);
                    result.set(1, movies[right][1]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMovies(new int[] { 90, 85, 75, 60, 120, 150, 125 }, 250));
        System.out.println(findMovies(new int[] { 90, 85, 75, 60, 155, 150, 125 },
                250));
        System.out.println(findMovies(new int[] { 90, 85, 75, 60, 120, 110, 110, 150,
                125 }, 250));
        System.out.println(findMovies(new int[] { 95, 85, 75, 60, 120, 110, 110, 150,
                125 }, 250));
        System.out.println(findMovies(new int[] { 1, 10, 25, 35, 60 }, 90));
        System.out.println(findMovies(new int[] { 20, 50, 40, 25, 30, 10 }, 90));
        System.out.println(findMovies(new int[] { 5, 55, 40, 20, 30, 30 }, 90));
    }
}