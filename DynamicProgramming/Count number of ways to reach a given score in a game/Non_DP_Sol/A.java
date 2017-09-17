import java.io.*;

public class A{
	public static void main(String args[])throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input the final score");
		int score = Integer.parseInt(br.readLine());
		int arr[] = new int[3];
		arr[0] = 3;
		arr[1] = 5;
		arr[2] = 10;
		
		A obj = new A();
		System.out.println(obj.max_score(arr,score,0));
		}

	public int max_score(int arr[],int score,int k)
		{
		if(score < 0)
			return 0;
		
		if(score == 0)
			return 1;

		int res = 0;
		
		for(int i=k;i<3;i++)
			{
			res += max_score(arr,score-arr[i],i); 
			}
		
		return res;
		}
	}
