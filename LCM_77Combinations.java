import java.util.*;

class LCM_77Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		combine(result, new ArrayList<Integer>(), 1, n, k);
		return result;
	}
	public static void combine(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
		if(k==0) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}
		for (int i = start; i <= n-k + 1 ; i++) {
            tempList.add(i);
            combine(result, tempList, i +1, n, k-1);
            tempList.remove(tempList.size() -1);
        }
    }
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}

/*
TC : O(C(n, k)*k)
*/