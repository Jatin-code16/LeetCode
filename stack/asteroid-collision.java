import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                st.push(arr[i]);
            } else {
                int el = Math.abs(arr[i]);
                // Handle collisions while the incoming negative asteroid is stronger
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < el) {
                    st.pop();
                }
                
                if (!st.isEmpty() && st.peek() == el) {
                    st.pop(); // Both destroy each other
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(arr[i]); // Incoming asteroid survives
                }
                // If st.peek() > el, the incoming asteroid is destroyed (do nothing)
            }
        }
        
        // Convert stack to array (Done AFTER the loop finishes)
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        
        return ans;
    }
}