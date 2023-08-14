package org.example.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Redundant_Connection {

    public static int[] findRedundantConnection(int[][] edges) {


        int m=edges.length;
        int n=edges[0].length;

        //create graph
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

        for(int edge[]: edges){//array for each in array
            //if it not  contain the key then it add the value
            if(map.containsKey(edge[0])==false){
                map.put(edge[0],new ArrayList<>());
            }

            if(map.containsKey(edge[1])==false){
                map.put(edge[1],new ArrayList<>());
            }

            //add edge so making connection between vertics
            //alse graph[u].add(v) in arraylist
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            boolean visited[] =new boolean[m+1];


            if(dfs(edge[0],-1,map,visited)){
                return edge;
            }
        }
        return new int[] {edges[0][0]};//null
    }

    public static boolean dfs(int src,int parent,HashMap<Integer,ArrayList<Integer>> adj,boolean[] visited){
        visited[src]=true;

        for(int i : adj.get(src)){
            if(visited[i]==false){
                dfs(i,src,adj,visited);
            }
            else if(visited[i]==true && i!=parent){
                return true;//means single or two element
            }
        }
        return false;//otherwise false
    }
}

