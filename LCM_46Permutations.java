import java.util.*;


class LCM_46Permutations{
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> myList = new ArrayList<>();
        dfs(myList, new ArrayList<>(), nums);
        return myList;
    }
    
    private static void dfs(List<List<Integer>> list, List<Integer> temp, int [] nums){
        if(temp.size() == nums.length){
            list.add(new ArrayList(temp));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(temp.contains(nums[i])){
                    continue; // item already exists
                }
                temp.add(nums[i]);
                dfs(list, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(LCM_46Permutations.permute(new int[] {1, 2, 3}));
    }
}