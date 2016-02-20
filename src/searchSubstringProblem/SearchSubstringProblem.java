package searchSubstringProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SearchSubstringProblem {
	
	private static void outputResult(String fileName, List<Result> result, PrintStream outputStream) {
		String stringToPrint = fileName + ": ";
		for (Result res: result) {
			stringToPrint += res.toString();
		}
		outputStream.print(stringToPrint);
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			throw new IllegalArgumentException("Too few arguments!");
		}
		SearchSubstrings searchSubstrings= new SearchSubstrings(args[0]);
		ArrayList<Result> result = new ArrayList<>();
		for (String fileName: args) {
			if (fileName == args[0]) continue;
			try {
				result.addAll(searchSubstrings.findBoyerMoore(new BufferedReader(new FileReader(fileName))));		
				outputResult(fileName, result, System.out);
				result.clear();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

}
