import java.util.*;

public class BinaryTree {
    Node root;
    List<Node> list = new ArrayList();

    BinaryTree() {
        init();
    }

    private class Node {
        String data;
        Node lchild;
        Node rchild;

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    '}';
        }

        public Node(String data, Node lchild, Node rchild) {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }
    }

    public void init() {
        Node x = new Node("x", null, null);
        Node y = new Node("y", null, null);
        Node d = new Node("d", x, y);
        Node e = new Node("e", null, null);
        Node f = new Node("f", null, null);
        Node c = new Node("c", e, f);
        Node b = new Node("b", d, null);
        Node a = new Node("a", b, c);
        root = a;
    }

    public void preoeder(Node node) {
        list.add(node);
        if (node.lchild != null) {
            preoeder(node.lchild);
        }
        if (node.rchild != null) {
            preoeder(node.rchild);
        }
    }

    public void inoeder(Node node) {
        if (node.lchild != null) {
            preoeder(node.lchild);
        }
        list.add(node);
        if (node.rchild != null) {
            preoeder(node.rchild);
        }
    }

    public void postoeder(Node node) {
        if (node.lchild != null) {
            preoeder(node.lchild);
        }

        if (node.rchild != null) {
            preoeder(node.rchild);
        }
        list.add(node);
    }

    public int getdeep(Node node) {
        if (node.lchild == null && node.rchild == null)
            return 1;
        int left = 0, right = 0;
        if (node.lchild != null)
            left = getdeep(node.lchild);
        if (node.rchild != null)
            right = getdeep(node.rchild);
        return left > right ? left + 1 : right + 1;
    }

    public List<Node> result() {
        return list;
    }

    public ArrayList wideprint() {
        ArrayList lists = new ArrayList();
        if (root == null) {
            return lists;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node tree = queue.poll();
            if (tree.lchild != null) {
                queue.offer(tree.lchild);
            }
            if (tree.rchild != null) {
                queue.offer(tree.rchild);
            }
            lists.add(tree.data);
        }
        return lists;
    }

    public ArrayList deepprint() {
        ArrayList lists = new ArrayList();
        if (root == null) {
            return lists;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tree = stack.pop();
            if (tree.rchild != null) {
                stack.push(tree.rchild);
            }
            if (tree.lchild != null) {
                stack.push(tree.lchild);
            }
            lists.add(tree.data);
        }
        return lists;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("根：" + binaryTree.root.toString());
        binaryTree.preoeder(binaryTree.root);
        binaryTree.inoeder(binaryTree.root);
        binaryTree.postoeder(binaryTree.root);
        for (Node node : binaryTree.result()) {
            System.out.print(node.data);
        }
        System.out.println();
        System.out.println("深度：" + binaryTree.getdeep(binaryTree.root));
        System.out.println("广度优先：" + binaryTree.wideprint());
        System.out.println("深度优先：" + binaryTree.deepprint());
    }
}
