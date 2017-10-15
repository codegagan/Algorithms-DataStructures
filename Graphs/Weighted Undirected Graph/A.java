import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	private final int v,w;
	private final int weight;
	
	public Edge(int v,int w,int weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either()
	{
		return v;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public int other(int v)
	{
		if(v == this.v)
			return w;
		else
			return this.v;
	}
	
	public int compareTo(Edge e)
	{
		return new Integer(getWeight()).compareTo(new Integer(e.getWeight()));
	}
}

class EdgeWeightedGraph{
	
	LinkedList<Edge> ld[];
	int V;
	
	public EdgeWeightedGraph(int V)
	{
		this.V = V;
		ld = new LinkedList[this.V];
		for(int i=0;i<this.V;i++)
		{
			ld[i] = new LinkedList<Edge>();
		}
	}
	
	public void addEdge(Edge e)
	{
		int v = e.either();
		int w = e.other(v);
		ld[v].add(e);
		ld[w].add(e);
	}
	
	Iterator<Edge> adj(int v)
	{
		LinkedList<Edge> l = ld[v];
		return l.iterator();
	}
}

public class A{
	
	public static void main(String args[])throws Exception
	{
	BufferedReader br = new BufferedReader(new FileReader("a.txt"));
	
	//System.out.println("Input the maximum number of vertices");
	int V = Integer.parseInt(br.readLine());
	
	EdgeWeightedGraph obj = new EdgeWeightedGraph(V);
	String s = br.readLine();
	while(s != null)
	{
		//String arr[] = new String[3];
		String arr[] = s.split(" ");
		obj.addEdge(new Edge(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2])));
		s = br.readLine();
	}
	
	for(int i=0;i<V;i++)
	{
		Iterator<Edge> itr = obj.adj(i);
		while(itr.hasNext())
		{
			Edge ed = itr.next();
			System.out.println(ed.getWeight() + " " + ed.other(ed.either()) + " " + ed.either());
		}
	}
	}
}

