package interviewQuestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

/**
 * Copy all the .java files in the target directory into the specified directory
 * and change the suffix name to .jad
 *
 * @author Mr.Joker
 * @date 2018年8月6日
 * 
 * Problem-solving ideas:
 */
public class Java2Jad {
	
	public static void main(String[] args) throws Exception {
		// target directory
		File srcDir = new File("E://myjava//lanqiaobei");
		if (!(srcDir.exists() && srcDir.isDirectory())) {
			throw new Exception("Error: Directory does not exist");
		}
		File[] files = srcDir.listFiles(new FilenameFilter() {
			// filter to get the file that meets the specified conditions.
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".java");
			}
		});
		
		System.out.println(files.length);
		// specified directory
		File destDir = new File("E://myjava//destDir");
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		for (File file : files) {
			FileInputStream fis = new FileInputStream(file);
			String destFileName = file.getName().replaceAll("\\.java$", ".jad");
			FileOutputStream fos = new FileOutputStream(new File(destDir,destFileName));
			copy(fis, fos);
			fis.close();
			fos.close();
		}
	}

	private static void copy(FileInputStream fis, FileOutputStream fos) throws Exception {
		// TODO Auto-generated method stub
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = fis.read(buf)) != -1) {
			fos.write(buf,0,len);
		}
	}
}
