package interviewQuestion;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt中
 * a.txt文件中的单词用回车符分隔
 * b.txt文件中用回车或空格进行分隔
 *
 * @author Mr.Joker
 * @date 2018年8月6日
 * 
 * Problem-solving ideas:
 */
public class ConsolidatedFile {
	public static void main(String[] args) throws Exception {
		FileManager a = new FileManager("a.txt", new char[] {'\n'});
		FileManager b = new FileManager("b.txt", new char[] {'\n',' '});
		FileWriter cFileWriter = new FileWriter("c.txt");
		String aWord = null;
		String bWord = null;
		while ((aWord = a.nextWord()) != null) {
			cFileWriter.write(aWord + "\n");
			bWord = b.nextWord();
			if (bWord != null) {
				cFileWriter.write(bWord + "\n");
			}
		}
		while ((bWord = b.nextWord()) != null) {
			cFileWriter.write(bWord + "\n");
		}
		cFileWriter.close();
	}
}

class FileManager {
	String[] words = null;
	int pos = 0;
	public FileManager(String filename, char[] seperators) throws Exception {
		// create a File instance
		File file = new File(filename);
		// create a FileReader instance
		FileReader reader = new FileReader(file);
		// create an array of characters of the length of this file
		char[] buf = new char[(int) file.length()];
		// read characters into an array and return the number of characters read
		int len = reader.read(buf);
		String results = new String(buf, 0, len);
		String regex = null;
		// Splicing regular expression
		if (seperators.length > 1) {
			regex = "" + seperators[0] + "|" + seperators[1];
		} else {
			regex = "" + seperators[0];
		}
		// Split string
		words = results.split(regex);
	}
	/**
	 * Return to the next word, or null if not
	 * @return
	 */
	public String nextWord() {
		if (pos == words.length) {
			return null;
		}
		return words[pos++];
	}
}
