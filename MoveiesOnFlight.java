/*
You are on a flight and wanna watch two movies during this flight.
You are given List<Integer> movieDurations which includes all the movie durations.
You are also given the duration of the flight which is d in minutes.
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).

Find the pair of movies with the longest total duration and return they indexes. 
If multiple found, return the pair with the longest movie.

Example 1:

Input: movieDurations = [90, 85, 75, 60, 120, 150, 125], d = 250
Output: [0, 6]
Explanation: movieDurations[0] + movieDurations[6] = 90 + 125 = 215 is the maximum number within 220 (250min - 30min)
*/

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