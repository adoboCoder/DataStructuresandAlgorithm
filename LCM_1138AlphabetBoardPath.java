import java.util.Collections;

class Google {
  public static String alphabetBoardPath(String target, int rows) {
    // starting point(x,y)
            int x = 0; 
            int y = 0;
            StringBuilder sb = new StringBuilder();
            for(char c : target.toCharArray()){
    //target point (i,j)
                int i = (c - 'a') / rows;
                System.out.println("i: " + i);  
                int j = (c - 'a') % rows ;  
                System.out.println("j: " + j);
                  
                    while(x < i){
                        sb.append('D');
                        x++;
                    }
                    while(x > i){
                        sb.append('U');
                        x--;
                    }
                    while(y < j){
                        sb.append('R');
                        y++;
                    }
                    while(y > j){
                        sb.append('L');
                        y--;
                    }
                    sb.append("!");    
                }
                return sb.toString();
  }
    public static void main(String args[]) 
    { 
       String output = alphabetBoardPath("zzgoogle", 5);
        System.out.println(output); 
    } 
} 
