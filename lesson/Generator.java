package lesson;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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

    public int getN() {
        return n;
    }

    public void enumerateLessons() {
        boolean[] numfield = createInitialNumfield();
        List<List<Integer>> paths = new ArrayList<List<Integer>>();

        enumerateLessons(numfield, paths);
    }

    public void enumerateLessons(boolean[] numfield, List<List<Integer>> paths) {
        boolean found = false;

        for (int i = 0; i < tree.getHowManyChildren(); i++) {
            Node child = tree.getChild(i);
            int childKey = child.getValue();
            if (numfield[childKey]) { // Already seen.
                continue;
            }
            for (int j = 0; j < child.getHowManyChildren(); j++) {
                Node grandchild = child.getChild(j);
                int grandchildKey = grandchild.getValue();
                int diff = childKey - grandchildKey;
                if (numfield[grandchildKey] || numfield[diff]) {
                    continue;
                }
                found = true;
                boolean[] numfieldCopy = Generator.copyNumfield(numfield);
                numfieldCopy[childKey] = true;
                numfieldCopy[grandchildKey] = true;
                numfieldCopy[diff] = true;
                List<List<Integer>> pathsCopy = Generator.copyPaths(paths);
                ArrayList<Integer> path = Generator.createCurrentPath(childKey, grandchildKey, diff);
                pathsCopy.add(path);
                enumerateLessons(numfieldCopy, pathsCopy);
            }
        }
        if (!found) {
            printPaths(paths);
        }
    }

    private void printPaths(List<List<Integer>> paths) {
        for (List<Integer> path : paths) {
            System.out.print("[");
            System.out.print(Generator.pathToString(path));
            System.out.println("]");
        }
    }
    
    private boolean[] createInitialNumfield() {
        boolean[] initialNumfield = new boolean[getN() + 1];

        return initialNumfield;
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

    private static String pathToString(List<Integer> path) {
        String joinedPath = path.stream()
            .map(Object::toString)
            .collect(Collectors.joining(", "));

        return joinedPath;
    }

    private static List<List<Integer>> copyPaths(List<List<Integer>> paths) {
        List<List<Integer>> pathsCopy = new ArrayList<List<Integer>>();
        pathsCopy.addAll(paths);

        return pathsCopy;
    }

    private static ArrayList<Integer> createCurrentPath(int childKey, int grandchildKey, int diff) {
        ArrayList<Integer> currentPath = new ArrayList<>(Arrays.asList(childKey, grandchildKey, diff));
        
        return currentPath;
    }

    private static boolean[] copyNumfield(boolean[] numfield) {
        int length = numfield.length;
        boolean[] numfieldCopy = new boolean[length];
        
        System.arraycopy(numfield, 0, numfieldCopy, 0, length);
        return numfieldCopy;
    }

}
