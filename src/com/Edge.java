/**
 * 
 */
package com;

/**
 * @author Sanjeev
 *
 */
public class Edge {
	private final String id;//This will be used for recognizing the edge among edges
    private final Vertex source;
    private final Vertex destination;
    private final int weight;//This will be used for the weight of each edge. It could be any number which can be used in arithmetic ; 
                             //but here we consider it as an integer. 

    public Edge(String id, Vertex source, Vertex destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }
    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }
}
