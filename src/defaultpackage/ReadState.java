package defaultpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


@SuppressWarnings("serial")
public class ReadState implements Serializable {
	Number number;

	ReadState() throws IOException, ClassNotFoundException {
		number = MyFrame.save;
		
		File file = new File("countstate.ser");
		if (file.exists()) {
			FileInputStream fileIn = new FileInputStream("countstate.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			number = (Number) in.readObject();
			in.close();
			fileIn.close();
		}
		else
			number.setNumber(0);
		
	}
}
