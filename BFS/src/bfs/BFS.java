/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {


    public static void main(String[] args) throws IOException {
        Reader i = new InputStreamReader (System.in);
        BufferedReader r = new BufferedReader (i);
        String n = r.readLine();
        Integer p = n.indexOf(" ");
        Integer s = n.lastIndexOf(" ");
        
        String pr = n.substring(0,p-1);
        String se = n.substring(p+1,s-1);
        String te = n.substring(s+1,n.length());
        
        int num1 = Integer.parseInt(pr);
        int num2 = Integer.parseInt(se);
        int num3 = Integer.parseInt(te);
        
        List<Integer> g [] = new  List [num2];
        
        for (int h1=0; h1<num2; h1++){
            g[h1] =  new ArrayList(h1);
        }
        
        for (int h=0; h<num2; h++){
            Reader i2 = new InputStreamReader (System.in);
            BufferedReader r2 = new BufferedReader (i);
            String n2 = r.readLine();
            
            int prnodo = Integer.parseInt(n.substring(0, n.lastIndexOf(" ")-1));
            int senodo = Integer.parseInt(n.substring(n.lastIndexOf(" ")+1), n.lastIndexOf(" ")+1); 
            
            g[prnodo].add(senodo);
            g[senodo].add(prnodo);
        }
        List<Integer> siquesi = BreadthFS(g,num3);
        for (int fin=0; fin < siquesi.size(); fin++){
            if (siquesi.size() != 1){
                

            System.out.print(siquesi.get(fin)+" ");
                        }
        }
    }

    public static List<Integer> BreadthFS (List<Integer>[] g, int te) {
        int y = g.length;
        List<Integer> traversal  = new ArrayList<>(y);
        boolean[] visited = new boolean [y];
        Queue <Integer> q = new LinkedList<>();
        visited [te]= true;
        traversal.add(te+1);
        q.add(te);
        while (!q.isEmpty()){
            int aux = q.remove();
            for (int adj : g[aux]){
                if (!visited [adj]){
                    visited[adj]=true;
                    traversal.add(adj+1);
                    q.add(adj);
                }
            }
        }
        return traversal;
    }
    
}
