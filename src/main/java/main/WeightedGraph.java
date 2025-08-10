package main;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {

	private List<Node> nodes = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public void addEdge(Node from, Node to, double cost) {
		addEdge(new Edge(from, to, cost));
	}
}
