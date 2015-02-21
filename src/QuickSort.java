import java.util.List;

public class QuickSort implements SortInterface {

	@Override
	public List<ListItem> sort(List<ListItem> list) {
		{
			// check for empty or null array
			if (list == null || list.size() == 0) {
				return null;
			}
			this.numbers = list;
			number = list.size();
			quicksort(0, number - 1);
			return numbers;
		}

	}

	private List<ListItem>  numbers;
	private int number;

	
	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		ListItem pivot = numbers.get(low + (high - low) / 2);

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers.get(i).getX() < pivot.getX()) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers.get(j).getX() > pivot.getX()) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private void exchange(int i, int j) {
		ListItem temp = numbers.get(i);
		numbers.set(i, numbers.get(j)) ;
		numbers.set(j, temp)  ;
	}

	@Override
	public String GetName() {

		return "quicksort";
	}

}
