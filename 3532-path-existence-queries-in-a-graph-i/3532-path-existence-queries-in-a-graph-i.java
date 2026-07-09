class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa != pb) {
                parent[pa] = pb;
            }
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        DSU dsu = new DSU(n);

        // Connect consecutive nodes
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                dsu.union(i, i + 1);
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            ans[i] = (dsu.find(u) == dsu.find(v));
        }

        return ans;
    }
}