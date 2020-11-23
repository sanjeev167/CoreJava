/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sanjeev
 *
 */
public class TestDijkstraAlgorithm {
	
	private static List<Vertex> graphNodeList;	
    private static List<Edge> edgeList;

    public static void main(String args[]) {
    	graphNodeList= new ArrayList<Vertex>(); 
    	
    	//Add nodes in a graph 
    	graphNodeList.add(new Vertex("Patna","PatnaCityId"));
    	graphNodeList.add(new Vertex("Mumbai","MumbaiCityId"));
    	graphNodeList.add(new Vertex("Kolkatta","KolkattaCityId"));
    	graphNodeList.add(new Vertex("Delhi","DelhiCityId"));
    	graphNodeList.add(new Vertex("Chennai","ChennaiCityId"));  
    	
    	
    	edgeList= new ArrayList<Edge>(); 
    	//Define routes from Patna to the rest cities
    	edgeList.add(new Edge("edgeId_Patna_Mumbai", new Vertex("Patna","PatnaCityId"), new Vertex("Mumbai","MumbaiCityId"), 1462));
    	edgeList.add(new Edge("edgeId_Patna_Kolkatta", new Vertex("Patna","PatnaCityId"), new Vertex("Kolkatta","KolkattaCityId"), 576));
    	edgeList.add(new Edge("edgeId_Patna_Delhi", new Vertex("Patna","PatnaCityId"), new Vertex("Delhi","DelhiCityId"), 1003));
    	edgeList.add(new Edge("edgeId_Patna_Chennai", new Vertex("Patna","PatnaCityId"), new Vertex("Chennai","ChennaiCityId"), 1921));
    	
    	//Define routes from Mumbai to the rest cities
    	edgeList.add(new Edge("edgeId_Mumbai_Patna", new Vertex("Mumbai","MumbaiCityId"), new Vertex("Patna","PatnaCityId"), 1462));
    	edgeList.add(new Edge("edgeId_Mumbai_Kolkatta", new Vertex("Mumbai","MumbaiCityId"), new Vertex("Kolkatta","KolkattaCityId"), 1969));
    	edgeList.add(new Edge("edgeId_Mumbai_Delhi", new Vertex("Mumbai","MumbaiCityId"), new Vertex("Delhi","DelhiCityId"), 1166));
    	edgeList.add(new Edge("edgeId_Mumbai_Chennai", new Vertex("Mumbai","MumbaiCityId"), new Vertex("Chennai","ChennaiCityId"), 1323));
    	
    	//Define routes from Kolkatta to the rest cities
    	edgeList.add(new Edge("edgeId_Kolkatta_Patna", new Vertex("Kolkatta","KolkattaCityId"), new Vertex("Patna","PatnaCityId"), 576));
    	edgeList.add(new Edge("edgeId_Kolkatta_Mumbai", new Vertex("Kolkatta","KolkattaCityId"), new Vertex("Mumbai","MumbaiCityId"), 1969));
    	edgeList.add(new Edge("edgeId_Kolkatta_Delhi", new Vertex("Kolkatta","KolkattaCityId"), new Vertex("Delhi","DelhiCityId"), 1439));
    	edgeList.add(new Edge("edgeId_Kolkatta_Chennai", new Vertex("Kolkatta","KolkattaCityId"), new Vertex("Chennai","ChennaiCityId"), 1707));
    	
    	
    	//Define routes from Delhi to the rest cities
    	edgeList.add(new Edge("edgeId_Delhi_Patna", new Vertex("Delhi","DelhiCityId"), new Vertex("Patna","PatnaCityId"), 1003));
    	edgeList.add(new Edge("edgeId_Delhi_Mumbai", new Vertex("Delhi","DelhiCityId"), new Vertex("Mumbai","MumbaiCityId"), 1166));
    	edgeList.add(new Edge("edgeId_Delhi_Kolkatta", new Vertex("Delhi","DelhiCityId"), new Vertex("Kolkatta","KolkattaCityId"), 1439));
    	edgeList.add(new Edge("edgeId_Delhi_Chennai", new Vertex("Delhi","DelhiCityId"), new Vertex("Chennai","ChennaiCityId"), 2246));
    	
    	//Define routes from Chenai to the rest cities
    	edgeList.add(new Edge("edgeId_Chennai_Patna", new Vertex("Chennai","ChennaiCityId"), new Vertex("Patna","PatnaCityId"), 1921));
    	edgeList.add(new Edge("edgeId_Chennai_Mumbai", new Vertex("Chennai","ChennaiCityId"), new Vertex("Mumbai","MumbaiCityId"), 1323));
    	edgeList.add(new Edge("edgeId_Chennai_Delhi", new Vertex("Chennai","ChennaiCityId"), new Vertex("Delhi","DelhiCityId"), 2246));
    	edgeList.add(new Edge("edgeId_Chennai_Kolkatta", new Vertex("Chennai","ChennaiCityId"), new Vertex("Chennai","KolkattaCityId"), 1707));
    	
    	//Prepare graph 
        Graph1 graph1 = new Graph1(graphNodeList, edgeList);
        //Create a DijkstraAlgorithm object using a graph object.
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph1);
        
        LinkedList<Vertex> path;
        int minWeightFromSourceToDestination;        
        for(int i=0;i<graphNodeList.size();i++) {
        	System.out.println("\n###### Shortest Path from [ Origin -- "+graphNodeList.get(i)+" ]  ######\n");
        	  dijkstra.execute(graphNodeList.get(i)); //Source  
        	  for(int j=0;j<graphNodeList.size();j++) { 
        		if(!graphNodeList.get(i).equals(graphNodeList.get(j))) {			        			
        	         path = dijkstra.getPath(graphNodeList.get(j));//For all five cities 
        	         minWeightFromSourceToDestination=dijkstra.getShortestPathWeightFromSourceToDestination(path);
        	         System.out.println("\t to [ Destination -- "+graphNodeList.get(j)
        	                           +" ] ==> \n\t\t\t\t\tRoute-Order ="+path 
        	                           +" \n\t\t\t\t\tTotal weight = "+minWeightFromSourceToDestination);        	    
        	           }
        		}
        }    
    	
    }
  }