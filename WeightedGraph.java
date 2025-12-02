package org.csu.cpsc;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class WeightedGraph <E>{
    private Map<E, Map<E, Integer>> adjList;

    public WeightedGraph(){
        adjList = new HashMap<E, Map<E, Integer>>();
    }

    public void addVertex(E vertex){
        adjList.putIfAbsent(vertex, new HashMap<E, Integer>());
    }

    public void addEdge(E vertexSource, E vertexDestination, int weight){
        //Verify if the vertexSource exists
        if(! adjList.containsKey(vertexSource)){
            addVertex(vertexSource);
        }

        //Verify if the vertexDesitation exists
        if(! adjList.containsKey(vertexDestination)){
            addVertex(vertexDestination);
        }

        adjList.get(vertexSource).put(vertexDestination, weight);
        //adjList.get(vertexDestination).add(vertexSource);
    }

    public boolean hasVertex(E vertex){
        return adjList.containsKey(vertex);
    }

    public boolean hasEdge(E vertexSource, E vertexDestination){
        if(hasVertex(vertexSource)){
            return adjList.get(vertexSource).containsKey(vertexDestination);
        }else{
            return false;
        }
    }

    public int getEdgeWeight(E vertexSource, E vertexDestination){
        if(hasEdge(vertexSource, vertexDestination)){
            return adjList.get(vertexSource).get(vertexDestination);
        }else{
            return -1;
        }
    }

    public String getNeighbors(E vertex){
        String output = "";
        if(adjList.containsKey(vertex)){
            for(E neighbor: adjList.get(vertex).keySet()){
                output += neighbor.toString() + " ";
            }
        }

        return output;
    }

    public ArrayList<E> bfs(E startingVertex){
        Queue<E> queue = new LinkedList<E>();
        ArrayList<E> visited = new ArrayList<E>();

        queue.add(startingVertex);
        visited.add(startingVertex);

        while(! queue.isEmpty()){
            E currentVertex = queue.poll();

            for(E neighbor: adjList.get(currentVertex).keySet()){
                if(! visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return visited;
    }

    public ArrayList<E> dfs(E startingVertex){
        Stack<E> stack = new Stack<E>();
        ArrayList<E> visited = new ArrayList<E>();

        stack.push(startingVertex);

        while(! stack.isEmpty()){
            E currentVertex = stack.pop();

            if(! visited.contains(currentVertex)){
                visited.add(currentVertex);

                for(E neighbor: adjList.get(currentVertex).keySet()){
                    if(! visited.contains(neighbor)){
                        stack.push(neighbor);
                    }
                }
            }
        }

        return visited;
    }
}
