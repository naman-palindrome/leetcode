package org.example.Graphs;

import java.util.*;

public class Minimum_Number_of_Vertices_to_Reach_All_Nodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // List to signify if the vertex has an incoming edge or not.
        boolean[] isIncomingEdgeExists = new boolean[n];
        for (List<Integer> edge : edges) {
            isIncomingEdgeExists[edge.get(1)] = true;
        }

        List<Integer> requiredNodes = new ArrayList();
        for (int i = 0; i < n; i++) {
            // Store all the nodes that don't have an incoming edge.
            if (!isIncomingEdgeExists[i]) {
                requiredNodes.add(i);
            }
        }

        return requiredNodes;
    }
}
