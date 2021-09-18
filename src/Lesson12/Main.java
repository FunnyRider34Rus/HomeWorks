package Lesson12;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        float[] array = initArray();
        SingleThread thd0 = new SingleThread(array, 0);

        thd0.start();
        try{
            thd0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Время выполнения задачи в однопоточном режиме: " + (System.currentTimeMillis() - a) + " мс");

        a = System.currentTimeMillis();
        array = initArray();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(array, 0, a1, 0, HALF);
        System.arraycopy(array, HALF, a2, 0, HALF);
        SingleThread thd1 = new SingleThread(a1, 0);
        SingleThread thd2 = new SingleThread(a2, HALF);
        thd1.start();
        thd2.start();

        try{
            thd1.join();
            thd2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Время выполнения задачи в двупоточном режиме: " + (System.currentTimeMillis() - a) + " мс");

    }

    public static float[] initArray (){
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        return arr;
    }
}
