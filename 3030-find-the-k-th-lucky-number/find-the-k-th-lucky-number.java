class Solution {
    public String kthLuckyNumber(int k) {
        StringBuilder s = new StringBuilder();
         for (int i = k + 1; i > 0; i /= 2)
         s.append((i & 1) == 1 ? '7' : '4');
         return s.reverse().substring(1);
    }
}