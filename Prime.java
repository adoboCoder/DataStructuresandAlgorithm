class Prime{
    public static boolean isPrime(int n){
        if (n <= 1)
        return true;

        for (int i = 2; i < n; i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main (String[] args) {
        int n = 25;

        for(int i = 1; i <= n; i++){
            String b = Prime.isPrime(i) == true ? "is a prime number." : "is not a prime number.";
            System.out.println(i + " " + b); 
        }
    }
}