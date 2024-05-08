class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        String[] ans = new String[score.length];
        
        for (int i = 0; i < score.length; i++) {
            p.add(i);
        }
        
        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int rank = 1;
        while (!p.isEmpty()) {
            int idx = p.poll();
            ans[idx] = (rank <= 3) ? medals[rank - 1] : String.valueOf(rank);
            rank++;
        }
        return ans;
    }
}
