using System;
using System.Text;
class Program { 
	// Main Method 
	static public void Main(String[] args) 
	{
        string str = "52 102 1";
        string[] nums = str.Split(" ");
        int dotNum = 10;
		
		for(int i = 0 ; i < nums.Length ; i++){
			String output = Convert.ToString(Convert.ToInt32(nums[i]), 8);
			int dotLength = dotNum - output.Length;
			StringBuilder sb = new StringBuilder();
			for(int j = 0 ; j < dotLength ; j++){
				sb.Append(".");
			}
			sb.Append(output);
			Console.WriteLine(sb.ToString());
			/*
			Console.WriteLine(sb.ToString());*/
		}
	} 
} 
