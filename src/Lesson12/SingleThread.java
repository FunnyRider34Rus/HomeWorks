package Lesson12;

public class SingleThread extends Thread{

    private float[] arr;
    private float[] array;
    private int startIndex;

    public SingleThread(float[] array, int startIndex) {
        this.startIndex = startIndex;
        this.array = array;
    }

    public float[] getArr() {
        return this.array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + startIndex / 5) * Math.cos(0.2f + startIndex / 5) * Math.cos(0.4f + startIndex / 2));
        }
    }
}
