import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class ReadFileIntoArray {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		Scanner s;
		try {
			s = new Scanner(chooser.getSelectedFile());
			ArrayList<String> names = new ArrayList<String>();
			while(s.hasNext()){
				String name = s.nextLine();
				names.add(name);
			}
			names.sort(null);
			System.out.println(names.contains("Bob"));
			System.out.println(names);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
