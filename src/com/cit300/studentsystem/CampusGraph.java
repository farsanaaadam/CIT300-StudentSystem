package com.cit300.studentsystem;

import java.util.*;

public class CampusGraph {

    // Adjacency list - location name -> list of connected locations
    private Map<String, List<String>> adjList;

    public CampusGraph() {
        adjList = new HashMap<>();
    }

    // 1. ADD LOCATION (vertex)
    public boolean addLocation(String location) {
        if (adjList.containsKey(location)) {
            System.out.println("Error: Location already exists!");
            return false;
        }
        adjList.put(location, new ArrayList<>());
        System.out.println("Location added: " + location);
        return true;
    }

    // 2. REMOVE LOCATION
    public boolean removeLocation(String location) {
        if (!adjList.containsKey(location)) {
            System.out.println("Error: Location not found!");
            return false;
        }
        // Idhu location ah point pannura ella connections um remove pannanum
        adjList.remove(location);
        for (List<String> neighbours : adjList.values()) {
            neighbours.remove(location);
        }
        System.out.println("Location removed: " + location);
        return true;
    }

    // 3. ADD CONNECTION/ROAD (edge) - undirected graph
    public boolean addConnection(String loc1, String loc2) {
        if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) {
            System.out.println("Error: One or both locations don't exist!");
            return false;
        }
        if (adjList.get(loc1).contains(loc2)) {
            System.out.println("Error: Connection already exists!");
            return false;
        }
        adjList.get(loc1).add(loc2);
        adjList.get(loc2).add(loc1); // undirected - rendu side um add pannanum
        System.out.println("Connection added: " + loc1 + " <-> " + loc2);
        return true;
    }

    // 4. REMOVE CONNECTION/ROAD
    public boolean removeConnection(String loc1, String loc2) {
        if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) {
            System.out.println("Error: One or both locations don't exist!");
            return false;
        }
        adjList.get(loc1).remove(loc2);
        adjList.get(loc2).remove(loc1);
        System.out.println("Connection removed: " + loc1 + " <-> " + loc2);
        return true;
    }

    // 5. DISPLAY ALL CONNECTIONS (campus network)
    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No locations in the campus network.");
            return;
        }
        System.out.println("---- Campus Network ----");
        for (String location : adjList.keySet()) {
            System.out.println(location + " -> " + adjList.get(location));
        }
    }

    // 6. BFS Traversal - Breadth First Search
    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Error: Starting location not found!");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current);

            for (String neighbour : adjList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println("BFS Traversal from " + start + ": " + result);
    }

    // 7. DFS Traversal - Depth First Search
    public void dfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Error: Starting location not found!");
            return;
        }

        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        dfsHelper(start, visited, result);

        System.out.println("DFS Traversal from " + start + ": " + result);
    }

    private void dfsHelper(String current, Set<String> visited, List<String> result) {
        visited.add(current);
        result.add(current);

        for (String neighbour : adjList.get(current)) {
            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, visited, result);
            }
        }
    }

    // 8. Display neighbours of a specific location
    public void displayNeighbours(String location) {
        if (!adjList.containsKey(location)) {
            System.out.println("Error: Location not found!");
            return;
        }
        System.out.println(location + " is connected to: " + adjList.get(location));
    }
}
