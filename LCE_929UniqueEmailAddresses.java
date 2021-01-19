class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for(String email : emails) {
            StringBuilder sb = new StringBuilder();
            String localName = email.substring(0,email.indexOf('@'));
                for(char c: localName.toCharArray()) {
                    if (c == '.'){
                        continue;
                    } 
                    if (c == '+'){
                        break;
                    }
                    sb.append(c);
                }
            String cur = sb.toString() + email.substring(email.indexOf('@'));
            set.add(cur);
        }
    return set.size();
    }
}