import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class A{
	public static void main(String args[]) throws Exception
	{
		A obj = new A();
		HashMap<String,String> map = new HashMap<String,String>();
		int physicalStorageSize = 0;
		while(true)
		{
			System.out.println("Input File name or enter quit to come out of program");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String fileName = br.readLine();
			if(!fileName.equals("quit"))
			{
				Reader r = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), "US-ASCII"));
				
					StringBuilder resultBuilder = new StringBuilder();
					int count = 0;
					int number=6000;
					int intch;
					while (((intch = r.read()) != -1)) {
						
						if(count < number)
						{
							resultBuilder.append((char) intch);
							count++;
						}
						else{
						String hashKey = obj.getHashKey(resultBuilder.toString()); //Get SHA1 value for the string
						//System.out.println(hashKey);
						int keyExists = obj.checkKeyExists(map,hashKey); //Check if Hashkey exists already or not.
						
						if(keyExists == 0)
						{
							map.put(hashKey, resultBuilder.toString()); //Insert data into hashmap, if chunk is unique.
							physicalStorageSize = physicalStorageSize + 1; //Calculating physical data stored after de-duplication of all files.
						}

						
						count=0;
						resultBuilder.setLength(0);
						}
						}		
			}
			else
			{
				break;
			}
	
		}
		
		System.out.println(physicalStorageSize);
							
	}
	


	public String getHashKey(String str)throws NoSuchAlgorithmException
	{
		
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(str.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
	}
	
	public int checkKeyExists(HashMap<String,String> map,String hashKey)
	{
		String val = map.get(hashKey);
		
		if(val != null)
			return 1;
		else
			return 0;
	}

}

