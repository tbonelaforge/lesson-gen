package tree;

public class TreeNode {
    private int _howManyChildren;
    private TreeNode _children[];
    int _value;

    public TreeNode(int value, int howManyChildren) {
        _value = value;
        _howManyChildren = howManyChildren;
        _children = new TreeNode[_howManyChildren];
        for (int i = 0; i < _children.length; i++) {
            _children[i] = null;
        }
    }

    public TreeNode getChild(int index) {
        return _children[index];
    }

    public void setChild(int index, TreeNode newChild) {
        _children[index] = newChild;
    }

    public int getHowManyChildren() {
        return _howManyChildren;
    }

    public String printAsHTML() {
        // Go through all children, calling printAsHTML, if possible
        // Go through the array of strings, surrounding each in <td>
        String template = "<table><tr><td>%d</td></tr><tr>%s</tr></table>";
        String[] childHTMLs = this.printChildrenAsHTML();
        String childCells = "";
        String html = null;
        
        for (String childHTML : childHTMLs) {
            childCells += String.format("<td>%s</td>", childHTML);
        }
        html = String.format(template, this._value, childCells);
        return html;
    }

    private String[] printChildrenAsHTML() {
        String childStrings[] = new String[this.getHowManyChildren()];
        TreeNode child = null;

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
