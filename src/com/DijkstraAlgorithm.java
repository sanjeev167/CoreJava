/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Sanjeev
 *
 */
public class DijkstraAlgorithm {
	
	private final List<Vertex> graphNodeList;//Will be used for collecting graph nodes
    private final List<Edge> edgeList;//Will be used for collecting graph edges
    private Set<Vertex> settledNodes;//Will be used for storing a node whose sorted distance from the root has been finalized.
    private Set<Vertex> unSettledNodes;//It will be used for keeping unsettled node here and processing of finding shortest distance will take place
    
    private Map<Vertex, Vertex> predecessors;//After finalizing a shortest path of a particular node , its immediate predecessor will be store here
    private Map<Vertex, Integer> distance;//Distance of different vertices from the source will be stored here.

    /**
     * Populate a graph through a constructor.
     * 
     * Here the graph is taking two inputs. First is list of nodes and second is list of edges
     * */
    public DijkstraAlgorithm(Graph1 graph) {
        // create a copy of the array so that we can operate on this array
        this.graphNodeList = new ArrayList<Vertex>(graph.getVertexes());
        this.edgeList = new ArrayList<Edge>(graph.getEdges());
    }

    
    /**
     * This is the main method which will be called for calculating shortest path of different nodes of a graph from the source.
     * The calculated shortest path of different nodes will be stored in a 
     * */
    public void execute(Vertex source) {
        settledNodes = new HashSet<Vertex>();
        unSettledNodes = new HashSet<Vertex>();
        distance = new HashMap<Vertex, Integer>();//This will be utilized for updating shortest path of a node from the source,The shortest path for a node will
                                                  //be updated while processing if any smaller path for a node is found while processing.
                                                 //At the end it will have shortest distance value of each node from source. So, using this map, we can tell 
                                                 //the shortest distance value of each node from source from here.
       
        predecessors = new HashMap<Vertex, Vertex>();//This will be used for telling the path or route for each node with shortest path
        
        distance.put(source, 0);//The distance of a source node to itself [source] is 0.  The distance of other nodes from source will also be stored here
        unSettledNodes.add(source);//Initialize it with source node so that we could start traversing
        
        while (unSettledNodes.size() > 0) {//As long as unsorted node is there, we will keep iterating
            Vertex node = getMinimum(unSettledNodes);//unSettledNodes may have have n no of nodes. But we will pick the shortest one in each iteration
            settledNodes.add(node);//This shortest one among its neighbor will be place in settledNodes.
            unSettledNodes.remove(node);//Now, we remove that has been settled recently
            findMinimalDistances(node);//Now, this method will be called to recalculate the path of this node.
        }
    }

    private void findMinimalDistances(Vertex currentSourceNode) {
        List<Vertex> adjacentNodes = getNeighbors(currentSourceNode);
        
        //It will work for cyclic, too. It is so because any neighbor has higher value from the source will be updated by a smaller value.
        //So, if a neighbor's current value which is already calculated from its one of predecessor is lower , its value will not be updated and it will not be
        //inserted into unSettledNodes.add(neighbor); 
        for (Vertex neighbor : adjacentNodes) {//Here, target is each neighbor node of the currentSourceNode
        	//We will find the ShortestDistance of each neighbor from the currentSourceNode. This distance is initially blank i.e. null 
        	//We will keep updating its [neighbor] distance from the source.
        	//For that, the distance from the source is the sum of the shortest distance of currentSourceNode and the distance between currentSourceNode and
        	// this neighbor. This way each neighbor's distance from the currentSourceNode will be updated.
        	//So, at this point the neighbor's distance from the current source node will get updated.
        	//In the next cycle of iteration of the executed method we will pick the node with minimum distance from unsettled nodes
            if (getShortestDistance(neighbor) > getShortestDistance(currentSourceNode)+ getDistance(currentSourceNode, neighbor)) {
            	
                distance.put(neighbor, getShortestDistance(currentSourceNode) + getDistance(currentSourceNode, neighbor));
                //We need to maintain who is the predecessor of this neighbor node. It is currentSourceNode
                predecessors.put(neighbor, currentSourceNode);
                //At this stage predecessor and the distance of this neighbor node has been updated.
                //Now put this neighbor node within unSettledNodes for processing in the next cycle of execute method
                unSettledNodes.add(neighbor);
            }
            //When the loop terminates, unSettledNodes will have all the neighbor nodes.
        }//If currentSourceNode has no neighbor, then the calculation is assumed to be over for this currentSourceNode.

    }
    
    private int getShortestDistance(Vertex destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /**
     * This method will return the weight assigned between sourceNode and targetNode. For finding this edge value, we use edge sore. Here 
     * edges data structure has already been populated with the edge value for each different pair of vertices.
     * **/
    private int getDistance(Vertex sourceNode, Vertex targetNode) {
        for (Edge edge : edgeList) {
            if (edge.getSource().equals(sourceNode) && edge.getDestination().equals(targetNode)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    /**
     * For knowing neighbors of a particular node, we have to check in edge store first. If this node has edge definition there, 
     * then its different edges will be found there.It could be known just by finding its source and destination. For one source there may 
     * be n no of edges as they have been defined while edge store. 
     * 
     * But, here we are calculating only those edge value of the source node 
     * **/
    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<Vertex>();
        for (Edge edge : edgeList) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex) {
        return settledNodes.contains(vertex);
    }

   
	/*
	 * This method returns the path from the source to the selected target and NULL
	 * if no path exists.
	 * The path includes different nodes in order of their presence in the shortest path.
	 */
	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order as whiling taking out them through predecessor , the comeout in reverse order,
		//So, to show them in right order, you needd to reverse this path collection.
		Collections.reverse(path);
		return path;
	}


	public int getShortestPathWeightFromSourceToDestination(LinkedList<Vertex> path) {
		// TODO Auto-generated method stub
		 int minWeightFromSourceToDestination=0;
		for(int i=0;path!=null&&i<path.size()-1;i++)
		{
			for (Edge edge : edgeList) {
	            if (edge.getSource().equals(path.get(i)) && edge.getDestination().equals(path.get(i+1))) {	            	
	            	minWeightFromSourceToDestination = minWeightFromSourceToDestination + edge.getWeight();
	            }
	        }
			
		}
		return minWeightFromSourceToDestination;
	}
}
