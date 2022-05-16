package defaultpackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveState {
	SaveState(Number number) throws IOException {
		FileOutputStream fileOut = new FileOutputStream("countstate.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(number);
		out.close();
		fileOut.close();
	}
}
