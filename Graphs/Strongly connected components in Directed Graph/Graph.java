import java.io.*;
import java.util.*;

class Node{
	int data;
	
	public Node(int data)
	{
		this.data = data;
	}
}

class ReverseGraph{
	
	LinkedList<Integer> ld[];
	Stack<Integer> st;
	boolean visited[];
	int V;
	public ReverseGraph(Graph obj,int V)
	{	
		this.V = V;
		ld = new LinkedList[V];
		st = new Stack<Integer>();
		visited = new boolean[V];
		
		for(int i=0;i<V;i++)
		{
			ld[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<V;i++)
		{
			Iterator<Node> itr = obj.ld[i].iterator();
			while(itr.hasNext())
			{
				Node n = itr.next();
				int data = n.data;
				ld[data].add(i);
			}
		}
	}
	
	public Stack<Integer> dfsUtil()
	{
		for(int i=0;i<V;i++)
		{
			if(visited[i] == false)
			{
				dfs(i);
				//System.out.println(i);
				st.push(i);
			}
		}
		
		return st;
	}
	
	public void dfs(int u)
	{
		LinkedList<Integer> l = ld[u];
		visited[u] = true;
		Iterator<Integer> itr = l.iterator();
		while(itr.hasNext())
		{
			int v = itr.next();
			if(visited[v] != true)
			{
				dfs(v);
				//System.out.println(v);
				st.push(v);
			}
		}
	}
}

public class Graph{
	
	LinkedList<Node> ld[];
	int visited[];
	int temp;
	public Graph(int V)
	{
		temp = -1;
		ld = new LinkedList[V];
		visited = new int[V];
		for(int i=0;i<V;i++)
		{
			visited[i] = -1;
			ld[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int a,int b)
	{
		ld[a].add(new Node(b));
	}
	
	public void dfsUtilOriginal(Stack<Integer> st)
	{
		//Iterator<Integer> itr = st.iterator();
		while(!st.isEmpty())
		{
			int data = st.pop();
			//itr.next();
			System.out.println(data);
			if(visited[data] == -1)
			{
				temp = temp +1;
				dfsOriginal(data);
			}
		}
	}
	
	public void dfsOriginal(int u)
	{
		LinkedList<Node> l = ld[u];
		visited[u] = temp;
		Iterator<Node> itr = l.iterator();
		while(itr.hasNext())
		{
			int v = itr.next().data;
			if(visited[v] == -1)
			{
				visited[v] = temp;
				dfsOriginal(v);
			}
		}
	}
	
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the maximum number of vertices");
		
		int V = Integer.parseInt(br.readLine());
		
		Graph obj = new Graph(V);
		
		System.out.println("Input an edge or type quit to exit");
		
		String str = br.readLine();
		
		while(!str.equals("quit"))
		{
			int a = Integer.parseInt(str);
			int b = Integer.parseInt(br.readLine());
			
			obj.addEdge(a,b);
			
			System.out.println("Input an edge or type quit to exit");
		
			str = br.readLine();
		}
		
		ReverseGraph rg = new ReverseGraph(obj,V);
		rg.dfsUtil();
		
		obj.dfsUtilOriginal(rg.st);
		
		for(int i=0;i<V;i++)
		{
			System.out.println(i + " : " + obj.visited[i]);
		}
	}
}
