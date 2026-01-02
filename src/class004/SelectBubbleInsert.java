
package class004;

public class SelectBubbleInsert {

    /**
     * @description: 交换
     * @method swap
     * @date 2026-01-02 15:56:04
     * @author Yang Naihua
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void chooseSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //后你看到循环边界，可以自问一句：
        //❓ 这个变量是
        //	•	“占位置的”（i）
        //	•	还是“扫全体的”（j）？
        //
        //	•	占位置的 → 通常 < n - 1
        //	•	扫全体的 → 通常 < n
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }


    }

    public static void insertSort() {

    }

}