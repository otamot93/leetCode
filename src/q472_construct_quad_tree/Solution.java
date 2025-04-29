package q472_construct_quad_tree;


class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

/**
 * 分治
 */
public class Solution {

    
    public Node construct(int[][] grid) {
        return construct(grid,0,0,grid.length-1,grid.length-1);
    }

    private Node construct(int[][] grid,int x1,int y1,int x2,int y2){
        
        if(x2 == x1){
            Node top = new Node(grid[x1][y1] == 1, true);
            return top;
        }
        // 分治
        Node topLeft = construct(grid,x1,y1,x1+(x2-x1)/2,y1+(y2-y1)/2);
        Node topRight = construct(grid,x1,y1+(y2-y1)/2+1,x1+(x2-x1)/2,y2);
        Node bottomLeft = construct(grid,x1+(x2-x1)/2+1,y1,x2,y1+(y2-y1)/2);
        Node bottomRight = construct(grid,x1+(x2-x1)/2+1,y1+(y2-y1)/2+1,x2,y2);

        // 合并
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf){
            // 是否所有的值都一样
            if(topLeft.val == true && topRight.val == true && bottomLeft.val ==true && bottomRight.val == true){
                return new Node(true,true);
            }
            if(topLeft.val == false && topRight.val == false && bottomLeft.val == false && bottomRight.val == false){
                return new Node(false,true);
            }
        }
        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        // int[][] grid = new int[][]{{0,0,0,0},{0,0,0,0},{1,1,1,1},{1,1,1,1}};
        Node root = new Solution().construct(grid);
        System.out.println(1);
    }

    
}


