package au.com.ricoh.interview.printstream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FileProcesserTester {
	private String originalFile;
	private String modifiedFile;
	private String userId;
	
	@Before
    public void setUp() {
		originalFile = "D://Project//eclipseworkspace//printstream//src//test//samples//sample2.pjl";
		modifiedFile = "D://Project//eclipseworkspace//printstream//src//test//samples//sample2_modified.pjl";
		userId = "HongboJunitTest";
        System.out.println("@Before - setUp");
    }
	
	
	@Test
	public void testProcessFile() throws IOException{
		FileProcesser fileProcesser = new FileProcesser();
		
		try {
			fileProcesser.processFile(originalFile, modifiedFile, userId);
			RandomAccessFile rafOrg = new RandomAccessFile(originalFile, "r");
			RandomAccessFile rafModified = new RandomAccessFile(modifiedFile, "r");
			
			int fileSizeDif = (int)(rafModified.length()-rafOrg.length());
			int idRowDif = userId.getBytes().length - "\"?\"\n".getBytes().length;
				
			assertEquals(fileSizeDif,idRowDif);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}

}
