package Easy;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		if(s.isEmpty())
			return 0;
		
		int lastSpaces = s.lastIndexOf(' ');
	
		String lastWord = s.substring(lastSpaces + 1);
		return lastWord.length();
	}
	
	public static void main(String[] args) {
		LengthOfLastWord l = new LengthOfLastWord();
		
		System.out.println(l.lengthOfLastWord("luffy is still joyboy"));
	}
}
