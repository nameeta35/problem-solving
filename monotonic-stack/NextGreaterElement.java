class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    
        int[] ans = new int[nums1.length];
    
        //traverse nums1
        for (int i = 0; i < nums1.length; i++){
            if (map.containsKey(nums1[i])){
                ans[i] = map.get(nums1[i]);      
            } else {
                ans[i] = -1;
            }          
        }

        return ans;
    }

    public void nextGreaterElement(int[] nums2){
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int previousIndex = -1;
    //1,3,4,2,5
        
        //1, 3

        while (index < nums2.length){
            while (!stack.isEmpty() && stack.peek() < nums2[index]){
                int smallerElement = stack.peek(); //4
                    map.put(smallerElement, nums2[index]); //1 -> 3, 3 -> 4, 2 -> 5, 4 -> 5
                    stack.pop(); //4
            
            }
            stack.push(nums2[index]); //5
            //map.put(nums2[index], -1); //4 -> -1, 2 -> -1, 5 -> -1
            index++;
        }
    }
           

        
        //next greater element(low, high)
         //stack
         //traverse from low to high
            //if not empty && stack.peek() < current, current is next greater
            //push to stack 
        //return -1
    
}