package q904_fruits_into_baskets;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int totalFruit1(int[] fruits) {
        // 滑动窗口，用hashmap保存某一类型树的最后位置
        int result = 0;
        int i = 0;
        Map<Integer, Integer> treeIndexMap = new HashMap<>();
        for (int j = 0; j < fruits.length; j++) {
            if (treeIndexMap.size() >= 2 && !treeIndexMap.containsKey(fruits[j])) {
                // 超过了采摘的类别数量2,去除位置最远的的水果类别，i跳转到最后一次出现该水果的位置,加入新的水果
                int type = removeFruitsType(treeIndexMap);
                i = treeIndexMap.get(type) + 1;
                treeIndexMap.remove(type);
            }
            treeIndexMap.put(fruits[j], j);
            result = Integer.max(result, j - i + 1);
        }
        return result;
    }

    int removeFruitsType(Map<Integer, Integer> treeIndexMap) {
        int result = Integer.MAX_VALUE;
        int minKey = -1;
        for (Integer key : treeIndexMap.keySet()) {
            if (treeIndexMap.get(key) < result) {
                minKey = key;
                result = treeIndexMap.get(key);
            }
        }
        return minKey;
    }

    public int totalFruit(int[] fruits) {
        // 滑动窗口，使用hashmap保存窗口内各类型水果的数量，如果超过两个，则滑动左侧淘汰出新的水果位置
        int result = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        while (right < fruits.length) {
            int newValue = countMap.getOrDefault(fruits[right], 0) + 1;
            countMap.put(fruits[right], newValue);
            while (countMap.size() > 2) {
                // 滑动左侧剔除水果，某一水果数量降至0，则剔除
                int type = fruits[left];
                int count = countMap.get(type);
                if (count > 1) {
                    countMap.put(type, count - 1);
                } else {
                    countMap.remove(type);
                }
                left++;
            }

            result = Integer.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] fruits = new int[] { 1, 2, 3, 2, 2 };
        int result = new Solution().totalFruit(fruits);
        System.out.println(result);
        String s = "abc";
        s.sub
        new HashMap<>().key
    }
}
