# printstream
A.	How to implementation 
1.	Find the position of USERID command. 
2.	Divided the file to 3 parts based on that position 
3.	Read the first part that before the USERID command and write to new file.
4.	Replace USERID and appended to the new file from step 3
5.	Read the last part that after the USERID command and appended the file from step 4
  As below displays :
 
B.	How to run
Can call method processFile(String filePath, String modifiedFile, String userId) from class FileProcesser in the package au.com.ricoh.interview.printstream;

filePath :  original file which wanted to be modified
modifiedFile: new file created after be modified
userId: user id want to be change to
If the variables are null, they will use default value. Please do change the default value before you run. Please change the value in Class FileProcesser
This project can be download from https://github.com/bluefish001/printstream as well.
