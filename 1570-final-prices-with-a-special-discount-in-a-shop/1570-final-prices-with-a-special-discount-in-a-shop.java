class Solution {
    public int[] finalPrices(int[] prices) {
        int l = 0;
        while(l < prices.length){
            int r = l + 1;
            while(r < prices.length && prices[r] > prices[l]){
                r += 1;
            }
            if(r < prices.length  && prices[r] <= prices[l]){
                prices[l] = prices[l] - prices[r];
            }
            l += 1;
        }
        return prices;
    }
}