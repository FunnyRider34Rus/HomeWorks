package Lesson12;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {

        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        singleThread(arr);
        dualThread(arr);

    }

    public static float[] transform (float[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return array;
    }

    public static void singleThread(float[] arr){
        long a = System.currentTimeMillis();

        transform(arr);

        System.out.println("Время выполнения задачи в однопоточном режиме: " + (System.currentTimeMillis() - a) + " мс");
    }

    public static void dualThread(float[] arr){
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread thrOne = new singleThread(a1);
        Thread thrTwo = new singleThread(a2);

        thrOne.run();
        thrTwo.run();

        try {
            thrOne.join();
            thrTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0 , arr, 0, HALF);
        System.arraycopy(a2, 0 , arr, HALF, HALF);

        System.out.println("Время выполнения задачи в многопоточном режиме: " + (System.currentTimeMillis() - a) + " мс");

    }

    public static class singleThread extends Thread{

        private final float[] arr;

        public singleThread(float[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            transform(arr);
        }
    }
}
