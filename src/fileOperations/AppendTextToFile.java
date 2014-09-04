package fileOperations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AppendTextToFile {
	public void appendText() throws IOException {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("filename", true));
			out.write("aString");
		} catch (IOException e) {
			// error processing code
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
