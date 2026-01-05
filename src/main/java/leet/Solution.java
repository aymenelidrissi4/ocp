package leet;

import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int subarraySum(int[] nums, int k) {
        int counter = 0;
        int sum = 0;
        map.put(0, 1);
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)){
                counter += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }

    public static void main(String[] args) {
        new Solution().subarraySum(new int[]{1,2,3},3);
    }
}