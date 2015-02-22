import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeSort implements SortInterface {

	@Override
	public List<ListItem> sort(List<ListItem> list) {
		 
		List<ListItem> newList = new ArrayList<ListItem>(list);
		Comparator<ListItem> comparator = new Comparator<ListItem>() {
		    public int compare(ListItem c1, ListItem c2) {
		        return c1.getX() - c2.getX(); 
		    }
		};

		Collections.sort(newList, comparator); 
	
	return newList;
	}

	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return "Merge Sort" ;
	}

}
