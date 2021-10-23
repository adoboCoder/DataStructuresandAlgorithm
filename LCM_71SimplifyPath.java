import java.util.*;

class LCM_71SimplifyPath {
    public static String simPlifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");

        for(int i = 0; i < p.length; i++) {
            if(!stack.isEmpty() && p[i].equals("..")) {
                stack.pop();
            }
            else if( !p[i].equals(".") && !p[i].equals("") && !p[i].equals("..")) {
                stack.push(p[i]);
            }
        }
        List<String> result = new ArrayList<>(stack);

        return "/" + String.join("/", result);
    }

    public static void main(String[] args) {
        String s = "/home/";
        System.out.println(LCM_71SimplifyPath.simPlifyPath(s));

        s = "/../";
        System.out.println(LCM_71SimplifyPath.simPlifyPath(s));

        s = "/home//foo/";
        System.out.println(LCM_71SimplifyPath.simPlifyPath(s));

        s = "/a/./b/../../c/";
        System.out.println(LCM_71SimplifyPath.simPlifyPath(s));
    }

}