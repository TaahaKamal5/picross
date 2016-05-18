package picross;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created on 4/12/2016 at 9:44 PM.
 */
@SuppressWarnings ("SameParameterValue")
class TextDocument {
	protected String locationStr;
	protected Scanner s;
	protected List<String> contents;
	private boolean isPrefs;
	@SuppressWarnings ("CanBeFinal")
	protected HashMap<String, String> parsedContents;

	public TextDocument(String path) throws IOException {
		isPrefs = false;
		contents = new ArrayList<>();
		parsedContents = new HashMap<>();
		locationStr = path;
		String temp;
		s = new Scanner(new File(path));
		while(s.hasNext()) {
			temp = s.nextLine();
			if(temp.length() > 1 && temp.indexOf('=') > 0)
				contents.add(temp);
		}
	}

	TextDocument() {
	}
	public String get(int pos) throws NullPointerException {
		return contents.get(pos);
	}
	public boolean has(int pos) {
		return contents.size() > pos;
	}
}