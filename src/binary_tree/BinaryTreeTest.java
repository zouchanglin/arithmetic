package binary_tree;

public class BinaryTreeTest{
    public static void main(String[] args) {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        binaryTree.insertNonRecursion(15, "AAA");
        binaryTree.insertNonRecursion(11, "BBB");
        binaryTree.insertNonRecursion(17, "CCC");
        binaryTree.insertNonRecursion(8, "DDD");
        binaryTree.insertNonRecursion(12, "EEE");
        System.out.println("size = " + binaryTree.size());
        System.out.println("isEmpty = " + binaryTree.isEmpty());
    }
}