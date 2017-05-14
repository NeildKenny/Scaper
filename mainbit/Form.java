package mainbit;

import java.util.ArrayList;
import java.util.List;

public class Form extends Find{

	private String form_tag = "<form";
	
	public ArrayList<String> findFirstForm( ArrayList<String> elements ){
		
		return findFirst(elements, form_tag );
	}
		
	
	public List<ArrayList<String>> findForms(ArrayList<String> elements){
		 return findAllOccurances(elements, form_tag );
		
	}
	
	public String getActionURL(ArrayList<String> element){
		
		String action_attribute = "action=\"";
		
		if(element.get(0).contains(form_tag)){
			String form_openning = element.get(0);
			
			return findElementVariable(form_openning, action_attribute);
		}else{
			return null;
		}
	}
	
	public ArrayList<String> getInputs(ArrayList<String> elements){
		
		String input_tag = "<input";
		String name_tag = "name=\"";
		
		ArrayList<String> input_variables = new ArrayList<String>();
		
		for(String element : elements){
			if(element.contains(input_tag) && element.contains(name_tag)){
				input_variables.add(findElementVariable(element, name_tag));
			}
		}
		
		return input_variables; 
	}
	
	private String findElementVariable(String element, String attribute){
		return element.substring(element.indexOf(attribute)+attribute.length(),element.indexOf("\"", element.lastIndexOf(attribute)+attribute.length()));
	}
}
