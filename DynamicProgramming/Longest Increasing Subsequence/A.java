import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int temp[] = new int[n];
		Arrays.fill(temp,1);
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i=1;i<n;i++)
			for(int j=0;j<i;j++)
			{
				if((arr[j] < arr[i]) && (temp[i] < temp[j] + 1))
					temp[i] = temp[j] + 1;
			}
			
		int max = 0;
		
		for(int i=0;i<n;i++)
			if(max < temp[i])
				max = temp[i];
			
		System.out.println(max);
	}
}
