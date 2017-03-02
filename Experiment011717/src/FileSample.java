import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File notepad = new File("C:\\Users\\ppham02219\\Desktop\\HelloWorld.txt");
		if(notepad.exists()){
			try {
				Scanner s = new Scanner(notepad);
				while(s.hasNextLine())
				{
					System.out.println(s.nextLine());
				}			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

}
