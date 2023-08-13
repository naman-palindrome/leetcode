package org.example.Graphs;

public class Find_Center_of_Star_Graph {
    public int findCenter(int[][] edges) {
        if(edges[1][0] == edges[0][0] || edges[1][0] == edges[0][1])
            return edges[1][0];
        else return edges[1][1];
    }
}
