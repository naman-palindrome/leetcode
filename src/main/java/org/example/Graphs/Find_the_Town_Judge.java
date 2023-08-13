package org.example.Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Find_the_Town_Judge {

    public int findJudge(int n, int[][] trust) {
        int[]count=new int[n+1];
        for(int[] t:trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(count[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
