public class ArrayAverage implements Runnable{

    private int from;
    private int to;
    private int[] array;
    private double average;
    private int qnty = 0;
    private double sum = 0;

    private double average(int from, int to, int[] array){
      for (int i = from; i < to; i++){
          sum = sum + array[i];
          qnty++;
      }
      return average = sum/qnty;
    }

    public double getAverage(){
        return average = sum/qnty;
    }

    public ArrayAverage(int from, int to, int[] array){
        this.from = from;
        this.to = to;
        this.array = array;
    }

    @Override
    public void run() {
        average(from, to, array);
    }
}
