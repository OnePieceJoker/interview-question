package interviewQuestion;

/**
 * Write a function that intercepts a string, enters it as a string and the number of bytes, 
 * and outputs it as a byte-interception string, but ensures that the characters are not
 * intercepted by half.
 *
 * @author Mr.Joker
 * @date 2018年8月6日
 * 
 * Problem-solving ideas:
 */
public class SubString {
    
    public static void main(String[] args) throws Exception {
        String str = "我ABC汉";
        int num = trimGBK(str.getBytes("GBK"), 5);
        System.out.println(str.substring(0,num));
    }

    private static int trimGBK(byte[] bytes, int n) {
        // TODO Auto-generated method stub
        int num = 0;
        boolean bChineseFirstHalf = false;
        for (int i = 0; i < n; i++) {
            System.out.println(bytes[i]);
            if (bytes[i]< 0 && !bChineseFirstHalf) {
                bChineseFirstHalf = true;
            } else {
                num++;
                bChineseFirstHalf = false;
            }
        }
        System.out.println(num);
        return num;
    }
}
