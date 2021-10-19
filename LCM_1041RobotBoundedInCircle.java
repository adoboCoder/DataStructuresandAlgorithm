class LCM_1041RobotBoundedInCircle {
    public static boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int dir = 1; // 1 - North, 2 - East, 3 - Sounth, 4 - West
        
        for(char c : instructions.toCharArray()) {
            if(c == 'G'){
                if(dir == 1) {
                    y++;
                }
                else if( dir == 2){ 
                    x++;
                }
                else if(dir == 3) {
                    y--;
                }
                else{
                    x--;
                }
                    
            }
            else if(c == 'L') {
                 dir = dir == 1 ? 4 : dir-1;
            }
            else {
                dir = dir == 4 ? 1 : dir+1; 
            }
                
        }
        return x == 0 && y == 0 || dir > 1; 
    }

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
    }
}