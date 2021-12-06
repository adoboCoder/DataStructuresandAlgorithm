package Blind75.Binary;

public class NumberOfOneBits {
    public static int hammingWeight(int n) {
        int ones = 0;

        while(n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }
    public static void main(String[] args) {
        System.out.println(NumberOfOneBits.hammingWeight(00000000000000000000000000001011));
        System.out.println(NumberOfOneBits.hammingWeight(00000000000000000000000010000000));
    }
}
