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
	static final int NIL = -1;
	int temp;
	
	
	public Graph(int V)
	{
		
		ld = new LinkedList[V];
		temp = 0;
		
		for(int i=0;i<V;i++)
		{
			ld[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int a,int b)
	{
		ld[a].add(new Node(b));
		ld[b].add(new Node(a));
	}
	
	public void articulateUtil(int V)
	{
		int disc[] = new int[V];
		int low[] = new int[V];
		boolean visited[] = new boolean[V];
		boolean result[] = new boolean[V];
		int parent[] = new int[V];
		
		for(int i=0;i<V;i++)
		{
			parent[i] = NIL;
		}
		
		for(int i=0;i<V;i++)
		{
			if(result[i] == false)
			{
				printArticulateVertices(i,disc,low,visited,result,parent);
			}
		}
		
		for(int i=0;i<V;i++)
		{
			if(result[i] == true)
				System.out.println(i);
		}
	}
	
	public int min(int a,int b)
	{
		return (a<b)?a:b;
	}
	
	public void printArticulateVertices(int u,int disc[],int low[],boolean visited[],boolean result[],int parent[])
	{
		
		int children = 0;
		visited[u] = true;
		disc[u] = low[u] = ++temp;
		Node n = null;
		LinkedList<Node> l = ld[u];
		
		Iterator<Node> itr = l.iterator();
		
		while(itr.hasNext())
		{
			n = itr.next();
			int v = n.data;
			
			if(visited[v] != true)
			{
				parent[v] = u;
				children = children + 1;
				
				printArticulateVertices(v,disc,low,visited,result,parent);
				
				low[u] = min(low[u],low[v]);
				
				if(parent[u] == NIL && children>1)
					result[u] = true;
				
				if(parent[u] != NIL && (low[v] >= disc[u]))
					result[u] = true;
			}
			else if(parent[u] != v)
			{
				low[u] = min(low[u],disc[v]);
			}
				
		}
	}
	
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the maximum number of vertices");
		int V = Integer.parseInt(br.readLine());
		
		Graph obj = new Graph(V);
		
		System.out.println("Input edge or type quit to exit");
		String str = br.readLine();
		
		while(!str.equals("quit"))
		{
			int a = Integer.parseInt(str);
			int b = Integer.parseInt(br.readLine());
			
			obj.addEdge(a,b);
			
			System.out.println("Input edge or type quit to exit");
			str = br.readLine();
		}
		
		obj.articulateUtil(V);
	}
}
