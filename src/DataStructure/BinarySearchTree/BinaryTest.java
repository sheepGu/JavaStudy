package DataStructure.BinarySearchTree;

public class BinaryTest {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.insert(1,33);
        System.out.println(binarySearchTree.getSize());
        binarySearchTree.insert(21,34);
        System.out.println(binarySearchTree.getSize());
        binarySearchTree.insert(222,35);
        System.out.println(binarySearchTree.getSize());
        binarySearchTree.insert(24,36);
        System.out.println(binarySearchTree.getSize());
        System.out.println(binarySearchTree.contain(222));
        binarySearchTree.perTravelsal();

    }
}
