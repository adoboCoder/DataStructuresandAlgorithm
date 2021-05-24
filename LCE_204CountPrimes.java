class LCE_204CountPrimes{
    public static int countPrimes(int n){
        boolean[] primes = new boolean[n];

        for(int i = 0; i < primes.length; i++){
            primes[i] = true;
        }

        for(int i = 2; i * i < primes.length; i++){
            if(primes[i]){
                for(int j = i; j * i < primes.length; j++) {
                    primes[j * i] = false;
                }
            }
        }

        int primesCount = 0;

        for(int i = 2; i < primes.length; i++){
            if(primes[i]){
                primesCount++;
            }
        }
        return primesCount;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(LCE_204CountPrimes.countPrimes(n));
        n = 3;
        System.out.println(LCE_204CountPrimes.countPrimes(n));
        
    }
}