package datastructures.traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by paulberesuita on 9/12/15.
 */
public class LevelOrder {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode (int _data) {
            data = _data;
        }
    }

    public static void levelOrderTraversal(TreeNode startNode) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(startNode);

        while (!queue.isEmpty()) {

            TreeNode tempNode = queue.poll();
            System.out.printf("%d ", tempNode.data);
            if(tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if(tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static String search(TreeNode start, TreeNode finish) {

        if (start.data == finish.data) {
            return "path exists";
        }

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(start);

        while (!q.isEmpty()) {

            TreeNode tempNode = q.poll();

            if (tempNode != null) {
                if (finish.data == tempNode.data ) {
                    System.out.printf("%d ", tempNode.data);
                    return "path exists";
                }

                if(tempNode.left != null) {
                    q.add(tempNode.left);
                }
                if(tempNode.right != null) {
                    q.add(tempNode.right);
                }
            }

        }

        return "path does not exists";
    }

    public static void preOrderRecursive(TreeNode startNode) {

        if(startNode != null) {

            System.out.printf("%d ", startNode.data);
            preOrderRecursive(startNode.left);
            preOrderRecursive(startNode.right);
        }
    }


    public static void postOrderRecursive(TreeNode startNode) {

        if(startNode != null) {

            postOrderRecursive(startNode.left);
            postOrderRecursive(startNode.right);
            System.out.printf("%d ", startNode.data);
        }
    }

    public static void preOrderIterative(TreeNode startNode) {

        if(startNode == null) {
            return;
        }

        Stack<TreeNode> stack  = new Stack<TreeNode>();
        stack.push(startNode);

        while (!stack.empty()) {

            TreeNode n = stack.pop();
            System.out.printf("%d ", n.data);

            if(n.right != null) {
                stack.push(n.right);
            }

            if(n.left != null) {
                stack.push(n.left);
            }
        }
    }

    public static void postOrderIterative(TreeNode startNode) {

        if(startNode == null) {
            return;
        }

        Stack<TreeNode> stack  = new Stack<TreeNode>();
        TreeNode current = startNode;

        while (true) {

            if (current != null) {
                if (current.right != null) {
                    stack.push(current.right);
                }
                stack.push(current);
                current = current.left;
                continue;
            }

            if (stack.isEmpty()) {
                return;
            }

            current = stack.pop();

            if (current.right != null && !stack.isEmpty() &&
                current.right == stack.peek()) {

                stack.pop();
                stack.push(current);
                current = current.right;
            } else {
                System.out.print(current.data + " ");
                current = null;
            }
        }

    }

    public static int checkHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int righHeight = checkHeight(root.right);
        if (righHeight == -1) {
            return -1;
        }

        int heightDiff = leftHeight - righHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, righHeight) + 1;
        }

    }

    public static String isBalanced(TreeNode root) {

        if (checkHeight(root) == -1) {
            return "No";
        } else {
            return "Yes";
        }
    }

    public static TreeNode createMinimalBST(int arr[], int start, int end) {

        if (end < start) {
            return null;
        }

        int mid = (start +  end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid -1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }

    public static void permutation(String prefix, String str) {

        int n = str.length();

        if (n == 0) {
            System.out.println(prefix);
        } else {

            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
            }
        }
    }

    public static TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length-1);
    }

    public static void main (String[] args) {

        LevelOrder lo = new LevelOrder();
        TreeNode rootNode = createBinaryTree();
////        levelOrderTraversal(rootNode);
//        System.out.println();
//        preOrderRecursive(rootNode);
//        System.out.println();
//        preOrderIterative(rootNode);
        System.out.println();
        permutation("", "ABC");
//        postOrderIterative(rootNode);
//        postOrderRecursive(rootNode);
//        System.out.println((float)3/2 + "");
//        System.out.println(isBalanced(rootNode));
//        System.out.println(search(rootNode, rootNode.left.left));


//
//        int[] array = new int[7];
//        array[0] = 1;
//        array[1] = 2;
//        array[2] = 3;
//        array[3] = 4;
//        array[4] = 5;
//        array[5] = 6;
//        array[6] = 7;
//
//        TreeNode rootNode = createMinimalBST(array);
//        levelOrderTraversal(rootNode);
//        System.out.println(rootNode.data);
//        System.out.println(rootNode.left.data);
//        System.out.println(rootNode.right.data);

    }

    public static TreeNode createBinaryTree() {

        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);
//
//        TreeNode node80 = new TreeNode(70);
//        TreeNode node90 = new TreeNode(70);
//        TreeNode node100 = new TreeNode(70);

        rootNode.left = node20;
        rootNode.right = node60;

//        node20.left = node10;
//        node20.right = node30;
//
//        node60.left = node50;
//        node60.right = node70;
//        node70.right = node80;
//        node80.right = node90;
//        node90.right = node100;

        return rootNode;

    }
}
