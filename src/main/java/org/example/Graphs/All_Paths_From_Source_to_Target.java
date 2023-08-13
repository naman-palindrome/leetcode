package org.example.Graphs;

import javax.naming.ldap.StartTlsRequest;
import java.util.*;

public class All_Paths_From_Source_to_Target {
    public static void main(String[] args) {
        int[][] graph={{4,3,1},{3,2,4},{3},{4},{}};
        allPathsSourceTargetUsingBfs(graph);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList();
        List<Integer> current = new ArrayList();
        current.add(0);
        dfs(0,current,graph,graph.length-1,ans);
        return ans;
    }
    private void dfs(int src, List<Integer> current, int graph[][], int dest, List<List<Integer>> ans){
        if(src == dest){
            ans.add(new ArrayList(current));
            return;
        }
        for(int n : graph[src]){
            current.add(n);
            dfs(n,current,graph,dest,ans);
            current.remove(current.size()-1);
        }
    }
    public static List<List<Integer>> allPathsSourceTargetUsingBfs(int[][] graph) {
        List<List<Integer>> ans = new LinkedList();
        Queue<List<Integer>> bfs  =new LinkedList();
        bfs.add(Arrays.asList(0));
        int dest = graph.length -1;

        while(!bfs.isEmpty()){
            List<Integer> path = bfs.poll();
            int current = path.get(path.size()-1);
            if(current == dest){
                ans.add(new ArrayList(path));
            }
            for(int node : graph[current]){
                List<Integer> newPath = new ArrayList(path);
                newPath.add(node);
                bfs.add(newPath);
            }
        }
        return ans;

    }
}
