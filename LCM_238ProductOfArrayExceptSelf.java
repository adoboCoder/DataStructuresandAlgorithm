public class LCM_238ProductOfArrayExceptSelf{
    public static int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        int left = 1;
        for(int i = 0; i < nums.length; i++){
            if(i > 0){
                left = left * nums[i - 1];
            }
            result[i] = left;
        }

        int right = 1; 
        for(int i = nums.length - 1; i >=0; i--){
            if(i < nums.length - 1){
                right = right * nums[i + 1];
            }
            result[i] = result[i] * right;
        }
        return result;
    }

    public static void main(String[] agrs) {
        int[] input = new int[] {1,2,3,4};
        input = LCM_238ProductOfArrayExceptSelf.productExceptSelf(input);
        for(int n : input){
            System.out.println(n);
        }
    }
}

/*
[1 ,2 ,3, 4] input


// Initially setting left = 1 and right = 1
left:
[1, 1, 1*2, 1*2*3]

[1, 1, 2, 6]

right:
[2*3*4, 3*4, 4, 1]

[24, 12, 4, 1]         

right * left = 
[1, 1, 2, 6]
[24, 12, 4, 1]         

Answer:[24, 12, 8, 6]

*/