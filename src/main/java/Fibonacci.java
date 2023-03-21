
import java.util.HashMap;
import java.util.concurrent.RecursiveTask;
/*
However, besides being a dumb way to compute Fibonacci functions (there is a simple fast linear algorithm that you'd use in practice),
 this is likely to perform poorly because the smallest subtasks are too small to be worthwhile splitting up.
 Instead, as is the case for nearly all fork/join applications,
 you'd pick some minimum granularity size (for example 10 here) for which you always sequentially solve rather than subdividing.
 */

public class Fibonacci extends RecursiveTask<Integer> {
    final int n;
    HashMap<Integer, Integer> map = new HashMap<>();
    public Fibonacci(int n) { this.n = n; }

    public Integer compute() {

        if(n > 20) {
            if (n <= 1)
                return n;
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();
        }else{
            return computeSeq();
        }

//        if(n > 20) {
//            if (n <= 1)
//                return n;
//            if(map.get(n) !=null){
//                return map.get(n);
//            }else {
//                int ress;
//                Fibonacci f1 = new Fibonacci(n - 1);
//                f1.fork();
//                Fibonacci f2 = new Fibonacci(n - 2);
//                ress =  f2.compute() + f1.join();
//                map.put(n,ress);
//                return ress;
//            } }else{
//            if(map.get(n) !=null){
//                return map.get(n);
//            }else {
//                int ress;
//                ress = computeSeq();
//
//                map.put(n,ress);
//                return ress;
//            }
//        }


    }

    public Integer computeSeq() {
        if (n <= 1)
            return n;
        if(map.get(n) !=null){
            return map.get(n);
        }else{
            int ress;
            Fibonacci f1 = new Fibonacci(n - 1);
            Fibonacci f2 = new Fibonacci(n - 2);
            ress = f2.computeSeq() + f1.computeSeq();
            map.put(n,ress);
            return ress;
        }

    }

}
