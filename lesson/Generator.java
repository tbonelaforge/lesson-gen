package lesson;

import tree.Node;

public class Generator {
    private int n;
    private Node tree;

    public Generator(int n) {
        this.n = n;
        this.tree = buildTree();
    }

    public Node getTree() {
        return tree;
    }

    private Node buildTree() {
        int howManyChildren = Math.max(n - 2, 0);
        Node tree = new Node(0, howManyChildren);
        Node child = null;
        Node grandChild = null;
        int howManyGrandChildren = 0;
        int childValue = 0;

        for (int i = 0; i < howManyChildren; i++) {
            childValue = i + 3;
            howManyGrandChildren = (childValue - 1) / 2;
            child = new Node(childValue, howManyGrandChildren);
            for (int j = 0; j < howManyGrandChildren; j++) {
                grandChild = new Node(j + 1, 0);
                child.setChild(j, grandChild);
            }
            tree.setChild(i, child);
        }
        return tree;
    }
}
