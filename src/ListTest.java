import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static List<SortInterface> sorters = new ArrayList<SortInterface>();

	public static void main(String[] args) {

		int listSize = 0;
		boolean repeat = true;
		boolean csvOutput = false;
		int samples = 0;
		if (args.length > 0) {
			try {
				listSize = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument" + args[0]
						+ " must be an integer.");
				System.exit(1);
			}
		}

		if (args.length > 1) {
			csvOutput = Boolean.parseBoolean(args[1]);

		}
		if (args.length > 2) {
			if (csvOutput) {
				try {
					samples = Integer.parseInt(args[2]);
				} catch (NumberFormatException e) {
					System.err.println("Argument" + args[2]
							+ " must be an integer if csvOutput is true");
					System.exit(1);
				}
			} else {
				repeat = Boolean.parseBoolean(args[2]);
			}

		}

		//InsertSort s = new InsertSort();
		//sorters.add(s);
		QuickSort qs = new QuickSort();
		sorters.add(qs);
		MergeSort m = new MergeSort();
		sorters.add(m);
		HeapSort h = new HeapSort();
		sorters.add(h);

		if (csvOutput) {
			try {
				csvLister(sorters, samples, listSize);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			List<ListItem> unsortedList;

			ListGenerator listGen = new ListGenerator();

			unsortedList = listGen.generate(listSize, repeat);
			System.out.println("list generated");

			for (SortInterface i : sorters) {
				printSortTime(i, unsortedList);
			}
		}
	}

	public static long sortTime(SortInterface x, List<ListItem> list) {

		long startTime = System.nanoTime();
		x.sort(list);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		duration = duration / 1000000;
		return duration;
	}

	public static void printSortTime(SortInterface x, List<ListItem> list) {

		System.out.println(x.GetName() + " time:");
		System.out.println(sortTime(x, list) + " ms");
	}

	public static boolean verifySort(List<ListItem> list) {
		for (int i = 0; i < list.size() - 1; i++) {

			if (list.get(i).getX() > list.get(i + 1).getX()) {
				return false;
			}
		}
		return true;
	}

	public static void printList(List<ListItem> list) {

		for (ListItem i : list) {
			System.out.println(i.getWord());
		}
		System.out.println("");

	}

	public static void csvLister(List<SortInterface> sorters, int samples,
			int max) throws FileNotFoundException, UnsupportedEncodingException {
		ListGenerator listGen = new ListGenerator();
		List<ListItem> unsortedList;
		PrintWriter writer = new PrintWriter("sortTimes.csv", "UTF-8");
		writer.println("Sort Type, Elements, Time");

		int increment = max / samples;
		for (int j = 1; j <= samples; j++) {
			System.out.println("testing size " + j);
			unsortedList = listGen.generate(increment * j, true);
			for (SortInterface i : sorters) {
				writer.println(i.GetName() + "," + increment * j + ","
						+ sortTime(i, unsortedList));

			}

		}

		writer.close();

	}

}
