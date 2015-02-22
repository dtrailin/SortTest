import java.util.List;
import java.util.ArrayList;

public class HeapSort implements SortInterface {
	// implementation copied from @WWaldo

	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return "Heapsort";
	}

	public List<ListItem> sort(List<ListItem> list) {
		
		ArrayList<ListItem> unsortedList = new ArrayList<ListItem>(list);
		int count = unsortedList.size();
		heapify(unsortedList, count);
		int end = count - 1;
		while (end > 0) {
			swap(unsortedList, end, 0);
			end = end - 1;
			siftDown(unsortedList, 0, end);
		}
		return unsortedList;
	}

	public void heapify(ArrayList<ListItem> unsortedList, int count) {
		int start = count / 2 - 1;
		while (start >= 0) {
			siftDown(unsortedList, start, count - 1);
			start -= 1;
		}
	}

	public void siftDown(ArrayList<ListItem> unsortedList, int start, int end) {
		int root = start;
		while (root * 2 + 1 <= end) {
			int child = root * 2 + 1;
			int swap = root;
			if (unsortedList.get(swap).getX() < unsortedList.get(child).getX()) {
				swap = child;
			}
			if (child + 1 <= end
					&& unsortedList.get(swap).getX() < unsortedList.get(
							child + 1).getX()) {
				swap = child + 1;
			}
			if (swap != root) {
				swap(unsortedList, root, swap);
				root = swap;
			} else {
				return;
			}
		}
	}

	public void swap(ArrayList<ListItem> unsortedList, int swapOne, int swapTwo) {
		ListItem holder = unsortedList.get(swapOne);
		unsortedList.set(swapOne, unsortedList.get(swapTwo));
		unsortedList.set(swapTwo, holder);
	}

}