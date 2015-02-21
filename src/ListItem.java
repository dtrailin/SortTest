import java.util.List;
import java.util.Random;

public class ListItem {

	private Integer x;
	private String word;

	public ListItem(List<Integer> used, int max) {

		Random rand = new Random();
		
		if (used == null){
			x = rand.nextInt(max);
		}
		else{
		while (x == null) {

			int randomNum = rand.nextInt(max );
			if (!used.contains(randomNum)) {
				x = randomNum;
			}

		}}
		word = EnglishNumbersToWords.convert(x.longValue());

	}

	public String getWord() {
		return word;
	}

	public int getX() {
		return x;
	}

}
