import tree.TreeNode;

public class LessonGenerator {
    private int _max;
    private TreeNode _tree;

    public LessonGenerator(int n) {
        _n = n;
        _tree = this.buildTree();
    }

    public TreeNode getTree() {
        return _tree;
    }

    private TreeNode buildTree() {
        int howManyChildren = Math.max(_n - 2, 0);
        TreeNode tree = new TreeNode(0, howManyChildren);
        TreeNode child = null;
        TreeNode grandChild = null;
        int howManyGrandChildren = 0;
        int childValue = 0;

        for (int i = 0; i < howManyChildren; i++) {
            childValue = i + 3;
            howManyGrandChildren = (childValue - 1) / 2;
            child = new TreeNode(childValue, howManyGrandChildren);
            for (int j = 0; j < howManyGrandChildren; j++) {
                grandChild = new TreeNode(j + 1, 0);
                child.setChild(j, grandChild);
            }
            tree.setChild(i, child);
        }
        return tree;
    }
}
