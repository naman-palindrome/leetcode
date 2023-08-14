package org.example.Graphs;

import java.util.*;

public class Count_the_Number_of_Complete_Components {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}};
        countCompleteComponents(6, edges);
    }

    public static int countCompleteComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> connectedNodes = dfs(i, graph, visited, new ArrayList<>());
                if(checkIfCompleted(connectedNodes,graph)){
                   ans++;
                }
            }
        }

        return ans;
    }

    static List<Integer> dfs(Integer currElement, Map<Integer, List<Integer>> graph, boolean[] visited, List<Integer> connectedNodes) {
        if (visited[currElement]) {
            return connectedNodes;
        }
        visited[currElement] = true;
        List<Integer> nodes = graph.getOrDefault(currElement, new ArrayList<>());
        List<Integer> newList = new ArrayList(connectedNodes);
        newList.add(currElement);
        for (Integer node : nodes) {
                newList = dfs(node, graph, visited, newList);

        }
        return newList;
    }


    static boolean checkIfCompleted(List<Integer> nodes, Map<Integer, List<Integer>> map) {

        for (Integer node : nodes) {
            List<Integer> list = map.getOrDefault(node, new ArrayList<>());
            List<Integer> connectedNodes=new ArrayList(nodes);
            list.add(node);
            Collections.sort(list);
            Collections.sort(connectedNodes);

            if (!connectedNodes.equals(list)) {
                return false;
            }
        }
        return true;
    }

}
