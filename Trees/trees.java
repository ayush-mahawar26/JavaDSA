package Trees;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.QueryEval;

public class trees {

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static private class Trees {
        int idx = -1;

        Node buildTree(int[] node) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node n = new Node(node[idx]);

            n.left = buildTree(node);
            n.right = buildTree(node);

            return n;
        }

        void preOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);

        }

        void inOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }

        void postOrdertraversal(Node root) {
            if (root == null)
                return;

            postOrdertraversal(root.left);
            postOrdertraversal(root.right);
            System.out.print(root.val + " ");
        }

        void bfs(Node root) {
            Queue<Node> queue = new LinkedList<>();

            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {
                Node front = queue.poll();

                if (front == null) {
                    System.out.println();
                    if (queue.isEmpty())
                        break;
                    else
                        queue.add(null);
                } else {
                    System.out.print(front.val + " ");
                    Node lc = front.left;
                    Node rc = front.right;
                    if (lc != null)
                        queue.add(lc);
                    if (rc != null)
                        queue.add(rc);

                }

            }
        }

        int countNode(Node root) {
            if (root == null)
                return 0;

            int leftCount = countNode(root.left);
            int rightCount = countNode(root.right);

            return leftCount + rightCount + 1;
        }

    }

    public static void main(String[] args) {

        int node[] = { 1, 2, 3, 5, -1, -1, 6, -1, -1, 4, -1, -1, 7, 9, -1, -1, 8, -1, -1 };

        Trees tree = new Trees();
        // System.out.println(tree.buildTree(node).val);
        Node root = tree.buildTree(node);
        // tree.preOrderTraversal(root);
        // tree.postOrdertraversal(root);
        // tree.bfs(root);
        // System.out.println(tree.countNode(root));
        System.out.println("myNons");

    }
}
