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