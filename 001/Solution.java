import java.util.HashMap;
import java.util.Map;

/**
 * Finds two numbers in the array that add up to a specific target,
 * and returns their indices.
 * 
 * https://leetcode.com/problems/two-sum/
 * 
 * @param nums   the input array of integers
 * @param target the target sum we need to achieve
 * @return an array containing the indices of the two numbers
 * @throws IllegalArgumentException if no valid solution exists
 */
public int[] twoSum(int[] nums, int target) {
    // Map to store number -> its corresponding index (optimization: no need for list storage)
    Map<Integer, Integer> numToIndexMap = new HashMap<>();
    
    // One-pass traversal to complete both storage and lookup (no need for two separate loops)
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        // If complement exists in the map, return the result immediately
        if (numToIndexMap.containsKey(complement)) {
            return new int[]{numToIndexMap.get(complement), i};
        }
        // If complement does not exist, store current number and its index
        numToIndexMap.put(nums[i], i);
    }
    
    // The problem guarantees a solution exists, this is just for syntax completeness
    throw new IllegalArgumentException("No two sum solution");
}