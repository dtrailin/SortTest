import java.util.List;


public class InsertSort implements SortInterface {

	@Override
	public List<ListItem> sort(List<ListItem> list) {

	    int i, j;
		ListItem newValue;
	      for (i = 1; i < list.size(); i++) {
	            newValue = list.get(i);
	            j = i;
	            while (j > 0 &&  list.get(j - 1).getX() > newValue.getX()) {
	            	list.set(j, list.get(j-1 )); 
	                  j--;
	            }
	            list.set(j, newValue);
	      }
	      return list;
	}
		
		
		

	

	@Override
	public String GetName() {
				return "Insert Sort";
	}

}
