package org.example.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.ceil;

public class Minimum_Fuel_Cost_to_Report_to_the_Capital {

    public static void main(String[] args) {
        int[][] roads = {{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        minimumFuelCost(roads, 2);
    }

    static long ans=0;
    public static long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], val -> new ArrayList<>()).add(road[1]);
            graph.computeIfAbsent(road[1], val -> new ArrayList<>()).add(road[0]);
        }
        dfs(0,-1,graph,seats);
        return ans;
    }
    public static int dfs(int node, int parent, Map<Integer, List<Integer>> graph, int seats){
        int people=1;
        List<Integer> nodes=graph.getOrDefault(node,new ArrayList<>());
        for(Integer adjnode:nodes){
            if(adjnode==parent) continue;
            people+=dfs(adjnode,node,graph,seats);
        }
        if(node!=0){
            ans+=Math.ceil((double)people/seats);
        }
        return people;
    }
}
