package epamTraining.Tasks;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ThirdTask {
	private List<File> listOfDirectoryFiles = new ArrayList<>();

	public void createListOfFilesInDirectoryAndItsSubdirectories(File directory) {
		if (directory.isDirectory() && directory.listFiles() != null) {
			for (File element : directory.listFiles()) {
				if (element.isFile()) {
					listOfDirectoryFiles.add(element);
				} else if (element.isDirectory()) {
					createListOfFilesInDirectoryAndItsSubdirectories(new File(element.getAbsolutePath()));
				}
			}
		}
	}

	public void printListOfFilesInDirectoryAndItsSubdirectories() {
		for (File file : listOfDirectoryFiles) {
			System.out.println("[" + file.getParentFile() + "] " + file.getName());
		}
	}
}
