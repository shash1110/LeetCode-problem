class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double ans = Double.MAX_VALUE, total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Pair<Double, Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
            list.add(new Pair<>((double) wage[i] / quality[i], quality[i]));

        list.sort(Comparator.comparingDouble(Pair::getKey));
       
        for (Pair<Double, Integer> p : list) {
            pq.add(p.getValue());
            total += p.getValue();
            if (pq.size() > k) total -= pq.poll();
            if (pq.size() == k) ans = Math.min(ans, total * p.getKey());
        }
        
        return ans;
    }
}
