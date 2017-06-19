import java.io.*;
import java.util.*;

class B implements Comparable<B>{
	int start;
	int end;
	int profit;
	
	public B(int start,int end,int profit)
	{
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
	
	public int compareTo(B obj)
	{
		return (new Integer(end)).compareTo(new Integer(obj.end));
	}
	
	public String toString()
	{
		return (start + " " + end + " " + profit);
	}
}

public class A{
	int dp[];
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<B> al = new ArrayList<B>();
		
		while(true)
		{
			System.out.println("Input start time, end time and profit or type quit exit");
			String str = br.readLine();
		
			if(str.equalsIgnoreCase("quit"))
				break;
			else
			{
				int start = Integer.parseInt(str);
				int end = Integer.parseInt(br.readLine());
				int profit = Integer.parseInt(br.readLine());
				
				al.add(new B(start,end,profit));
			}		
		}
		Collections.sort(al);
		
		/*Iterator itr = al.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}*/
		
		A obj = new A();
		obj.dp = new int[al.size()];
		for(int i=0;i<=(al.size() - 1);i++)
			obj.dp[i] = -1;
		
		System.out.println(obj.max_profit(al,al.size() - 1));
		
	}
	
	public int max_profit(ArrayList<B> al, int n)
	{
		if(n<0)
			return 0;
		if(dp[n] != -1)
			return dp[n];
		
		int include = (al.get(n)).profit;
		int temp = get_next(al,n);
		if(temp != -1)
			include += max_profit(al,temp);
		
		int exclude = max_profit(al,n-1);
		
		return dp[n] = max(include, exclude);
	}
	
	public int get_next(ArrayList<B> al,int i)
	{
		for(int j = i-1;j>=0;j--)
		{
			if(al.get(j).end <= al.get(i).start)
				return j;
		}
		return -1;
	}
	
	public int max(int a,int b)
	{
		if(a<=b)
			return b;
		else
			return a;
	}
}

