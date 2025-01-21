package dataStructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")

public class Graph<T> {

    private final Map<T, List<T>> map = new HashMap<>();

    private void addVertex(T source){
        map.put(source, new LinkedList<>());
    }
    private void addEdge(T source, T destination, boolean biDirectional){
        if(!map.containsKey(source)) addVertex(source);
        if(!map.containsKey(destination)) addVertex(destination);

        map.get(source).add(destination);
        if (biDirectional) map.get(destination).add(source);
    }

    private int getVertexCount(){
        return map.keySet().size();
    }
    private int getEdgeCount(boolean biDirectional){
       int count = 0;
       for(T vertex: map.keySet()) count += map.get(vertex).size();

       if(biDirectional) return count/2;
       return count;
    }

    private boolean hasVertex(T v){
        return map.containsKey(v);
    }

    private boolean hasEdge(T s, T d){
        return map.get(s).contains(d);
    }

    public static void main(String[] args) {

    }
}
