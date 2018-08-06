package interviewQuestion;
/**
 * The number of English characters, the number of Chinese characters, 
 * and the number of numeric characters are separately counted, assuming
 * that there are no special characters other than Chinese characters, 
 * English characters, and numeric characters.
 *
 * @author Mr.Joker
 * @date 2018年8月6日
 * 
 * Problem-solving ideas:
 */
public class PrintCount {
    public static void main(String[] args) {
        String str = "aaaabbbbccc中国970614";
        int englishCount = 0;
        int chineseCount = 0;
        int digitCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                digitCount++;
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                englishCount++;
            } else {
                chineseCount++; 
            }
        }
        System.out.println("The number of english characters is " + englishCount);
        System.out.println("The number of chinese characters is " + chineseCount);
        System.out.println("The number of numeric is " + digitCount);
    }
}
