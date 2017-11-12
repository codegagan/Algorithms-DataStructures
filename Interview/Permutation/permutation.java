import java.io.*;

public class permutation
{
public static void main(String args[])throws IOException
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the string");
	String str = br.readLine();	
	int length = str.length();
	char[] arr = str.toCharArray();
	//System.out.println(arr[0]+""+arr[length-1]);
	permutation obj = new permutation();
	obj.strings(arr,0,length-1);
	}

public void strings(char arr[],int i,int n)	
	{
	if(i==n)
		{
		System.out.println();
	
		for(int k=0;k<=n;k++)
		System.out.print(arr[k]);
		}
	
	else{	
		for(int j=i;j<=n;j++)
			{
			swap(arr,i,j);
			strings(arr,i+1,n);
			swap(arr,i,j);
			}
		}
	}
public void swap(char arr[],int i,int j)
	{
	char temp = arr[i];
	arr[i] = arr[j];
	arr[j]=temp;
	}
}
