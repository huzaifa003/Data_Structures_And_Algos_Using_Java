package basics.fibonacci;

/*
 * We break large problem into multiple sub-problems.
 * Each of the sub-problems are solved and solutions are remembered.
 * -> If the sub-problem is solved already, reuse the answer
 * -> Else solve the sub-problem and store the result
 * Hence it memorizes the solution of the sub-problem to avoid recomputing value.
 *
 * It is also called Memoization
 * It uses a recursive approach. instead of iterative in BottomUp.
 */
public class TopDown {
    public static int fib(int[] memo, int n) {
        if (memo[n] == 0) {
            if (n < 2) {
                memo[n] = n; //Base Approach
            } else {
                memo[n] = fib(memo, n - 1) + fib(memo, n - 2); //recursive function
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(new int[5 + 1], 5));
        System.out.println(fib(new int[1], 0));
    }

}
