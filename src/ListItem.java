import java.util.List;
import java.util.Random;

public class ListItem implements Comparable<ListItem> {

	private Integer x;
	private String word;

	public ListItem(List<Integer> used, int max, boolean repeat) {

		Random rand = new Random();
		if (repeat) {
			x = rand.nextInt(max);
			;
		} else {
			if (used == null) {
				x = rand.nextInt(max);
			} else {
				while (x == null) {

					int randomNum = rand.nextInt(max);
					if (!used.contains(randomNum)) {
						x = randomNum;
					}

				}
			}
		}
		word = EnglishNumbersToWords.convert(x.longValue());

	}

	public String getWord() {
		return word;
	}

	public int getX() {
		return x;
	}

	@Override
	public int compareTo(ListItem o) {

		if (this.getX() == ((ListItem) o).getX())
			return 0;
		else if ((this.getX()) > ((ListItem) o).getX())
			return 1;
		else
			return -1;

	}

}
