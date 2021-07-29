package epamTraining.Tasks;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SixthTask extends FirstTask {

	public SixthTask(File file) {
		super(file);
	}

	public void sortLinesByAlphabet(List<String> lines) {
		Collections.sort(lines, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1.charAt(0) - o2.charAt(0));
			}
		});
	}
}
