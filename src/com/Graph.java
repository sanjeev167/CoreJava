/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Sanjeev
 *
 */
public class Graph {
	// In a graph data structure, one vertex is connected with one or more other
	// vertex. So, we are taking a map whose key
	// will represent a vertex and its value is a list of vertex which are connected
	// with this vertex.

	private Map<Vertex, LinkedList<Vertex>> adjacencyMap;

	public Graph() {
		adjacencyMap = new HashMap<>();// initialize the adjencyMap
	}

	/**
	 * This will simply check whether a source vertex is connected with a target
	 * vertext or not.
	 */
	public boolean hasEdge(Vertex source, Vertex target) {
		// As we know that a map has property of checking key availability in it. So, we
		// can check it.
		// First we check whether source is in the map or not.
		// If it is, we should check whether key is null or not. It should be non-null
		// value
		// adjacencyMap.get(source) will return a list of connected vertices. So, we
		// again check whether this list has target or not.
		// If all the above conditions are true together, then we can say that source
		// and target are connected.
		return adjacencyMap.containsKey(source) && adjacencyMap.get(source) != null
				&& adjacencyMap.get(source).contains(target);
	}

	/**
	 * This method is called for inserting a new vertex in the graph. But for
	 * inserting a vertex within a graph, we need to understand the following. [1]
	 * Whether it is a source or target node, both should have their individual
	 * existence within the graph. So, it should be checked and make sure it should
	 * be inserted in the graph with null target i.e. at the time of insertion they
	 * are not connected with any vertex.
	 * 
	 * [2] As the method is receiving source and target vertex to insert into the
	 * graph and supposed to connect source with the target. So, we need to find the
	 * list of vertices connected with the source first . If it is null create a new
	 * list and add this traget. If it already exists, simply add this new target
	 * into it. Lastly put this source and target into the map.
	 */

	public void insert(Vertex source, Vertex target) {
		// check if key or source exists or not
		if (!adjacencyMap.keySet().contains(source)) {
			// put the source
			adjacencyMap.put(source, null);
		}
		if (!adjacencyMap.keySet().contains(target)) {
			// this will make sure even vertex with no edges are included
			adjacencyMap.put(target, null);
		}
		LinkedList<Vertex> temp = adjacencyMap.get(source);
		if (temp == null) {
			temp = new LinkedList<>();
		}
		temp.add(target);
		adjacencyMap.put(source, temp);
	}

	/**
	 * Now, let us print our Graph. It visits all the nodes recursively. For
	 * printing vertices of graph, we start printing each vertices and all its
	 * connected vertices together.
	 */
	public void traverse() {
		for (Vertex root : adjacencyMap.keySet()) {
			System.out.print("Traversing from node " + root.name + " - ");
			LinkedList<Vertex> vertices = adjacencyMap.get(root);
			if (vertices != null) {
				// This will list all the connected vertices with the selected vertex in the
				// loop
				for (Vertex adjacent : adjacencyMap.get(root)) {
					System.out.print(adjacent.name);
				}
			}
			System.out.println();// Line break for starting new vertex and its connected vertices
		}

	}

	/**
	 * 
	 * **/

	public void dfsTraversal(Vertex node) {
		List<Vertex> visitedVertex = new ArrayList<>();
		Stack<Vertex> stack = new Stack<>();
		stack.push(node);
		visitedVertex.add(node);
		while (!stack.isEmpty()) {
			List<Vertex> edges = adjacencyMap.get(stack.peek());
			if (edges != null) {
				Vertex n = edges.stream().filter(edge -> !visitedVertex.contains(edge)).findFirst().orElse(null);
				if (n != null) {
					stack.push(n);
					if (!visitedVertex.contains(n)) {
						visitedVertex.add(n);
					}
				} else {
					stack.pop();
				}
			} else {
				stack.pop();
			}
		}
		visitedVertex.stream().forEach(node1 -> System.out.println(node1.name+" "));
	}

	public void bfsTraverse(Vertex node) {
		List<Vertex> visitedVertexs = new ArrayList<>();
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Vertex visitedVertex = queue.remove();
			if(!visitedVertexs.contains(visitedVertex)) {
			 visitedVertexs.add(visitedVertex);
			System.out.print("\t"+visitedVertex.name+" ");
			}
			List<Vertex> neighbours = adjacencyMap.get(visitedVertex);
			if (neighbours != null) {
				for (int i = 0; i < neighbours.size(); i++) {
					Vertex n = neighbours.get(i);
					if (n != null && !visitedVertexs.contains(n)) {
						queue.add(n);
					}
				}
			}
		} //System.out.print(visitedVertexs);
	}

}
