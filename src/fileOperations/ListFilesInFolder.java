package fileOperations;

import java.io.File;

public class ListFilesInFolder {
	public void listFilesInFolder(File folder) {
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				System.out.println(file.getName());
				// or do whatever you want with it
			}
		}
	}

	public void listFilesInFolderAndSubfolder(File folder) {
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				listFilesInFolderAndSubfolder(file);
			} else {
				System.out.println(file.getName());
				// or do whatever you want with it
			}
		}
	}
}
