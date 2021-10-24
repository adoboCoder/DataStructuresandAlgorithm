import java.util.*;

class LCM_71SimplifyPath {
    public static String simPlifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for(String p : paths) {
            if(!stack.empty() && p.equals("..")) stack.pop();
            else if(!p.equals("..") && !p.equals("") && !p.equals(".")) stack.push(p);
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