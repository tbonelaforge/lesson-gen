public class LessonGeneratorTest {
    public static void main(String args[]) {
        LessonGenerator lessonGenerator = new LessonGenerator(7);
        TreeNode lessonTree = lessonGenerator.getTree();
        System.out.println("Successfully generated a tree:\n");
        System.out.println(lessonTree.printAsHTML());
    }
}
