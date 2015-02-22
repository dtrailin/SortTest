import java.util.ArrayList;
import java.util.List;


public class InsertSort implements SortInterface {

	@Override
	public List<ListItem> sort(List<ListItem> list) {
		List<ListItem> newList =  new ArrayList<ListItem>(list);
	    int i, j;
		ListItem newValue;
	      for (i = 1; i < newList.size(); i++) {
	            newValue = newList.get(i);
	            j = i;
	            while (j > 0 &&  newList.get(j - 1).getX() > newValue.getX()) {
	            	newList.set(j, newList.get(j-1 )); 
	                  j--;
	            }
	            newList.set(j, newValue);
	      }
	      return newList;
	}
		
		
		

	

	@Override
	public String GetName() {
				return "Insert Sort";
	}

}
