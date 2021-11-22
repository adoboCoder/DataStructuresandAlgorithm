import java.util.*;

class BlendGetPairSum {
    public static List<Integer> getPairSum(List<Integer> firstList, List<Integer> secondList, int target) {
        Set<Integer> set = new HashSet<>(secondList);
        for(Integer n : firstList) {
            if(set.contains(target - n)) {
                List<Integer> result = new ArrayList<>();
                result.add(n);
                result.add(target - n);
                return result;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(2);
        l1.add(3);
        l1.add(5);
        l1.add(9);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(3);
        l2.add(6);
        l2.add(9);
        l2.add(10);

        System.out.println(Arrays.toString(BlendGetPairSum.getPairSum(l1, l2, 6).toArray()));
    }
}