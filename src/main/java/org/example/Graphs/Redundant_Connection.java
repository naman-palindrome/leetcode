package org.example.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Redundant_Connection {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        Map<Integer,List<Integer>> graph = new HashMap<>();


        for (int[] edge : edges) {

            boolean[] visited = new boolean[n+1];   //reinitializing the `visited` array before we start exploring again
/*
Checking if there is already a path between the two nodes before adding an edge, this way we can identify the additional edge that needs to be removed.
*/
            if (dfs(graph, edge[0], edge[1], visited)) {
                return edge;
            }

            graph.computeIfAbsent(edge[0],val->new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1],val->new ArrayList<>()).add(edge[0]);

        }

        return new int[0];          // returning empty list
    }

    private boolean dfs(Map<Integer,List<Integer>>  graph, Integer currNode, Integer targetNode, boolean[] visited) {

        if (currNode.equals(targetNode)) {               // if src(u) reaches dest(v), then stop thr DFS
            return true;
        }

        visited[currNode] = true;

        List<Integer>nodes=graph.getOrDefault(currNode,new ArrayList<>());
        for (Integer next : nodes) {
            if (!visited[next]&&dfs(graph, next, targetNode, visited)) {
                return true;
            }
        }
        return false;
    }
}

