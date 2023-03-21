import java.util.Random;

public class TestFirstQuestion {

        public static void main( String args[] ) {
            int size = 1000000000;
            int arr[] = new int[size];
            Random random = new Random();
            int rand = 0;
            for (int i = 0; i < arr.length; i++) {
                while (true) {
                    rand = random.nextInt(100000);
                    if (rand != 0)
                        break;
                }
                arr[i] = rand;


        }
            firstQuestion firstq = new firstQuestion(arr, 3,arr.length - 1, 0 );
            long start = System.currentTimeMillis();
//            firstq.compute();
//            firstq.countNumberSeq();
//            firstq.computeStreamSeq();
            firstq.computeStreamParallel();

            long execTime = System.currentTimeMillis() - start;
            System.out.println("Execution Time: " + execTime + " ms");


        }
}
