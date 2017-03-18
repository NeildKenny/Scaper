package mainbit;

import java.util.ArrayList;
import java.util.List;

public class Find {

	public ArrayList<String> findFirst( ArrayList<String> elements, String find_element ){
		
		ArrayList<String> element_list = new ArrayList<String>();

		String find_element_end = elementEnd(find_element);

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

		
		for(int i = 0; i<element_list.size();i++){
			System.out.println(element_list.get(i));
		}
		
		System.out.println("Element found: " 	+ elements_found + "\n" 
						+ "First position: " 	+ first_position + "\n"
						+ "Last position: " 	+ last_position + "\n");

		return element_list;
		
		
	}
	
	public List<ArrayList<String>> findAllOccurances( ArrayList<String> elements, String find_element ){
		List<ArrayList<String>> elements_list = new ArrayList<ArrayList<String>>();
		

		String find_element_end = elementEnd(find_element);
		System.out.println( find_element_end );
		int elements_found = 0;
		int first_position = 0; 
		int last_position = 0;
		
		int first_count = 0; 
		int second_count = 0;
		
		

		for( int i = 0; i<elements.size(); i++ ){
			if( elements.get(i).contains(find_element) ){
				elements_found++; 
				elements_list.add(new ArrayList<String>());
			
				first_count++;
			}
			
			if( elements_found !=0 ){
				for( int j=0; j<elements_found; j++ ){
					elements_list.get(j).add(elements.get(i));
				}
			}
			
			if( elements.get(i).contains(find_element_end) && elements_found !=0 ){
				elements_found--;
				second_count++;
			}
		}
		
		
		
		for(int i= 0; i<elements_list.size(); i++){
			
			System.out.println("----------------------------------------------------------------");
			for(int j=0; j<elements_list.get(i).size(); j++){
				System.out.println( elements_list.get(i).get(j) );
			}
		}
		

		System.out.println("Element found: " 	+ elements_found + "\n" 
				+ "First position: " 	+ first_position + "\n"
				+ "Last position: " 	+ last_position + "\n"
				+ "Element list: " + elements_list.size() + "\n"
				+ "first count" + first_count +  "\n"
				+ "second count" + second_count + "\n"
				+ "array list" + elements_list.size() + "\n"
				+ "array list 2 " + elements.get(0).length()
				);
		return elements_list; 
		
	}
	
	private String elementEnd(String find_element){
		
		if(find_element == "<img" || find_element == "<meta" || find_element == "<link" ){
			return ">";
		}else{
			return "</" + find_element.substring(1, find_element.length()) + (find_element.contains(">") ? "" : ">");
		}

	}
	
}
