import tree.TreeNode;

public class TreeNodeTester {
    public static void main(String args[]) {
        int value = 1;
        int numChildren = 5;
        TreeNode tree = new TreeNode(value, numChildren);
        System.out.println("After constructing a new tree node, the children are:\n");
        for (int i = 0; i < tree.getHowManyChildren(); i++) {
            System.out.println(tree.getChild(i));
        }
        System.out.println("Made it past the children loop\n");
        System.out.println("Printing the tree as HTML gives:\n");
        System.out.println(tree.printAsHTML());
    }
}
