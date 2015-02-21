import java.util.ArrayList;
import java.util.List;


public class ListGenerator {

	private List<ListItem>  list;
	private List<Integer> numberUsed;
	
	public ListGenerator(){
		list = new ArrayList<ListItem>();
		numberUsed = new ArrayList<Integer>();
	}
	
	public List<ListItem> generate(int size){
		
		for (int i = 0; i < size; i++ ){
			ListItem e = new ListItem(numberUsed, size );
			list.add(e);
		
			numberUsed.add(e.getX());
			
			
		}
		
		return list;
		
	}
	
	
	
}
