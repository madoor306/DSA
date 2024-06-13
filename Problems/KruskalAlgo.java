class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        if(points == null || points.length == 0) {
            return 0;
        }
        
        int size = points.length;
        UnionFind uf = new UnionFind(size);
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        
        for(int i=0; i<size; i++) {
            int[] c1 = points[i];
            for(int j=i+1; j<size; j++) {
                int[] c2 = points[j];
                int cost = Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);
                Edge ed = new Edge(i, j, cost);
                pq.add(ed);
            }
        }
        
        int count = size - 1;
        int result = 0;
        while(!pq.isEmpty() && count > 0) {
            Edge ed = pq.poll();
            if(!uf.isConnected(ed.x, ed.y)) {
                uf.union(ed.x, ed.y);
                count--;
                result += ed.cost;
            }
        }
        
        return result;
    }
}

class Edge {
    int x;
    int y;
    int cost;
    
    Edge(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

class UnionFind {
    int[] root;
    int[] rank;
    
    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for(int i=0; i<size; i++) {
            // Initially before connecting all nodes are root nodes itself
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    // Path Compression
    int find(int x) {
        if(x == root[x]) {
            return x;
        }
        
        return root[x] = find(root[x]);
    }
    
    // Rank Optimisation
    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY) {
            return;
        }
        
        if(rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if(rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }
    
    boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    
}