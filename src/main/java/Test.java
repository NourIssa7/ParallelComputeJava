import java.util.Random;

public class Test {

        public static void main( String args[] ) {


            // **************** first Question Test ****************** //

//            int size = 1000000000;
//            int arr[] = new int[size];
//            Random random = new Random();
//            int rand = 0;
//            for (int i = 0; i < arr.length; i++) {
//                while (true) {
//                    rand = random.nextInt(100000);
//                    if (rand != 0)
//                        break;
//                }
//                arr[i] = rand;
//
//
//            }
//            firstQuestion firstq = new firstQuestion(arr, 3,arr.length - 1, 0 );
//            long start = System.currentTimeMillis();
//            firstq.compute();
//            System.out.println("campo");
//            firstq.countNumberSeq();
//            System.out.println("campo");
//            firstq.computeStreamSeq();
//            System.out.println("campo");
//            firstq.computeStreamParallel();
//
//            long execTime = System.currentTimeMillis() - start;
//            System.out.println("Execution Time: " + execTime + " ms");

            // **************** Third Question Test ****************** //
            Fibonacci f = new Fibonacci(40);
            long start = System.currentTimeMillis();
//            int fib = f.computeSeq();
            int fib = f.compute();
            System.out.println(fib);
            long execTime = System.currentTimeMillis() - start;
            System.out.println("Execution Time: " + execTime + " ms");




        }
}
