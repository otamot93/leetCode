package q71_simply_path;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/19 16:02
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    /***
     * 使用/分割字符串，分别处理出现的文件夹、 .. 、 . 、空字符串
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        // 保存有效路径
        Deque<String> pathQueue = new ArrayDeque<>();

        for (int i = 0; i < split.length; i++) {
            if ("".equals(split[i]) || ".".equals(split[i])){
                continue;
            }
            if("..".equals(split[i])){
                if(pathQueue.size() > 0){
                    pathQueue.pop();
                }
                continue;
            }
            pathQueue.push(split[i]);
        }

        if(pathQueue.size() == 0){
            return "/";
        }

        // 构建新的路径,栈顶是末尾的文件夹
        StringBuilder newPathBuilder = new StringBuilder();
        while(pathQueue.size() >0){
            newPathBuilder.insert(0,"/"+pathQueue.pop());
        }

        return newPathBuilder.toString();

    }

    public static void main(String[] args) {
        String originPath = "/../";

        String simplePath = new Solution().simplifyPath(originPath);
        System.out.println(simplePath);
    }
}
