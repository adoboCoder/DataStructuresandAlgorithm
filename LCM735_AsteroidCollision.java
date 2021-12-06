import java.util.*;

class LCM735_AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int a : asteroids) {
            if(a > 0) {
                stack.push(a);
            }
            else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                }
                else if(a + stack.peek() == 0) {
                    stack.pop();
                }

            }
        }
        int[] result = new int[stack.size()];

        for(int i = result.length -1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(LCM735_AsteroidCollision.asteroidCollision(asteroids)));

        int[] asteroids2 = {5, -5};
        System.out.println(Arrays.toString(LCM735_AsteroidCollision.asteroidCollision(asteroids2)));

        int[] asteroids3 = {-2, -1, 1, 2};
        System.out.println(Arrays.toString(LCM735_AsteroidCollision.asteroidCollision(asteroids3)));
    }
}