class Solution {
    List<Integer>[] graph;
    int n, minDistance, node;
    public int[] closestNode(int n, int[][] edges, int[][] query) {
        this.n = n;
		
		// Build the graph
        this.graph = new ArrayList[n];
        for (int[] e : edges) {
            if (graph[e[0]] == null) graph[e[0]] = new ArrayList<>();
            if (graph[e[1]] == null) graph[e[1]] = new ArrayList<>();
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
		
		// Get the result
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
		
			// distances array is the distances from the target node to every node in the tree
			// Use BFS to get distances array
            int[] q = query[i], distances = getDistance(q[2]);
			
			// Suppose the start node is cloest to the target
            this.minDistance = distances[q[0]];
            this.node = q[0];
			
			// Use DFS to find nodes in the path from the start node to the end node
            boolean[] visited = new boolean[n];
            visited[q[0]] = true;
            dfs(q[0], q[1], distances, visited);
            res[i] = this.node;
        }
        return res;
    }
	
	// Use BFS to get distances array
	// distances array is the distances from the target node to every node in the tree
    private int[] getDistance(int node) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int[] distances = new int[n];
        q.offer(node);
        visited[node] = true;
        int curDistance = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (graph[cur] == null) continue;
                for (int next : graph[cur]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.offer(next);
                    distances[next] = curDistance;
                }
            }
            curDistance++;
        }
        return distances;
    }
	
	// Use DFS to find nodes in the path from the start node to the end node
	// If the node is in the path, we compare the distance, otherwise we do nothing
    private boolean dfs(int start, int end, int[] distance, boolean[] visited) {
        if (start == end) return true;
        for (int next : graph[start]) {
            if (visited[next]) continue;
            visited[next] = true;
            if (dfs(next, end, distance, visited)) {
                if (this.minDistance > distance[next]) {
                    this.minDistance = distance[next];
                    this.node = next;
                }
                return true;
            }
        }
        return false;
    } 
}