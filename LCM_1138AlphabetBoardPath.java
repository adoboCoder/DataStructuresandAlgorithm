import java.util.Collections;

class Google {
   public static String alphabetBoardPath(String target, int Kblength) {
    int x = 0;
    int y = 0;
  StringBuilder sb = new StringBuilder();
  for (char ch : target.toCharArray()) {
    int x1 = (ch - 'a') % Kblength;
    int y1 = (ch - 'a') / Kblength;
    sb.append(String.join("", Collections.nCopies(Math.max(0, y - y1), "U")) +
      String.join("", Collections.nCopies(Math.max(0, x1 - x), "R")) +
      String.join("", Collections.nCopies(Math.max(0, x - x1), "L")) +
      String.join("", Collections.nCopies(Math.max(0, y1 - y), "D")) + "!");
    x = x1; y = y1;
  }
  return sb.toString();
    }

    public static void main(String args[]) 
    { 
       String output = alphabetBoardPath("aci", 5);
  
        System.out.println(output); 
    } 
} 
