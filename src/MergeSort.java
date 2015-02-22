import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MergeSort implements SortInterface {

	@Override
	public List<ListItem> sort(List<ListItem> list) {
		 
		List<ListItem> newList =  new ArrayList<ListItem>(list);
		Collections.sort(newList);
	return list;
	}

	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return "Merge Sort" ;
	}

}
