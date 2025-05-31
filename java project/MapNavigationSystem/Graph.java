import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addPlace(String name) {
        adjList.putIfAbsent(name, new ArrayList<>());
        System.out.println("Place added: " + name);
    }

    public void addRoad(String source, String dest, int distance) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(source).add(new Edge(dest, distance));
        adjList.get(dest).add(new Edge(source, distance)); // Undirected Graph
        System.out.println("Road added between " + source + " and " + dest + " with distance " + distance);
    }

    public void displayMap() {
        System.out.println("\nMap View (Adjacency List):");
        for (String place : adjList.keySet()) {
            System.out.print(place + " -> ");
            for (Edge e : adjList.get(place)) {
                System.out.print(e.destination + "(" + e.distance + " km), ");
            }
            System.out.println();
        }
    }

    public void findShortestPath(String start, String end) {
        if (!adjList.containsKey(start) || !adjList.containsKey(end)) {
            System.out.println("One or both places not found.");
            return;
        }

        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));

        for (String place : adjList.keySet()) {
            distances.put(place, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            for (Edge neighbor : adjList.get(current.destination)) {
                int newDist = distances.get(current.destination) + neighbor.distance;
                if (newDist < distances.get(neighbor.destination)) {
                    distances.put(neighbor.destination, newDist);
                    prev.put(neighbor.destination, current.destination);
                    pq.add(new Edge(neighbor.destination, newDist));
                }
            }
        }

        if (distances.get(end) == Integer.MAX_VALUE) {
            System.out.println("No path exists between " + start + " and " + end);
            return;
        }

        // Display path
        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println("Shortest Path: " + String.join(" -> ", path));
        System.out.println("Total Distance: " + distances.get(end) + " km");
    }
}
