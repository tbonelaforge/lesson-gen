package tree;

public class Node {
    private int howManyChildren;
    private Node children[];
    int value;

    public Node(int value, int howManyChildren) {
        this.value = value;
        this.howManyChildren = howManyChildren;
        this.children = new Node[howManyChildren];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
    }

    public Node getChild(int index) {
        return children[index];
    }

    public void setChild(int index, Node newChild) {
        children[index] = newChild;
    }

    public int getHowManyChildren() {
        return howManyChildren;
    }

    public int getValue() {
        return value;
    }

    public String printAsHTML() {
        String template = "<table border=\"1\"><tr><td colspan=\"%d\"align=\"center\">%d</td></tr><tr>%s</tr></table>";
        String[] childHTMLs = this.printChildrenAsHTML();
        String childCells = "";
        String html = null;
        
        for (String childHTML : childHTMLs) {
            childCells += String.format("<td>%s</td>", childHTML);
        }
        html = String.format(template, howManyChildren, value, childCells);
        return html;
    }

    private String[] printChildrenAsHTML() {
        String childStrings[] = new String[this.getHowManyChildren()];
        Node child = null;

        for (int i = 0; i < this.getHowManyChildren(); i++) {
            child = this.getChild(i);
            if (child != null) {
                childStrings[i] = child.printAsHTML();
            } else {
                childStrings[i] = "null";
            }
        }
        return childStrings;
    }
}
