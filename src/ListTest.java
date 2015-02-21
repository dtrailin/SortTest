import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		int listSize = 0;
		if (args.length > 0) {
		    try {
		    	listSize = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + args[0] + " must be an integer.");
		        System.exit(1);
		    }
		}
		
		List<ListItem> unsortedList;
		
		
		
		ListGenerator listGen = new ListGenerator();

		unsortedList = listGen.generate(listSize);
		System.out.println("list generated");

		InsertSort s = new InsertSort();
		QuickSort qs = new QuickSort();

		printSortTime(s,unsortedList);
		printSortTime(qs,unsortedList);

		
		
	}

	public static long sortTime(SortInterface x,List<ListItem> list ) {
		
		long startTime = System.nanoTime();
		x.sort(list);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		duration = duration / 1000000;
		return duration;
	}
	
	public static void printSortTime(SortInterface x,List<ListItem> list ){
		
		System.out.println(x.GetName() + " time:");
		System.out.println( sortTime(x, list) + " ms");
	}
	
	public void printList(List<ListItem> list){
		
		for (ListItem i : list) {
			System.out.println(i.getWord());
		}

	}

}
