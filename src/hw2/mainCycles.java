package hw2;

public class mainCycles {

    public static void main(String[] args) {

        printTask(1);
        replace10();

        printTask(2);
        arrPull();

        printTask(3);
        arrChange62();

        printTask(4);
        arrIJ(8);

        printTask(5);
        arrMaxV();
        arrMinV();

        printTask(6);
        int[] arr1 = new int[]{3, 4, 4, 4, 0, 1, 3, 0, 2, 1};
        System.out.println(arrEqual(arr1));

        printTask(7);
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        arrShift(arr2, -3);

    }

    public static void replace10() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 2);
            System.out.printf("%-4d", arr[i]);
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        printArr(arr);
    }

    public static void arrPull() {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = 3 * i;
            System.out.print(arr[i] + " ");
        }
    }

    public static void arrChange62() {
        int[] arr = new int[10];
        for (byte i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
            System.out.printf("%-4d", arr[i]);
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        printArr(arr);
    }

    public static void arrIJ(int n) {
        //n - размерность
        if (n < 1) {
            return;
        }
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (Math.random() * 20 + 10);
                if ((i == j) || (i + j == (n - 1))) {
                    arr[i][j] = 1;
                }
            }
            printArr(arr[i]);
        }
    }

    public static void arrMaxV() {
        int maxV;
        int[] arr = new int[10];
        //maxV = arr[0]; - если так, то выведет 0 в случае создания массива,
        //состоящего только из отрицат. чисел.
        maxV = Integer.MIN_VALUE; //если float - то float вместо Integer
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20 - 30);
            if (arr[i] > maxV) {
                maxV = arr[i];
            }
        }
        printArr(arr);
        System.out.println();
        System.out.println("Макс число = " + maxV);
    }

    public static void arrMinV() {
        int minV;
        int[] arr = new int[10];
        //Тут та же ситуация, но с "+" числами
        minV = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
            if (arr[i] < minV) {
                minV = arr[i];
            }
        }
        printArr(arr);
        System.out.println();
        System.out.println("Мин число = " + minV);
    }

    public static boolean arrEqual(int[] arr) {
        int sumV = 0;
        int sumLeft;
        int sumL = 0;
        int k = 0;
        boolean flag = false;
        for (int j : arr) sumV += j; //ничего себе как можно
        if (sumV % 2 == 0) {
            sumLeft = sumV / 2;
            while (k <= arr.length - 1) {
                sumL += arr[k];
                k++;
                if (sumL == sumLeft) {
                    flag = true;
                }
            }
            printArr(arr);
        }
        return flag;
    }

    public static void arrShift(int[] arr, int shift){
        int tempV;
        int tempShift;
        tempShift = shift % arr.length + arr.length;
        printArr(arr);
        for (int i = 0; i < tempShift; i++) {
            tempV = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) arr[j] = arr[j - 1];
            arr[0] = tempV;
        }
        printArr(arr);
    }

    public static void printArr (int[] arr){
        System.out.println();
        for (int j : arr) {
            System.out.printf("%-4d", j);
        }
    }

    public static void printTask(int i){
        System.out.println();
        System.out.println("---ЗАДАНИЕ " + i + "---");
    }

}
