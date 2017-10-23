import java.util.*;
import com.lnki96.Algo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        int i, j, t, temp;
        for (i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
        Algo.heapSort(arr);

        for (i = arr.length, t = 0; i-- > 0;) {
            for (j = 0; j < i; j++)
                if ((temp = arr[i] ^ arr[j]) < arr[j])
                    arr[j] = temp;
            if (arr[i] == 0)
                t++;
        }

        System.out.print(arr.length - t);
    }
}