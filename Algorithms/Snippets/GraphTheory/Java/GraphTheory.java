import java.util.*;

class GraphTheory {
  AdjacencyList listGraph;
  AdjacencyMatrix matrixGraph;
  int[] visited;
  int size;

  public GraphTheory(int size, boolean directed) {
    this.listGraph = new AdjacencyList(5, true);
    this.matrixGraph = new AdjacencyMatrix(5, true);
    this.visited = new int[size];
    this.size = size;
  }

  public GraphTheory(int size, boolean directed, int[][] matrix) {
    this.listGraph = new AdjacencyList(5, true, matrix);
    this.matrixGraph = new AdjacencyMatrix(5, true, matrix);
    this.visited = new int[size];
    this.size = size;
  }

  // Start: Helper Methods
  private void resetVisited() {
    visited = new int[this.size];
  }
  // End: Helper Methods

  // Start: AdjacencyList Methods
  // Start: BFS
  // BFS Traversal
  private void adjListBFS(int v) {
    resetVisited();
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(v);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (visited[node] == 0) {
        visited[node] = 1;
        LinkedList<Integer> neighbors = listGraph.getNeighbors(node);
        if (neighbors != null) {
          ListIterator<Integer> neighborIterator = neighbors.listIterator();
          while (neighborIterator.hasNext()) {
            int neighbor = neighborIterator.next();
            if (visited[neighbor] == 0)
              queue.add(neighbor);
          }
        }
      }
    }
  }

  // BFS Search
  private boolean adjListBFS(int v, int query) {
    resetVisited();
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(v);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (node == query) return true;
      if (visited[node] == 0) {
        visited[node] = 1;
        LinkedList<Integer> neighbors = listGraph.getNeighbors(node);
        if (neighbors != null) {
          ListIterator<Integer> neighborIterator = neighbors.listIterator();
          while (neighborIterator.hasNext()) {
            int neighbor = neighborIterator.next();
            if (visited[neighbor] == 0)
              queue.add(neighbor);
          }
        }
      }
    }
    return false;
  }
  // End: BFS

  // Start: DFS
  // DFS Traversal
  private void adjListIterativeDFS(int v) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(v);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (visited[node] == 0) {
        visited[node] = 1;
        LinkedList<Integer> neighbors = listGraph.getNeighbors(node);
        if (neighbors != null) {
          ListIterator<Integer> neighborIterator = neighbors.listIterator();
          while (neighborIterator.hasNext()) {
            int neighbor = neighborIterator.next();
            if (visited[neighbor] == 0)
              stack.push(neighbor);
          }
        }
      }
    }
  }

  // DFS Search
  private boolean adjListIterativeDFS(int v, int query) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(v);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (visited[node] == 0) {
        visited[node] = 1;
        if (node == query) return true;
        LinkedList<Integer> neighbors = listGraph.getNeighbors(node);
        if (neighbors != null) {
          ListIterator<Integer> neighborIterator = neighbors.listIterator();
          while (neighborIterator.hasNext()) {
            int neighbor = neighborIterator.next();
            if (visited[neighbor] == 0)
              stack.push(neighbor);
          }
        }
      }
    }
    return false;
  }

  // DFS Traversal
  private boolean adjListRecursiveDFS(int v) {
    visited[v] = 1;
    LinkedList<Integer> neighbors = listGraph.getNeighbors(v);
    if (neighbors != null) {
      ListIterator<Integer> neighborIterator = neighbors.listIterator();
      while (neighborIterator.hasNext()) {
        int neighbor = neighborIterator.next();
        if (visited[neighbor] == 0)
          adjListRecursiveDFS(neighbor);
      }
    }
    return false;
  }

  // DFS Search
  private boolean adjListRecursiveDFS(int v, int query) {
    visited[v] = 1;
    if (v == query) return true;
    LinkedList<Integer> neighbors = listGraph.getNeighbors(v);
    if (neighbors != null) {
      ListIterator<Integer> neighborIterator = neighbors.listIterator();
      while (neighborIterator.hasNext()) {
        int neighbor = neighborIterator.next();
        if (visited[neighbor] == 0)
          adjListRecursiveDFS(neighbor, query);
      }
    }
    return false;
  }
  // End: DFS

  // Start: Connected Components
  private int adjListNumConnectedComponents() {
    resetVisited();
    int cc = 0;
    for (int i = 0; i < size; i++) {
      if (visited[i] == 0) {
        adjListIterativeDFS(i);
        cc++;
      }
    }
    return cc;
  }
  // End: Connected Components
  // End: AdjacencyList Methods

  // Start: AdjacencyMatrix Methods
  // Start: BFS
  // BFS Traversal
  private void adjMatrixBFS(int v) {
    resetVisited();
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(v);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (visited[node] == 0) {
        visited[node] = 1;
        int[] neighbors = matrixGraph.getNeighbors(node);
        for (int neighbor = 0; neighbor < neighbors.length; neighbor++) {
          if (neighbors[neighbor] == 1 && visited[neighbor] == 0)
            queue.push(neighbor);
        }
      }
    }
  }

  // BFS Search
  private boolean adjMatrixBFS(int v, int query) {
    resetVisited();
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(v);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (visited[node] == 0) {
        visited[node] = 1;
        if (node == query) return true;
        int[] neighbors = matrixGraph.getNeighbors(node);
        for (int neighbor = 0; neighbor < neighbors.length; neighbor++) {
          if (neighbors[neighbor] == 1 && visited[neighbor] == 0)
            queue.push(neighbor);
        }
      }
    }
    return false;
  }
  // End: BFS
  // Start: DFS
  // DFS Traversal
  private void adjMatrixIterativeDFS(int v) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(v);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (visited[node] == 0) {
        visited[node] = 1;
        int[] neighbors = matrixGraph.getNeighbors(node);
        for (int neighbor = 0; neighbor < neighbors.length; neighbor++) {
          if (neighbors[neighbor] == 1 && visited[neighbor] == 0) {
              stack.push(neighbor);
          }
        }
      }
    }
  }

  // DFS Search
  private boolean adjMatrixIterativeDFS(int v, int query) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(v);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (visited[node] == 0) {
        visited[node] = 1;
        if (node == query) return true;
        int[] neighbors = matrixGraph.getNeighbors(node);
        for (int neighbor = 0; neighbor < neighbors.length; neighbor++) {
          if (neighbors[neighbor] == 1 && visited[neighbor] == 0)
            stack.push(neighbor);
        }
      }
    }
    return false;
  }

  // DFS Traversal
  private boolean adjMatrixRecursiveDFS(int v) {
    visited[v] = 1;
    int[] neighbors = matrixGraph.getNeighbors(v);
    for (int neighbor = 0; neighbor < neighbors.length; neighbor++) {
      if (neighbors[neighbor] == 1 && visited[neighbor] == 0)
        adjMatrixRecursiveDFS(neighbor);
    }
    return false;
  }

  // DFS Search
  private boolean adjMatrixRecursiveDFS(int v, int query) {
    visited[v] = 1;
    if (v == query) return true;
    int[] neighbors = matrixGraph.getNeighbors(v);
    for (int neighbor = 0; neighbor < neighbors.length; neighbor++) {
      if (neighbors[neighbor] == 1 && visited[neighbor] == 0)
        adjMatrixRecursiveDFS(neighbor, query);
    }
    return false;
  }
  // End: DFS

  // Start: Connected Components
  private int adjMatrixNumConnectedComponents() {
    resetVisited();
    int cc = 0;
    for (int i = 0; i < size; i++) {
      if (visited[i] == 0) {
        adjMatrixIterativeDFS(i);
        cc++;
      }
    }
    return cc;
  }
  // End: Connected Components
  // End: AdjacencyMatrix Methods

  public static void main(String[] args) {
    int[][] matrix1 = {{0,0,0,1,1},
                      {0,1,1,0,0},
                      {1,0,0,0,1},
                      {0,1,1,0,1},
                      {0,0,0,0,0}};

    int[][] matrix2 = {{0,1,0,0,0},
                      {0,0,0,0,1},
                      {0,0,0,0,0},
                      {0,0,0,0,0},
                      {1,0,0,0,0}};

    GraphTheory gT1d = new GraphTheory(5, true, matrix1);
    GraphTheory gT2d = new GraphTheory(5, true, matrix2);
    GraphTheory gT1u = new GraphTheory(5, false, matrix1);
    GraphTheory gT2u = new GraphTheory(5, false, matrix2);

    System.out.println(gT1u.adjMatrixNumConnectedComponents());
    System.out.println(gT1u.adjListNumConnectedComponents());
    System.out.println(gT1d.adjListBFS(0, 2));
    System.out.println(gT1u.adjListBFS(0, 2));
    System.out.println(gT2d.adjListBFS(0, 2));
    System.out.println(gT2u.adjListBFS(0, 2));
  }

  private class AdjacencyList {
    LinkedList<Integer>[] graph;
    boolean directed;

    public AdjacencyList(int size, boolean directed) {
      this.graph = new LinkedList[size];
      this.directed = directed;
    }

    public AdjacencyList(int size, boolean directed, int[][] matrix) {
      this.graph = new LinkedList[size];
      this.directed = directed;
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
          if (matrix[i][j] == 1) this.addEdge(i, j);
        }
      }
    }

    public void addEdge(int v1, int v2) {
      if (graph[v1] == null)
        graph[v1] = new LinkedList<Integer>();
      graph[v1].add(v2);
      if (!directed)
        graph[v2].add(v1);
    }

    public LinkedList<Integer> getNeighbors(int v) {
      return graph[v];
    }
  }

  private class AdjacencyMatrix {
    int[][] graph;
    boolean directed;

    public AdjacencyMatrix(int size, boolean directed) {
      this.graph = new int[size][size];
      this.directed = directed;
    }

    public AdjacencyMatrix(int size, boolean directed, int[][] matrix) {
      this.graph = matrix;
      this.directed = directed;
    }

    public void addEdge(int v1, int v2) {
      graph[v1][v2] = 1;
      if (!directed)
        graph[v2][v1] = 1;
    }

    public int[] getNeighbors(int v) {
      return graph[v];
    }
  }
}
