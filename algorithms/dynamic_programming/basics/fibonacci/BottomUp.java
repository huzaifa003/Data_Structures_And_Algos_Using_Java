package basics.fibonacci;

/*
 * Bottom up approach is the approach where:
 * -> We try to solve smaller sub-problems first,
 * -> Use their sols to arrive on the bigger sub-problems,
 *    -> AKA Tabulation method
 *    -> The solution is build in a tabular form:
 *       -> By using solutions of smaller sub-problems ITERATIVELY,
 *       -> And generating solutions to bigger sub-problems.
 */
public class BottomUp {
    public static int fibBottomUp(int n) {
        int[] table = new int[n + 1]; //making a table for storing values of each result.
        //base cases.
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2]; //running the loop and filling the values based on previous results.
        }
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(fibBottomUp(5));
    }
}
