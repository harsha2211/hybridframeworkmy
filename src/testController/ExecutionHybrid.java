package testController;

import java.util.ArrayList;
import java.util.HashMap;

import keywordLibrary.Keywords;
import utilities.Excel;

public class ExecutionHybrid {

	public static void main(String[] args) throws Exception {
		HashMap<Integer, ArrayList<String>> data=Excel.getData("amazon");
	     System.out.println(data);
		 for (Integer key : data.keySet()) {
			 ArrayList<String> values=data.get(key);
			 System.out.println(values);
			 
			  Keywords.invokeKeyword(values.get(0),values.get(1),values.get(2),values.get(3));
			  
		}

	}

}
