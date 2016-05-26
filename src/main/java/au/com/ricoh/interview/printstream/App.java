package au.com.ricoh.interview.printstream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Let's do it!" );
        FileProcesser fp = new FileProcesser();
        fp.processFile();
        
        System.out.println( "Done!" );
    }
}
