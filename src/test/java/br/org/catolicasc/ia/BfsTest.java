package br.org.catolicasc.ia;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BfsTest {

    @Test
    void search() {
        //PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.Connect(firstNeighbor);
        firstNeighbor.Connect(start);

        Node<Integer> firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.Connect(firstNeighborNeighbor);
        firstNeighborNeighbor.Connect(firstNeighbor);
        firstNeighborNeighbor.Connect(start);
        start.Connect(firstNeighborNeighbor);

        Node<Integer> secondNeighbor = new Node<>(4);
        start.Connect(secondNeighbor);
        secondNeighbor.Connect(start);

        Bfs.Search(4, firstNeighborNeighbor);

        String expectedString = 
        "Visitando nó com o valor 3\n" + 
        "Visitando nó com o valor 10\n" +
        "Visitando nó com o valor 2\n" +
        "Visitando nó com o valor 4\n";

        assertEquals(expectedString, bos.toString());
    }
}