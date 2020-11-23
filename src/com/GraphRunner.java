/**
 * 
 */
package com;

import java.util.ArrayList;

/**
 * @author Sanjeev
 *
 */
public class GraphRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		// Add nodes in a graph
		Vertex patna = new Vertex("Patna", "PatnaCityId");
		Vertex mumbai = new Vertex("Mumbai", "MumbaiCityId");
		Vertex kolkatta = new Vertex("Kolkatta", "KolkattaCityId");
		Vertex delhi = new Vertex("Delhi", "DelhiCityId");
		Vertex chennai = new Vertex("Chennai", "ChennaiCityId");

		// patna is connected with rest of the cities
		graph.insert(patna, mumbai);
		graph.insert(patna, kolkatta);
		graph.insert(patna, delhi);
		graph.insert(patna, chennai);

		// mumbai is connected with rest of the cities
		graph.insert(mumbai, patna);
		graph.insert(mumbai, kolkatta);
		graph.insert(mumbai, delhi);
		graph.insert(mumbai, chennai);

		// kolkatta is connected with rest of the cities
		graph.insert(kolkatta, patna);
		graph.insert(kolkatta, mumbai);
		graph.insert(kolkatta, delhi);
		graph.insert(kolkatta, chennai);

		// delhi is connected with rest of the cities
		graph.insert(delhi, patna);
		graph.insert(delhi, mumbai);
		graph.insert(delhi, kolkatta);
		graph.insert(delhi, chennai);

		// delhi is connected with rest of the cities
		graph.insert(chennai, patna);
		graph.insert(chennai, mumbai);
		graph.insert(chennai, kolkatta);
		graph.insert(chennai, delhi);

		// graph.traverse();

		// System.out.println(graph.hasEdge(patna,mumbai));
		// System.out.println(graph.hasEdge(delhi,patna));
		System.out.println("\nStart BFS from Patna ==>\n");
		graph.bfsTraverse(patna);
		System.out.println("\n\nStart BFS from mumbai ==> \n");
		graph.bfsTraverse(mumbai);
		System.out.println("\n\nStart BFS from kolkatta ==> \n");
		graph.bfsTraverse(kolkatta);
		System.out.println("\n\nStart BFS from delhi ==> \n");
		graph.bfsTraverse(delhi);
		System.out.println("\n\nStart BFS from chennai ==>\n");
		graph.bfsTraverse(chennai);

	}

}
