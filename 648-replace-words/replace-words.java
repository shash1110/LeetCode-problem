public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0) return sentence;
        
        Set<String> s = new HashSet<>();
        for (String str : dict) s.add(str);
        
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");
        
        for (String word : words) {
            String ans = "";
            for (int i = 1; i <= word.length(); i++) {
                ans = word.substring(0, i);
                if (s.contains(ans)) break;
            }
            sb.append(" " + ans);
        }
        
        return sb.deleteCharAt(0).toString();
    }
}