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
                int j = (c - 'a') % rows ;  
    //now we compare (x,y) (i,j) ==> move x y to i, j
                    while(y > j){
                        sb.append('L');
                        y--;
                    }
    //and we know once we move to most L (y=0) and we can only go down as "z" is at last row. 
                    while(x < i){
                        sb.append('D');
                        x++;
                    }
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
            return sb.toString();
        }

    public static void main(String args[]) 
    { 
       String output = alphabetBoardPath("zgoogle", 7);
        System.out.println(output); 
    } 
} 
