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
	private boolean visited[];
	private LinkedList<Node> ld[];
	private int vertices;
	private int bipartite[];
	boolean bipatiteStatus;
	
	public Graph(int vertices)
	{
		this.vertices = vertices;
		ld = new LinkedList[vertices];
		visited = new boolean[vertices];
		bipartite = new int[vertices];
		
		for(int i=0;i<vertices;i++)
		{
			ld[i] = new LinkedList<Node>();
		}
	}
	
	public void buildGraph(BufferedReader br)throws IOException
	{
		while(true)
		{
			System.out.println("Input an edge or type quit to exit");
			String str = br.readLine();
			if(str.equalsIgnoreCase("quit"))
				break;
			else
			{
				int a = Integer.parseInt(str);
				int b = Integer.parseInt(br.readLine());
				
				addEdge(a,b);
			}
		}
	}
	
	public void addEdge(int a,int b)
	{
		ld[a].add(new Node(b));
		ld[b].add(new Node(a));
	}
	
	public void bfs(int source)
	{
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		visited[source] = true;
		System.out.println(source);
		
		while(!q.isEmpty()){
			int temp = q.remove();
			
			Iterator<Node> itr = ld[temp].iterator();
				
			while(itr.hasNext())
			{
				Node n = itr.next();
					
				if(visited[n.data] != true)
				{
					System.out.println(n.data);
					q.add(n.data);
				}
				
				visited[n.data] = true;
			}
		}
		
	}
	
	public void bipartite(int source)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		visited[source] = true;
		//System.out.println(source);
		bipartite[source] = 1;
		
		while(!q.isEmpty()){
			int temp = q.remove();
			//int val1 = bipartite[temp];
			
			Iterator<Node> itr = ld[temp].iterator();
				
			while(itr.hasNext())
			{
				Node n = itr.next();
					
				bipatiteStatus = checkBipartite(temp, n.data);

				if(bipatiteStatus == false)
					return;
				
				if(visited[n.data] != true)
				{
					
					//System.out.println(n.data);
					q.add(n.data);
					visited[n.data] = true;
					
				}
				
				
			}
		}
		
	}
	
	public boolean checkBipartite(int a,int b)
	{
		if(bipartite[b] == 0)
		{
			if(bipartite[a] == 1)
				bipartite[b] = 2;
			else
				bipartite[b] = 1;
		}
		else
		{
			if((bipartite[b]==1 && bipartite[a] == 2) || (bipartite[b]==2 && bipartite[a]==1))
				return true;
			else
				return false;
		}
		return true;
	}
	
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the maximum number of vertices");
		int v = Integer.parseInt(br.readLine());
		
		Graph obj = new Graph(v);
		
		System.out.println("Build Graph");
		obj.buildGraph(br);
		
		System.out.println("Input the source node");
		int s = Integer.parseInt(br.readLine());
		
		//obj.bfs(s);
		
		obj.bipartite(s);
		
		if(obj.bipatiteStatus == true)
			System.out.println("The graph is bipartite");
		else
			System.out.println("The graph is not bipartite");
	}
	
}
