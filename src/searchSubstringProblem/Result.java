package searchSubstringProblem;

public class Result {
	private long stringNumber;
	private String resultString;
	public Result(long stringNumber, String resultString) {
		this.setStringNumber(stringNumber);
		this.setResultString(resultString);
	}
	public long getStringNumber() {
		return stringNumber;
	}
	public void setStringNumber(long stringNumber) {
		this.stringNumber = stringNumber;
	}
	public String getResultString() {
		return resultString;
	}
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	@Override
	public String toString() {		
		return stringNumber + " - " + resultString + "\n";
	}

}
