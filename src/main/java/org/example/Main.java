package org.example;

import org.example.Utility.Utility;

import static org.example.Graphs.Find_if_Path_Exists_in_Graph.validPath;
import static org.example.Graphs.Find_if_Path_Exists_in_Graph.dfsWithStack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        int[][] array =Utility.readJsonData("C:\\Users\\HP\\IdeaProjects\\Leetcode\\src\\main\\java\\org\\example\\TestCases\\testCases.json") ;

 boolean ans= dfsWithStack(200000, array, 62749, 104478);
 System.out.println(ans);
    }

}