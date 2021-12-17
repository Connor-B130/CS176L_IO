import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Locale;

public class PopulationAggregator 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		
		File input = new File("populations.txt");
		
		PrintWriter out = new PrintWriter("output.txt");
		
		Scanner scan = new Scanner(input);
		scan.useLocale(Locale.US);
		
		int max = 0;
		int min = 999999;
		int total = 0;
		int count = 1;
		String cityMin = "";
		String cityMax = "";
	
		while (scan.hasNextLine()) 
		{
			String in = scan.nextLine();
	
			int i = 0;
			while(!Character.isDigit(in.charAt(i))) 
			{
				i++;
			}
			String cityName = in.substring(0,i);
			String pop = in.substring(i);
			
			int population = Integer.parseInt(pop);
			cityName.trim();
			
			if (population < min) 
			{
				min = population;
				cityMin = cityName;
			}
			
			if (population > max) 
			{
				max = population;
				cityMax = cityName;
			}
			
			total += population;
			
			count ++;
		}
		cityMax.trim();
		cityMin.trim();
		
		out.println("Most Populated: " + cityMax + " " + max);
		out.println("Least Populated: " + cityMin + " " + min);
		out.println("Total Population: " + total);
		out.println("Average Population: " + (total/count));
		
		out.close();
	
	}
}