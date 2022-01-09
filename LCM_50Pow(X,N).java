class LCM_50PowXN {
    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n < 0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        if(n % 2 == 0){
            return myPow(x*x, n/2);
        }
        else{
            return x*myPow(x*x, n/2);
        }
    }
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println(LCM_50PowXN.myPow(x, n));

        x = 2.1;
        n = 3;
        System.out.println(LCM_50PowXN.myPow(x, n));

        x = 2.0;
        n = -2;
        System.out.println(LCM_50PowXN.myPow(x, n));
    }
}