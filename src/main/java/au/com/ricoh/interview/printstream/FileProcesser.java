package au.com.ricoh.interview.printstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class FileProcesser {

	private String getValue(String valueLocation,String key){
		if(null!=valueLocation&&!"".equalsIgnoreCase(valueLocation)){			
			// can read value from file or database,etc
			return null;
		}
		
		if("USERID".equals(key)){
			return "Ricoh-HB";
		}
		
		return null;
	}
	
	public void processFile(){

		String filePath = null;
		
		
		if(null==filePath||"".equalsIgnoreCase(filePath)){
		//	filePath = "C://workspacemars//printstream//src//test//samples//sample1.pjl";
			filePath="D://Project//eclipseworkspace//printstream//src//test//samples//sample1_modified.pjl";
		}
		
		String desFilePath = "C://workspacemars//printstream//src//test//samples//sample1_modified.pjl";
		
		 File originalPSFile = new File(filePath);
		 long filePos =0;

		 try {

			 RandomAccessFile raf = new RandomAccessFile(originalPSFile, "rw");
			//read file
			String line = raf.readLine();
			boolean flag = true;
			 while (line != null&&flag) {
				    if (line.indexOf("@PJL SET USERID")>=0 && flag) { 
				    // write file
				    	
				    	raf.seek(filePos);
				    	raf.writeBytes("@PJL SET USERID = Test00000002\n");
				     flag =false ;
				    } else {
				    // write file
				    }
				    filePos=raf.getFilePointer();
				    line = raf.readLine();
				    
				   }
			 raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
	
	
	public void  proccessFile(File originalFile){
		String filePath = null;
		
		if(null!=originalFile){
			filePath = originalFile.getPath();
		}
		
		if(null==filePath||"".equalsIgnoreCase(filePath)){
			filePath = "C://workspacemars//printstream//src//test//samples//sample1.pjl";
			
		}
		
		String desFilePath = "C://workspacemars//printstream//src//test//samples//sample1_modified.pjl";
		
		 File originalPSFile = new File(filePath);
		 PrintWriter pw = null;
		 FileReader fr = null;
		 
		 try {
			pw = new PrintWriter(desFilePath);
			fr = new FileReader(originalPSFile);
			
			LineNumberReader lnr = new LineNumberReader(fr);
			//read file
			String line = lnr.readLine();
			boolean flag = true;
			 while (line != null) {
				    if (line.indexOf("@PJL SET USERID")>=0 && flag) { 
				    // write file
				     pw.println("@PJL SET USERID = Test001");
				     flag =false ;
				    } else {
				    // write file
				     pw.println(line); 
				    }
				    line = lnr.readLine();
				   }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
}
