import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class firstQuestion extends RecursiveAction {
    public long count;
    int arr[], number, lo, hi;
    public firstQuestion(int[] arr, int number, int hi , int lo){
        this.arr = arr;
        this.number = number;
        this.hi = hi;
        this.lo = lo;
    }
    public long countNumberSeq(){
        for(int i = 0 ; i< arr.length; i++){
            if(arr[i]==number){
                count+=1;
            }
        }
        System.out.println("Number "+number+" count is: "+count);

        return count;
    }

    @Override
    protected void compute() {
        if (hi - lo > 1_000_000) {
            int mid = (lo + hi) / 2;
            firstQuestion left = new firstQuestion(arr, number, mid,lo);
            firstQuestion right = new firstQuestion(arr, number,  hi,mid + 1);
            left.fork();
            right.compute();
            left.join();
            count = left.count + right.count;
        } else {
            for(int i = lo; i <= hi; ++i){
                if(arr[i]==number){
                    count+=1;
                }
            }
        }
        System.out.println(count);

    }

    public void computeStreamSeq() {
       Arrays.stream(arr).forEach(x->
        {
            if(x == number)
            {
                count+=1;
            }
        });
      System.out.println(count);
    }

    public void computeStreamParallel() {
        Arrays.stream(arr).asLongStream().parallel().forEach(x->
        {
            if(x == number)
            {
                count+=1;
            }
        });
        System.out.println(count);
    }
}
