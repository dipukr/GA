package main;

import java.util.List;
import java.util.ArrayList;

public class Node {
	
	public Object data;
	public boolean marked;
	public List<Node> adjacentNodes;

	public Node(Object data) {
		this.data = data;
		this.marked = false;
		this.adjacentNodes = new ArrayList<>();
	}
	
	public static Node of(Object data) {
		return new Node(data);
	}
}