package fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;

public class FileTools {

	private File file;

	public FileTools() {
	}

	public FileTools(File f) {
		file = f;
		File dir = new File(file.getParent() + "/");
		if (!file.exists()) {
			try {
				dir.mkdirs();
				file.createNewFile();
			} catch (Exception e) {
			}
		}
	}

	public FileTools(String path) {
		file = new File(path);
		File dir = new File(file.getParent() + "/");
		if (!file.exists()) {
			try {
				dir.mkdirs();
				file.createNewFile();
			} catch (Exception e) {
			}
		}
	}

	public void writeToFile(String data, boolean append) {
		try {
			FileOutputStream fos = new FileOutputStream(file, append);
			fos.write(data.getBytes());
			fos.close();
		} catch (Exception e) {
		}
	}

	public String getFileContents() {
		String in = "", out = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			while ((in = br.readLine()) != null) {
				out += in + "\r\n";
			}

			br.close();
		} catch (Exception e) {
		}
		return out;
	}

	@SuppressWarnings("unused")
	protected void execute() {
		if (file.canExecute()) {
			try {
				Runtime run = Runtime.getRuntime();
				Process p = run.exec(file.getPath());
			} catch (Exception e) {
			}
		}
	}

	public void copyTo(String path) {
		try {
			File dest = new File(path + "/");
			dest.mkdirs();
			dest = new File(path + file.getName());
			dest.createNewFile(); // Destination File path

			InputStream is = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(dest);
			byte[] buf = new byte[64 * 1024];
			int len = 0;

			while ((len = is.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			fos.flush();
			fos.close();
			is.close();
		} catch (Exception e) {
		}
	}

	public File getFileObject() {
		return file;
	}
}