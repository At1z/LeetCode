/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int top = 0;
        int bottom = m;
        int left = 0;
        int rigth = n;
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }
        
        while (head != null) {

            for (int i = left; i < rigth; i++) {
                if (head == null) {
                    return grid;  
                } else {
                    grid[top][i] = head.val;  
                    head = head.next;         
                }
            }
            top += 1;
            for(int i = top; i < bottom; i++){
                if (head == null) {
                    return grid; 
                } else {
                    grid[i][rigth-1] = head.val;  
                    head = head.next;         
                }
            }
            rigth -= 1;
            for (int i = rigth-1; i > left-1; i--) {
                if (head == null) {
                    return grid; 
                } else {
                    grid[bottom-1][i] = head.val;  
                    head = head.next;         
                } 
            }
            bottom -= 1;
            for (int i = bottom-1; i > top-1; i--) {
                if (head == null) {
                    return grid;  
                } else {
                    grid[i][left] = head.val;  
                    head = head.next;         
                }
            }
            left += 1;
        }

        return grid;
    }
}

