package main;

import java.util.Map;
import java.util.Stack;
import common.Anim;

public class Main {
	public static void main(String[] args) throws Exception {
		byte[][] data = {{1,6,7},{8,4,0},{5,2,3}};
		State start = new State(data);
		State goal = new State(State.goal);
		Problem problem = new Puzzle(start, goal);
		Map<String, State> prev = Solvers.aStar(problem);
		Stack<State> states = new Stack<>();
		states.add(problem.getGoalState());
		while (!states.peek().equals(start))
			states.add(prev.get(states.peek().toString()));
		System.out.printf("Path size: %d\n", states.size());
		byte[][][] frames = new byte[states.size()][][];
		int count = 0;
		while (!states.isEmpty())
			frames[count++] = states.pop().data;
		Anim.anim(frames);

//		Graph graph = new Graph();
//		Node a = Node.of("A");
//		Node b = Node.of("B");
//		Node c = Node.of("C");
//		Node d = Node.of("D");
//		Node e = Node.of("E");
//		Node f = Node.of("F");
//		graph.addNode(a);
//		graph.addNode(b);
//		graph.addNode(c);
//		graph.addNode(d);
//		graph.addNode(e);
//		graph.addNode(f);
//		graph.addEdge(a, b);
//		graph.addEdge(a, c);
//		graph.addEdge(b, c);
//		graph.addEdge(b, d);
//		graph.addEdge(c, d);
//		graph.addEdge(c, e);
//		graph.addEdge(d, e);
//		graph.addEdge(d, f);
//		graph.addEdge(e, f);
//		Search search = new Search();
//		search.BFS(e);
//		PathFinder finder = new PathFinder(c);
//		if (finder.hasPathTo(f))
//			System.out.println(finder.distanceTo(f));
//		for (var elem : finder.pathTo(f))
//			System.out.print(elem + " ");
	}
}