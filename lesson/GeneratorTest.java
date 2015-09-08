package lesson;

import tree.Node;
import lesson.Generator;

public class GeneratorTest {
    public static void main(String[] args) {
        Generator generator = new Generator(7);
        Node tree = generator.getTree();
        System.out.println("Successfully generated a tree:\n");
        System.out.println(tree.printAsHTML());
        testEnumeration(generator);
    }

    public static void testEnumeration(Generator generator) {
        System.out.println("About to test enumeration for generator:");
        System.out.println(generator);
        generator.enumerateLessons();
    }
}
