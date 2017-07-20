/*
Program does not handle connected components scenario.
*/

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
	int flag;
	public Graph(int V)
	{
		ld = new LinkedList[V];
		flag=0;
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
	
	public void cycleUtil(int V)throws IOException
	{
		boolean visited[] = new boolean[V];
		int parent[] = new int[V];
		LinkedList<Integer> result = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the source vertex");
		int s = Integer.parseInt(br.readLine());
		printCycle(s,visited,parent,result);
		
		Iterator<Integer> itr = result.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
	
	public void printCycle(int u,boolean visited[],int parent[],LinkedList<Integer> result)
	{
		visited[u] = true;
		LinkedList<Node> l = ld[u];

		Iterator<Node> itr = l.iterator();
		//System.out.println(u);
		while(itr.hasNext() && flag==0)
		{
			Node n = itr.next();
			int v = n.data;
			
			if(visited[v] != true)
			{	
				//System.out.println(v);
				parent[v] = u;
				printCycle(v,visited,parent,result);
				
				if(flag == 1)
					result.add(v);
			}
			else if(parent[u] != v)
			{
				flag=1;
				result.add(v);
			}
		}
		
	}
	
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the total number of vertices present in the graph");
		
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
		
		obj.cycleUtil(V);
	}
}

