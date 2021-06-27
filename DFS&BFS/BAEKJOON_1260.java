import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class BAEKJOON_1260 {
	public static void main(String[] args) throws FileNotFoundException  {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		Graph g = new Graph();
		for (int i = 1; i <= N; i++) {
			char j = (char) i;
			Node tree = new Node(j);
			if (i == V) {
				g.setRootNode(tree);
			}
			g.addNode(tree);
		}


		for (int i = 1; i <= M; i++) {

			int start = sc.nextInt();
			int end = sc.nextInt();
			if (start <= end) {

				g.connectNode(start, end);

			} else if (start > end) {

				g.connectNode(end, start);

			}

		}

		System.out.println("DFS Traversal of a tree is ------------->");
		g.dfs();

		System.out.println("\nBFS Traversal of a tree is ------------->");
		g.bfs();

	}
}

class Node {

	public int label;

	public boolean visited = false;

	public Node(int label) {
		this.label = label;
	}
}

class Graph {

	// Node클래스 타입의 변수. 최상위 기점을 표현하기 위함
	public Node rootNode;
	// Node클래스 타입의 ArrayList. 기점들의 노드를 List로 저장하기 위함
	public ArrayList nodes = new ArrayList();
	// 기점들을 노드를 Matrix로 저장하기 위함
	public int[][] adjMatrix;// Edges will be represented as adjacency Matrix
	// 노드의 총길이가 들어오는 변수
	int size;

	// 최상위 기점을 객체데이터로 저장하기 위한 메소드
	public void setRootNode(Node n) {
		this.rootNode = n;
	}

	// 객체데이터로 저장된 최상위 기점을 가져오기 위한 메소드
	public Node getRootNode() {
		return this.rootNode;
	}

	// Node타입의 데이터를 ArrayList에 값을 추가하기 위한 메소드
	public void addNode(Node n) {
		nodes.add(n);

	}

	// This method will be called to make connect two nodes
	// Matrix이중배열의 크기가 지정되어 있지 않다면 지정해주고, 지정되어 있다면 파라미터 값에 해당하는 행과 열에 1을 맵핑한다.
	// Node클래스 타입의 시작점과 끝점이 들어온다.
	// Matrix이중배열이 널값이면, ArrayList의 길이를 size변수에 저장한다.
	// Matrix이중배열의 길이를 size의 크기만큼 생성한다.
	// ArrayList의 시작점과 끝점을 int형의 새로운 변수로 지정해준다.
	// Matrix이중배열의 시작 행의 끝 열과 끝 행의 시작 열을 각각 1로 맵핑한다.
	public void connectNode(int start, int end) {
		if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}
		int startIndex = start - 1;
		int endIndex = end - 1;
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;

//		for (int i = 0; i < adjMatrix.length; i++) {
//			System.out.println(Arrays.toString(adjMatrix[i]));
//		}
//		System.out.println();

	}

	// 자식노드를 찾아주는 메소드
	// Node타입의 변수가 파라미터로 들어온다.
	// 파라미터의 값에 해당하는 ArrayList의 index를 변수로 지정해준다.
	// size가 j보다 컸을때 while문을 들어온다.
	// Matrix이중배열의 파라미터값 행의 첫번째 열이 1이면서 해당 노드에 방문하지 않았다면, 해당 노드를 반환한다. 그 이후 j를 +1해준다
	// while문에 들어오지 않으면 널값을 반환한다.
	private Node getUnvisitedChildNode(Node n) {

		int index = nodes.indexOf(n);
		int j = 0;
		while (j < size) {
			if (adjMatrix[index][j] == 1 && ((Node) nodes.get(j)).visited == false) {
				return (Node) nodes.get(j);
			}
			j++;
		}
		return null;
	}

	// BFS traversal of a tree is performed by the bfs() function
	// Queue를 활용한다.(선입선출)
	// Stack에 최상위 기점을 추가한다.
	// 최상위 기점을 출력한다.
	// 최상위 기점을 true로 맵핑한다.
	// 해당 Queue가 비어 있지 않다면, 선입선출에 따른 노드를 삭제한다.
	// Node클래스 타입의 child변수를 null값으로 맵핑한다.
	// 삭제된 노드의 자식노드를 child변수에 맵핑하고, 그 값이 null값이 아니라면 while문을 들어온다.(==자식노드가 있다면)
	// 방문한 자식 노드를 true로 맵핑하고, 해당 자식노드를 출력한다.
	// 자식노드를 Queue에 추가한다.
	// 자식노드를 모두 출력한 뒤, 반복문을 탈출한다.
	public void bfs() {
		// BFS uses Queue data structure
		Queue q = new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			Node child = null;
			while ((child = getUnvisitedChildNode(n)) != null) {
				child.visited = true;
				printNode(child);
				q.add(child);
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	// DFS traversal of a tree is performed by the dfs() function
	// Stack을 활용한다.(후입선출)
	// Stack에 최상위 기점을 추가한다.
	// 최상위 기점을 true로 맵핑한다.
	// 최상위 기점을 출력한다.
	// 해당 Stack이 비어 있지 않다면, while문을 들어온다.
	// 가장 최근의 노드를 찾아서 가져오고, 해당 노드에 자식노가 있는지를 확인하는 메소드를 사용한다.
	// 자식 노드가 있다면, 해당 노드 방문을 true로 맵핑하고 출력한다.
	// 자식노드를 Stack에 추가한다.
	// 자식노드가 없다면 해당 노드를 삭제한다.
	// 결론 : 자식노드가 있는 노드는 먼저 삭제되지 않고, 자식노드가 없는 노드가 먼저 삭제 된다.(Stack의 특성)
	public void dfs() {
		// DFS uses Stack data structure
		Stack s = new Stack();
		s.push(this.rootNode);
		rootNode.visited = true;
		printNode(rootNode);
		while (!s.isEmpty()) {
			Node n = (Node) s.peek();
			Node child = getUnvisitedChildNode(n);
			if (child != null) {
				child.visited = true;
				printNode(child);
				s.push(child);
			} else {
				s.pop();
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	// Utility methods for clearing visited property of node
	// 노드의 방문을 전부 false로 맵핑해주는 메소드
	// while문을 size만큼 돌면서 방문을 false로 바꿔준다.
	private void clearNodes() {
		int i = 0;
		while (i < size) {
			Node n = (Node) nodes.get(i);
			n.visited = false;
			i++;
		}
	}

	// Utility methods for printing the node's label
	// Node타입의 변수를 파라미터로 받아와서, 해당 파라미터의 label을 출력하는 메소드
	private void printNode(Node n) {
		System.out.print(n.label + " ");
	}

}
