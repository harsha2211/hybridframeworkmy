package utilities;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {

	
	public static HashMap<Integer, ArrayList<String>> getData(String SheetName) throws Exception{
		HashMap<Integer, ArrayList<String>> dataMap= new HashMap<Integer, ArrayList<String>>();
		
		
		 File file= new File("E:\\java class radical technology\\HybridFrameWork\\src\\testData\\data.xls");
		 FileInputStream io=new FileInputStream(file) ;
		 HSSFWorkbook wb=new HSSFWorkbook(io);
		 HSSFSheet sheet=wb.getSheet(SheetName);
		 int maxRow= sheet.getLastRowNum();
		 //System.out.println(maxRow);
		 
		  for (int i=0; i<=maxRow; i++) {
			  ArrayList<String> cellData=new ArrayList<String>();
			  
			  HSSFRow row=sheet.getRow(i);
			  int maxCell=row.getLastCellNum();
			  for (int j=0; j<maxCell; j++) {
				  HSSFCell cell=row.getCell(j);
				  if(cell!=null) {
					  cellData.add(cell.getStringCellValue());
					  
				  }
				  
			  }
			  dataMap.put(i, cellData);
		  
		  }
		
		
		
		
		 
		return dataMap;
	}
}
