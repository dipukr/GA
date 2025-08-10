package main;

import java.util.LinkedList;

public class Search {

	public void DFS(Node node) {
		visit(node);
		for (Node adjacentNode: node.adjacentNodes)
			if (!adjacentNode.marked)
				DFS(adjacentNode);
	}

	public void BFS(Node startNode) {
		var queue = new LinkedList<Node>();
		queue.offer(startNode);
		visit(startNode);
		while (!queue.isEmpty()) {
			Node currNode = queue.poll();
			for (Node adjacentNode: currNode.adjacentNodes) {
				if (!adjacentNode.marked) {
					visit(currNode);
					queue.offer(currNode);
				}
			}	
		}
	}

	public void visit(Node node) {
		node.marked = true;
		System.out.printf("%s ", node.data);
	}
}