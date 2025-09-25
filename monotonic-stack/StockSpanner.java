/*Design an algorithm that collects daily price quotes for some stock and 
returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive 
days (starting from that day and going backward) for which the stock price was 
less than or equal to the price of that day.

    For example, if the prices of the stock in the last four days is [7,2,1,2]
    and the price of the stock today is 2, then the span of today is 4 because 
    starting from today, the price of the stock was less than or equal 2 for 4 
    consecutive days.
    Also, if the prices of the stock in the last four days is [7,34,1,2] and the 
    price of the stock today is 8, then the span of today is 3 because starting 
    from today, the price of the stock was less than or equal 8 for 3 consecutive days.

Implement the StockSpanner class:

    StockSpanner() Initializes the object of the class.
    int next(int price) Returns the span of the stock's price given that 
    today's price is price.
*/

//brute force - 2 nested for loops O(n^2)
//optimized - monotonic stack 

//price = {7,34, 1, 2, 8}

// int next(int price)
    //ans = 1
    //while stack not empty && price[stack.peek()[0]] < price
        //ans = ans + stack.pop()[1];
    //push to stack {price, ans}

public static class StockSpanner{
    Stack<int[]> stack;

    public StockSpanner(){
        this.stack = new Stack<>();
    }

    public int nextInt(int price){
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] < price){
            int[] topOfStack = stack.pop();
            ans = ans + topOfStack[1];
        }
        stack.push(new int {price, ans});
        return ans;
    }
   

     public static void main(String[] args) throws IOException {
        int price = 7;
        StockSpanner s = new StockSpanner();
        int ans = s.nextInt(price);
        System.out.println("ans" + ans);
        
    }
}