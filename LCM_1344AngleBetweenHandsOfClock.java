class LCM_1344AngleBetweenHandsOfClock {
    public static double calculateAngle(int hours, int minutes) {
        double hr = (hours % 12 * 30) + ((double)minutes / 60 * 30);
        double min = minutes * 6;

        double angle = Math.abs(min - hr);

        if (angle > 180) {
            angle = 360 - angle;
        }
        return angle;
    }

    public static void main(String[] args) {
        System.out.println(calculateAngle(12, 30));
        System.out.println(calculateAngle(3, 30));
        System.out.println(calculateAngle(3, 15));
        System.out.println(calculateAngle(4, 50));
        System.out.println(calculateAngle(12, 0));
    }
}
/*
TC O(1) 
SC O(1)

Hour Hand
In 12 hours Hour hand complete whole circle and cover 360°
So, 1 hour = 360° / 12 = 30°

Since 1 hours = 30°
In 1 minute, hours hand rotate -> 30° / 60 = 0.5°
So total angle because of minutes by hour hand is minutes/60 * 30 or minutes * 0.5

Minute Hand
In 60 minutes Minute Hand completes whole circle and cover 360°.
So, 1 minute -> 360° / 60 = 6°

*/