import java.util.ArrayList;
import java.util.List;

public class QuickSort implements SortInterface {

	@Override
	public List<ListItem> sort(List<ListItem> list) {
		{
			if (list == null || list.size() == 0) {
				return null;
			}
			this.numbers = new ArrayList<ListItem>(list);
			number = list.size();
			quicksort(0, number - 1);
			return numbers;
		}

	}

	private List<ListItem> numbers;
	private int number;

	private void quicksort(int low, int high) {
		int i = low, j = high;

		ListItem pivot = numbers.get(low + (high - low) / 2);

		while (i <= j) {

			while (numbers.get(i).getX() < pivot.getX()) {
				i++;
			}

			while (numbers.get(j).getX() > pivot.getX()) {
				j--;
			}

			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private void exchange(int i, int j) {
		ListItem temp = numbers.get(i);
		numbers.set(i, numbers.get(j));
		numbers.set(j, temp);
	}

	@Override
	public String GetName() {

		return "quicksort";
	}

}
