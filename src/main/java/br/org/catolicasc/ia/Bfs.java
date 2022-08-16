package br.org.catolicasc.ia;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class Bfs {
    public static <T> Optional<Node<T>> Search(T value, Node<T> start){
        Queue<Node<T>> queue = new ArrayDeque<>();
        Set<Node<T>> visitedNodes = new HashSet<>();

        queue.add(start);
    
        while(!queue.isEmpty()){
            Node<T> curreNode = queue.remove();
            System.out.printf("Visitando nó com o valor %s\n", curreNode.getValue());
                                
            if (curreNode.getValue().equals(value)){
                return Optional.of(curreNode);
            } else {
                visitedNodes.add(curreNode);
                queue.addAll(curreNode.getNeighbors());
                queue.removeAll(visitedNodes);
            }
        }

       return Optional.empty();
    }
}
