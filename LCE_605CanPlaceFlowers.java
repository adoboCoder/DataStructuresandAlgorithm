class LCE_605CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                int prev = (i == 0 || flowerbed[i - 1] == 0) ? 0 : 1;
                int next = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) ? 0 : 1;
                
                if(prev == 0 && next == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
    }
}

//Time: O(N)
// Space: O(1)