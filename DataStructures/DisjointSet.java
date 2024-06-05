public class DisjointSet {
	int[] root;
	int[] rank;

	// Initialize the Root Array
	DisjointSet(int size) {
		root = new int[size];
		rank = new int[size];
		// Mark the Parent nodes of the node itself
		// And mark the rank as 1 for all nodes initially
		for(int i=0; i<size; i++) {
			root[i] = i;
			rank[i] = 1;
		}
	}

	// Find the root node of a given node
	// Use Path compression to optimize
	int find(int node) {
		if(node == root[node]) {
			return node;
		}

		return root[node] = find(root[node]);
	}

	// Join two nodes
	// Use Rank optimisation for better performance
	void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rootX != rootY) {
			if(rank[rootX] > rank[rootY]) {
				root[rootY] = rootX;
			} else if(rank[rootX] < rank[rootY]) {
				root[rootX] = rootY;
			} else {
				root[rootY] = rootX;
				rank[rootX] += 1;
			}
		}
	}

	boolean isConnected(int x, int y) {
		return find(x) == find(y);
	}


	public static void main(String[] args) {

		DisjointSet uf = new DisjointSet(10);
		// 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.isConnected(1, 5)); // true
        System.out.println(uf.isConnected(5, 7)); // true
        System.out.println(uf.isConnected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.isConnected(4, 9)); // true
	}
}