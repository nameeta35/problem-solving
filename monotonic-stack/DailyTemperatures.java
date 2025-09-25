import java.util.Stack;
import java.io.IOException;
/*Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is 
the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this 
is possible, keep answer[i] == 0 instead.


Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
*/

//Brute force - 2 nested for loops, once we find a next greater temperature and recording difference in indexes - O(n^2)
//Optimized

//output : [1,1, 4, 2 , 1 ,1 , 0, 0]
//[6, 7]
//while index < temperatures.length
// while (stack not empty && temperatures[stack.peek()] < current)
    //diff = index of current - stack.peek() 
    //ans[stack.peek()] = diff; //1
    //stack.pop()
//stack.push(current's index)
public class DailyTemperatures{
    public int[] dailyTemperatures(int[] temperatures){

        if (temperatures.length == 0){
            return null;
        }

        
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++){
            if (temperatures[i] < 0){
                throw new RuntimeException();
            }
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int topOfStack = stack.peek();
                int diff = i - topOfStack;
                ans[topOfStack] = diff;
                stack.pop();
            }
            stack.push(i);
            
            }
        }
        return ans;

    }

    public static void main(String[] args) throws IOException {
        int[] temperatures = {1,1, 4, 2 , 1 ,1 , 0, 0};
        dailyTemperatures(temperatures);
    }
}