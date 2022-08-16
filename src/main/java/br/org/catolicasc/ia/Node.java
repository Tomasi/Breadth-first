package br.org.catolicasc.ia;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
    private T value;
    private Set<Node<T>>  neighbors;

    public Node (T value) {
        this.value = value;
        this.neighbors = new HashSet<>(); 
    }
    
    public T getValue() {
        return value;
    }

    public Set<Node<T>> getNeighbors() {
        return neighbors;
    }

    public void Connect(Node<T> node){
        if(this == node) {
            throw new IllegalArgumentException("Impossível conectar um nó a si mesmo.");
        }

        this.neighbors.add(node);

    }
}
