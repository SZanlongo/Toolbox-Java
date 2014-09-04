package exceptions;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DataSetTest {
	public static void main(String[] args) throws IOException {
		DataSetReader reader = new DataSetReader();
		Scanner keys = new Scanner(System.in);

		boolean successful = false;
		while (!successful) {
			try {

				System.out.print("File name ? ");
				String fileName = keys.next();

				// double[] data = reader.readFile(fileName);
				ArrayList<Double> data = reader.readFile(fileName);

				double sum = 0.0;
				for (double item : data)
					sum += item;
				// System.out.println(data.length + " Items.  Sum: " + sum);
				System.out.println(data.size() + " Items.  Sum: " + sum);

				successful = true;
			} catch (FileNotFoundException exception) {
				System.out.println("File not found");
			} catch (DataException exception) {
				System.out.println("Data Error > " + exception.getMessage());
			}
		}
	}
}