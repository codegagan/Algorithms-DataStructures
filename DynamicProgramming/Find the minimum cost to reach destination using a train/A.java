import java.io.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Last Station");
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			{
				if(j>i)
				{
					System.out.println("Enter fare from " + i + "to" + j + " station");
					arr[i][j] = Integer.parseInt(br.readLine());
				}
				else
				{
					arr[i][j] = 0;
				}
			}
			
		for(int i=0;i<N;i++)
			for(int j=i+2;j<N;j++)
			{
				if(arr[i][j] > (arr[i][j-1] + arr[j-1][j]))
				{
					
					arr[i][j] = arr[i][j-1] + arr[j-1][j];
					System.out.println(arr[i][j]);
				}
			}
		System.out.println("Enter the starting and ending station");
		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());
		
		System.out.println(arr[start-1][end-1]);
	}
}
