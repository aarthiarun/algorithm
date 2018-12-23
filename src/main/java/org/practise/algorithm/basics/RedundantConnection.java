package org.practise.algorithm.basics;

/**
 * 684. Redundant Connection
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added.
 * The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v,
 * that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers,
 * return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 *
 * Update (2017-09-26):
 * We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph.
 * For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
 */
public class RedundantConnection {
    int MAX_EDGE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) return edge;
        }
        throw new AssertionError();
    }

    class DSU {
        int[] parent;
        int[] rank;
        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int x) {
            if (x != parent[x])
                parent[x] = findParent(parent[x]);
            return parent[x];
        }

//        SIMPLE APPROACH
//        public void union(int x, int y) {
//            parent[find(x)] = find(y);
//        }

        // union-by-rank
        public boolean union(int x, int y) {
            int parentX = findParent(x),  parentY = findParent(y);
            if (parentX == parentY)
                return false;
            else if (rank[parentX] > parent[parentY]) {
                parent[parentY] = parentX;
            } else if (rank[parentX] < parent[parentY]){
                  parent[parentX] = parentY;
            } else {
                parent[parentY] = parentX;
                rank[parentX]++;
            }
            return true;
        }
    }
}
