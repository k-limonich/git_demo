package epamTraining.Tasks;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class FourthTask extends FirstTask {

	public FourthTask(File file) {
		super(file);
	}

	public void sortLinesByLength(List<String> lines) {
		lines.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1.length() - o2.length());
			}
		});
	}
}
