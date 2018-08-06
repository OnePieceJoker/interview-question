package interviewQuestion;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * ��a.txt�ļ��еĵ�����b.txt�ļ��еĵ��ʽ���ϲ���c.txt��
 * a.txt�ļ��еĵ����ûس����ָ�
 * b.txt�ļ����ûس���ո���зָ�
 *
 * @author Mr.Joker
 * @date 2018��8��3��
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
		// ����һ��Fileʵ��
		File file = new File(filename);
		// ����һ��FileReaderʵ��
		FileReader reader = new FileReader(file);
		// �������ļ����ȵ��ַ�����
		char[] buf = new char[(int) file.length()];
		// ���ַ��������鲢���ض�ȡ���ַ���
		int len = reader.read(buf);
		String results = new String(buf, 0, len);
		String regex = null;
		// ƴ��������ʽ
		if (seperators.length > 1) {
			regex = "" + seperators[0] + "|" + seperators[1];
		} else {
			regex = "" + seperators[0];
		}
		// �ָ��ַ���
		words = results.split(regex);
	}
	/**
	 * ������һ�����ʣ����û�оͷ���null
	 * @return
	 */
	public String nextWord() {
		if (pos == words.length) {
			return null;
		}
		return words[pos++];
	}
}
