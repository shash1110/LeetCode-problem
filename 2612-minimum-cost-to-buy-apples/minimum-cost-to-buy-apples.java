class Solution {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        n++;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Map<Integer, List<int[]>> ans = new HashMap<>();
        for (int i = 0; i < n; i++) ans.put(i, new ArrayList<>());
        for (int i = 1; i < n; i++) ans.get(0).add(new int[] { i, appleCost[i - 1] });
        for (int[] road : roads) {
            int src = road[0], dst = road[1], c = road[2];
            int cost = (k + 1) * c;
            ans.get(src).add(new int[] { dst, cost });
            ans.get(dst).add(new int[] { src, cost });
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], cost = curr[1];
            if (dist[node] < cost) continue;
            for (int[] neighbor : ans.get(node)) {
                int next = neighbor[0], newCost = cost + neighbor[1];
                if (dist[next] > newCost) {
                    dist[next] = newCost;
                    q.add(new int[] { next, newCost });
                }
            }
        }
        long[] result = new long[n - 1];
        for (int i = 1; i < n; i++) result[i - 1] = dist[i];
        return result;
    }
}
