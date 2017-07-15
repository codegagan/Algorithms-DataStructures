import java.io.*;
import java.util.*;

class Node{
	int data;
	
	public Node(int data)
	{
		this.data = data;
	}
}

public class Graph{
	
	LinkedList<Node> ld[];
	
	public Graph(int V)
	{
		ld = new LinkedList[V];
		
		for(int i=0;i<V;i++)
		{
			ld[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int a,int b)
	{
		ld[a].add(new Node(b));
	}
	
	public void topologicalUtil(int V)
	{
		boolean visited[] = new boolean[V];
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i=0;i<V;i++)
		{
			if(visited[i] != true)
			{
				topologicalOrder(i,visited,st);
			}
		}
		
		while(!st.empty())
		{
			System.out.println(st.pop());
		}
	}
	
	public void topologicalOrder(int u,boolean visited[],Stack<Integer> st)
	{
		visited[u] = true;
		
		LinkedList<Node> l = ld[u];
		
		Iterator<Node> itr = l.iterator();
		
		while(itr.hasNext())
		{
			Node n = itr.next();
			int v = n.data;
			
			if(visited[v] != true)
			{
				topologicalOrder(v,visited,st);
			}
		}
		st.push(u);
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
		
		obj.topologicalUtil(V);
	}
}
