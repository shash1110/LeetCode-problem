class Solution {
    public int connectSticks(int[] sticks) {
        int ans = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int n  :sticks){
            p.add(n);
        }
        while(p.size()>1){
            int sum = p.remove() + p.remove();
            ans += sum;
            p.add(sum);
        }
        return ans;
    }
}