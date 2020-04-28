package binary_tree;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int count;

    class Node{
        Key key;
        Value value;
        Node left;
        Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    public BinaryTree() {
        this.root = null;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    // insert递归写法
    public void insert(Key key, Value value){
        root = insertChild(root, key, value);
    }

    // insert非递归写法
    public void insertNonRecursion(Key key, Value value){
        if(root == null){
            count++;
            root = new Node(key, value);
        }else{
            Node tmp = root;
            while(true){
                if(tmp.key.compareTo(key) == 0){
                    tmp.value = value;
                }else if(key.compareTo(tmp.key) < 0){
                    if(tmp.left == null){
                        count++;
                        tmp.left = new Node(key, value);
                        return;
                    }
                    tmp = tmp.left;
                }else{
                    if(tmp.right == null){
                        count++;
                        tmp.right = new Node(key, value);
                        return;
                    }
                    tmp = tmp.right;
                }
            }
        }
    }

    // 向以node为根的二叉搜索树中，插入节点(key, value)
    // 返回插入新节点的二叉搜索树的根
    private Node insertChild(Node node, Key key, Value value) {
        if(node == null){
            count++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key) == 0){
            node.value = value;
        }else if(key.compareTo(node.key) < 0){
            node.left = insertChild(node.left, key, value);
        }else{
            node.right = insertChild(node.right, key, value);
        }
        return node;
    }
}