package au.com.ricoh.interview.printstream;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


public class FileProcesser {

	public void processFile(){

		String filePath = null;
		if(null==filePath||"".equalsIgnoreCase(filePath)){
		// filePath = "C://workspacemars//printstream//src//test//samples//sample1.pjl";
		filePath="D://Project//eclipseworkspace//printstream//src//test//samples//sample1.pjl";
		}
		String modifiedFile = "D://Project//eclipseworkspace//printstream//src//test//samples//sample1_modified.pjl";
		File originalFile = new File(filePath);
		// file pointer before line @PJL SET USERID
		long startPoint =0;
		// file pointer after line @PJL SET USERID
		long endPoint =0;

		
		try {

			RandomAccessFile raf = new RandomAccessFile(originalFile, "r");
			//read file line by line
			String line = raf.readLine();
			//indicate whether find the userid
			boolean flag = true;
			while (line != null&&flag) {
				if (line.indexOf("@PJL SET USERID")>=0 && flag) { 
					// write file
					FileOutputStream outputStream =
							new FileOutputStream(modifiedFile); 


					endPoint = raf.getFilePointer();
    
					//1st part, file content before line @PJL SET USERID     
					byte[] bufferPre = readFileSegment(originalFile,0,(int)startPoint);

					outputStream.write(bufferPre);
    
					//2nd part, use below line replace the user id
					String userId= "@PJL SET USERID = Test00000002\n";
					outputStream.write(userId.getBytes());
    
					//3rd part, read rest of file and put into the new file
					int size =(int) (raf.length()-endPoint);
					byte[] bufferBack = readFileSegment(originalFile,(int)endPoint,size);
					outputStream.write(bufferBack);
    
					outputStream.close(); 
    
					flag =false ;
				} else {
					// write file
				}
				startPoint=raf.getFilePointer();
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
	
	public byte[] readFileSegment(File file, int index, int count) {
		RandomAccessFile raf;
		byte[] buffer = new byte[count];
		try {
			raf = new RandomAccessFile(file,"r");
			raf.skipBytes(index);
			raf.readFully(buffer, 0, count);
			raf.close();    
       
			return buffer;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

		return buffer;
   }
   
}

