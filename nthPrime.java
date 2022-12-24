import java.util.*;

class nthPrime {

    static int MAX_SIZE = 2000005;
    static List<Integer> primes = new ArrayList<Integer>();

    static void SieveOfEratosthenes() {
        boolean[] IsPrime = new boolean[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++)
            IsPrime[i] = true;

        for (int p = 2; p * p < MAX_SIZE; p++) {
            if (IsPrime[p] == true) {
                for (int i = p * p; i < MAX_SIZE; i += p)
                    IsPrime[i] = false;
            }
        }

        // Store all prime numbers
        for (int p = 2; p < MAX_SIZE; p++)
            if (IsPrime[p] == true)
                primes.add(p);
    }

    public static void main(String[] args) {
        SieveOfEratosthenes();
        System.out.println(primes.get(4));
        System.out.println(primes.get(15));
        System.out.println(primes.get(1048));

    }

}