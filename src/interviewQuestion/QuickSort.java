/**
 * Quick sort algorithm
 *
 * @author Mr.Joker
 * @date 2018年8月9日
 *
 * Problem-solving ideas:
 */
public class QuickSort {

    public static void main(String[] args) {
        Stirng[] strVoid = new String[] {"11", "66", "22", "0", "55", "22", "0", "32"};
        quickSort(strVoid, 0, strVoid.length - 1);
        for (int i = 0; i < strVoid.length; i++) {
            System.out.print(strVoid[i] + " ");
        }
    }

    /**
    *  quick sort
    */
    public static void quickSort(String[] strDate, int left, int right) {
        String middle, tempDate;
        int i, j;
        i = left;
        j = right;
        middle = strDate[(i+j)/2];
        do {
            while (strDate[i].compareTo(middle) < 0 && i < right) {
                // find the number on the left that is larger than the middle value.
                i++;
            }
            while (strDate[j].compareTo(middle) > 0 && j > left) {
                // find the number on the right that is larget than the middle value.
                j--;
            }
            if (i <= j) {
              tempDate = strDate[i];
              strDate[i] = strDate[j];
              strDate[j] = tempDate;
            }
        } while(i <= j)

        if (i < right) {
            quickSort(strDate, i, right);
        }
        if (j > left) {
            quickSort(strDate, left, j);
        }
    }
}
