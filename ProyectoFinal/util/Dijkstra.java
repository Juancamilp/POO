package util;

import java.util.*;

public class Dijkstra {
    public static int[] calcularRuta(int[][] grafo, int origen) {
        int n = grafo.length;
        int[] dist = new int[n];
        boolean[] visitado = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[origen] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visitado[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            visitado[u] = true;
            for (int v = 0; v < n; v++) {
                if (grafo[u][v] != 0 && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                }
            }
        }
        return dist;
    }
}
