package mainbit;

import java.util.ArrayList;
import java.util.List;

public class Find {

	
	private boolean debug = true; 
	
	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public ArrayList<String> findFirst( ArrayList<String> elements, String find_element ){
		
		ArrayList<String> element_list = new ArrayList<String>();

		String find_element_end = elementExit(find_element);

		int elements_found = 0;
		int first_position = 0; 
		int last_position = 0;
		
		
		for( int i = 0; i<elements.size(); i++ ){
			
			if(elements.get(i).contains(find_element)){
				elements_found++;
				
				if(first_position == 0){
					first_position = i;
				}
				
			}
			
			if(first_position != 0){
				element_list.add(elements.get(i));
				//System.out.print(elements.get(i) + "\n");

			}
			
			if( elements.get(i).contains(find_element_end) && first_position != 0 ){
				elements_found--;
				if(elements_found == 0){
					last_position = i; 	
					break;
				}
			}
			
		}

		if(debug){
			for(int i = 0; i<element_list.size();i++){
				System.out.println(element_list.get(i));
			}
			
			System.out.println("Element found: " 	+ elements_found + "\n" 
							+ "First position: " 	+ first_position + "\n"
							+ "Last position: " 	+ last_position + "\n");
		}
		return element_list;
		
		
	}
	
	public List<ArrayList<String>> findAllOccurances( ArrayList<String> elements, String find_element ){
		
		List<ArrayList<String>> elements_list = new ArrayList<ArrayList<String>>();
		List<ArrayList<String>> elements_list2 = new ArrayList<ArrayList<String>>();

		String find_element_exit = elementExit(find_element);
		if(debug){
			System.out.println( "exit element: \'" + find_element_exit + "\'");
		}
		int elements_found = 0;

		
		int find_entrance_count = 0; 
		int find_exit_count = 0;
		
		

		for( int i = 0; i<elements.size(); i++ ){
			if( elements.get(i).contains(find_element) ){
				
				elements_found++; 
				find_entrance_count++;
				elements_list.add(new ArrayList<String>());
				
			}
			
			if( elements_found !=0 ){
				for( int j=0; j<elements_found; j++ ){
					
					elements_list.get(j).add(elements.get(i));
				
				}
			}
			
			if( elements.get(i).contains(find_element_exit) && elements_found !=0 ){

				elements_list2.add(elements_list.get(elements_list.size()-1));
				elements_list.remove( elements_list.size()-1 );
				
				elements_found--;
				find_exit_count++;

			}
		}
		
			
		if(debug){		
			for(int i= 0; i<elements_list2.size(); i++){
				
				System.out.println("----------------------------------------------------------------" + i);
				for(int j=0; j<elements_list2.get(i).size(); j++){
					System.out.println( elements_list2.get(i).get(j) );
				}
				//System.out.println(elements_list.get(i).size());
			}
			
			System.out.println( "Count for find element \'" + find_element + "\': " + find_entrance_count + "\n"
							+	"Count for find element exit \'" + find_element_exit + "\': " + find_exit_count + "\n");
	}

		return elements_list; 
		
	}
	
	private String elementExit(String find_element){
		
		if(find_element == "<img" || find_element == "<meta" || find_element == "<link" ){
			return ">";
		}else{
			return "</" + find_element.substring(1, find_element.length()) + (find_element.contains(">") ? "" : ">");
		}

	}
	
}
