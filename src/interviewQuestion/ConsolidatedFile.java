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
 * @date 2018年8月3日
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
		// 创建一个File实例
		File file = new File(filename);
		// 创建一个FileReader实例
		FileReader reader = new FileReader(file);
		// 创建此文件长度的字符数组
		char[] buf = new char[(int) file.length()];
		// 将字符读入数组并返回读取的字符数
		int len = reader.read(buf);
		String results = new String(buf, 0, len);
		String regex = null;
		// 拼接正则表达式
		if (seperators.length > 1) {
			regex = "" + seperators[0] + "|" + seperators[1];
		} else {
			regex = "" + seperators[0];
		}
		// 分割字符串
		words = results.split(regex);
	}
	/**
	 * 返回下一个单词，如果没有就返回null
	 * @return
	 */
	public String nextWord() {
		if (pos == words.length) {
			return null;
		}
		return words[pos++];
	}
}
