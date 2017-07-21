import java.io.*;
import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data = data;
	}
}

class A{
	
	
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input Maximum number of Nodes");
		int size = Integer.parseInt(br.readLine());
		
		LinkedList<Node> link[] = new LinkedList[size];
		System.out.println("Input edges or type quit to exit");
		
		while(true)
		{
			String str = br.readLine();
			
			if(str.equalsIgnoreCase("quit"))
				break;
			else
			{
				int a = Integer.parseInt(str);
				int b = Integer.parseInt(br.readLine());
				
				if(link[a] == null)
				{
					link[a] = new LinkedList<Node>();
					link[a].add(new Node(b));
				}
				
				else
				{
					link[a].add(new Node(b));
				}
			}
		}
		
		A obj = new A();
		int[] visited = new int[size];
		System.out.println("Input the starting node");
		int temp = Integer.parseInt(br.readLine());
		obj.remove_cycles(link, temp, visited);
		
		/*for(int i=0;i<size;i++)
		{
			System.out.println();
			System.out.print("Edges of node " + i + ": ");
			LinkedList<Node> l = link[i];
			while(!l.isEmpty())
			{
				System.out.print(l.poll().data + " ");
			}
		}*/
	}
	
	public void remove_cycles(LinkedList<Node> link[], int temp,int[] visited)
	{
		//Queue<Integer> q = new LinkedList<Integer>();
		//LinkedList<Node> l = new LinkedList<Node>();
		visited[temp] = 1;
		//q.add(temp);
		
		//while(!q.isEmpty())
		//{
				LinkedList<Node> l = link[temp];
				Iterator<Node> itr = l.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next().data);
				}
				
				itr = l.iterator();
				while(itr.hasNext())
				{
					Node k = itr.next();
					//System.out.println("Printing Data " + k.data);
					if(visited[k.data] == 0)
					{
						//q.add(k.data);
						//visited[k.data] = 1;
						//System.out.println(k.data);
						remove_cycles(link, k.data, visited);
					}
					else
					{
						System.out.println("Removing " + k.data);
						l.remove(k);
					}
				}
			
		//}
		
		
	}
}
