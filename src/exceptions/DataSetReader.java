package exceptions;

//From an example in Big Java, by Cay Horstman
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSetReader {

	private ArrayList<Double> data;

	public ArrayList<Double> readFile(String fileName) throws IOException {
		FileReader reader = new FileReader(fileName);
		try {
			Scanner scan = new Scanner(reader);
			readData(scan);
		} finally {
			reader.close();
		}
		return data;
	}

	private void readData(Scanner scan) {
		if (!scan.hasNextInt()) {
			throw new DataException("Integer data count expected");
		}
		int dataCount = scan.nextInt();

		data = new ArrayList<Double>();

		for (int k = 0; k < dataCount; k++) {
			readItem(k, scan);
		}

		if (scan.hasNext()) {
			throw new DataException("End of file expected");
		}
	}

	private void readItem(int index, Scanner scan) {
		if (!scan.hasNext()) {
			throw new DataException("Another data item expected");
		}
		if (!scan.hasNextDouble()) {
			throw new DataException("Double value expected");
		}

		double item = scan.nextDouble();
		data.add(item);
	}
}