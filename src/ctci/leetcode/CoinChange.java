package ctci.leetcode;

public class CoinChange {

    int memo[];

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 && amount != 0)
            return -1;
        if (amount == 0)
            return 0;
        memo = new int[amount];
        //Arrays.fill(memo, -1);
        minCoins(coins, amount);
        return memo[amount - 1];
    }

    public int minCoins(int[] coins, int amount) {

        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (memo[amount - 1] != 0)
            return memo[amount - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = minCoins(coins, amount - coin);
            if (count >= 0 && count < Integer.MAX_VALUE)
                min = 1 + count;

        }
        memo[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount - 1];
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        /*[186,419,83,408]
        6249*/
        System.out.println(obj.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

}
