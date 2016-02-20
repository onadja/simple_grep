package searchSubstringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSubstrings {
	private String pattern;
	private Map<Character, Integer> rightPositions;

	public SearchSubstrings(String pattern) {
		this.pattern = pattern;
		rightPositions = new HashMap<>();
		preprocessPattern();
	}
	private void preprocessPattern () {
		rightPositions.clear();
		for (int i = pattern.length() - 1; i >= 0; i--) {
			char currentChar = pattern.charAt(i);
			if (!rightPositions.containsKey(currentChar)) rightPositions.put(currentChar, i);
		}
	}
	
	List<Result> findBoyerMoore(BufferedReader streamToFindPattern) {
		List<Result> result = new ArrayList<>();
		int currentFirstPatternPosition = 0;
		try {
			String line;
			while ((line = streamToFindPattern.readLine()) != null) {
				while (currentFirstPatternPosition + pattern.length() <= line.length()) {
					for (int positionInPattern = pattern.length()- 1; positionInPattern >= 0; positionInPattern--) {  
						int positionInLine = currentFirstPatternPosition + positionInPattern; 
						if (positionInLine >= line.length()) break;  
		                if (line.charAt(positionInLine) != pattern.charAt(positionInPattern)) {  
		                    Integer shift = rightPositions.get(line.charAt(positionInLine));  
		                    if (shift == null) {  
		                    	currentFirstPatternPosition = positionInLine + 1;  
		                    }  
		                    else {  
		                        shift = positionInLine - (currentFirstPatternPosition + shift);  
		                        currentFirstPatternPosition += shift > 0 ? shift : 1;  
		                    }  
		                    break;  
		                }  
		                else if (positionInPattern == 0) {  
		                	result.add(new Result(currentFirstPatternPosition + 1, line));  
		                    currentFirstPatternPosition++;  
		                }  
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
