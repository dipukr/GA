package main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

	private PriorityQueue<Integer> pq = new PriorityQueue<>();
	private Weighted wg;
	private double dist[];

	public Dijkstra(Weighted wg, int start) {
		this.wg = wg;
		this.dist = new double[wg.size()];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		search(start);
	}

	public void search(int start) {
		pq.offer(start);
		dist[start] = 0;
		while (!pq.isEmpty()) {
			int u = pq.poll();
			for (int v: wg.adjacents(u)) {
				if (dist[v] > dist[u] + wg.cost(u, v)) {
					dist[v] = dist[u] + wg.cost(u, v);
					pq.offer(v);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return dist[v] != Double.POSITIVE_INFINITY;
	}

	public double distanceTo(int v) {
		return dist[v];
	}
}