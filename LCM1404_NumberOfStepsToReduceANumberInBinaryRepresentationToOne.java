class LCM1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public static int numSteps(String s) {
        int result = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            ++result;
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                ++result;
            }
        }
        return result + carry;
    }

    public static void main(String[] args) {
        System.out.println(LCM1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne.numSteps("1101"));
    }
}