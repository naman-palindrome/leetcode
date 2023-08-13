package org.example.Graphs;

import java.util.*;

public class Keys_and_Rooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            List<Integer> nodes = rooms.get(curr);
            for (Integer node : nodes) {
                if(!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

}
