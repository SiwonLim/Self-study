using System;
using System.Text;
class Program { 
	// Main Method 
	static public void Main(String[] args) 
	{
		PrintStats();
	}

	public static void PrintStats()
	{
		string[] format2 = { "Min", "Max", "Sum", "Average" };
		int width = 30;
		double[] numbers = new double[5];
		double min = double.MaxValue;
		double max = double.MinValue;
		double sum = 0;


		for (int i = 0; i < numbers.Length; i++)
		{
			string inputLine = Console.ReadLine().Trim();
			numbers[i] = Convert.ToDouble(inputLine);
			if (numbers[i] < min)
			{
				min = numbers[i];
			}
			if (numbers[i] > max)
			{
				max = numbers[i];
			}
			sum += numbers[i];
		}
		
		// Calculate average
		double average = sum / numbers.Length;
		StringBuilder sb3 = new StringBuilder();
		string minOutput = $"{min:F3}";
		string maxOutput = $"{max:F3}";
		string sumOutput = $"{sum:F3}";
		string averageOutput = $"{average:F3}";
		for (int k = 0; k <= width; k++)
		{
		sb3.Append(".");
		}
		Console.WriteLine(sb3.ToString());
		sb3.Clear();
		for (int i = 0; i < numbers.Length; i++)
		{
			String test = $"{numbers[i]:F3}";
			Console.WriteLine($"{Dots(width - Convert.ToString(numbers[i]).Length, $"{numbers[i]:F3}")}");
		}
		Console.WriteLine($"{format2[0]}{Dots(width - minOutput.Length - format2[0].Length, minOutput)}");
		Console.WriteLine($"{format2[1]}{Dots(width - maxOutput.Length - format2[1].Length, maxOutput)}");
		Console.WriteLine($"{format2[2]}{Dots(width - sumOutput.Length - format2[2].Length, sumOutput)}");
		Console.WriteLine($"{format2[3]}{Dots(width - averageOutput.Length - format2[3].Length, averageOutput)}");
	}
	public static string Dots(int dots, string output)
	{
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < dots; i++)
		{
			sb2.Append('.');
		}
		sb2.Append(output);
		return sb2.ToString();
	}
	
} 
