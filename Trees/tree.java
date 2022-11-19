package Trees;

public class tree {
    
    static private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static private class trees {

        static int idx = -1;

        TreeNode buildTree(int[] arr) {
            idx++;

            if (arr[idx] == -1)
                return null;

            TreeNode node = new TreeNode(arr[idx]);

            node.left = buildTree(arr);
            node.right = buildTree(arr);

            return node;
        }

        void inOrder(TreeNode rNode) {
            if (rNode == null) {
                return;
            }

            inOrder(rNode.left);
            System.out.println(rNode.data);
            inOrder(rNode.right);

        }

        void preOrder(TreeNode root) {
            if (root == null)
                return;

            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    public static void main(String[] args) {

        int[] arr = { 13, 12, 4, -1, -1, 19, -1, -1, 10, 16, -1, -1, 9, -1, -1 };
        trees tr = new trees();

        TreeNode root = tr.buildTree(arr);
        // tr.inOrder(root);
        tr.preOrder(root);
    }
}
