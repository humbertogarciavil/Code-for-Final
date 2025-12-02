public class MyBinarySearchTree {
    private Node root;

    public MyBinarySearchTree(int data){
        root = new Node(data);
    }

    public void add(int data){
        root = addRecursive(data, root);
    }

    public int getMin(){
        return getMinRecursive(root).data;
    }

    public String preOrderTraversal(){
        return preOrderTraversalRecursive(root);
    }


    public String inOrderTraversal(){
        return inOrderTraversalRecursive(root);
    }

    public Node delete(int value){
        return deleteRecursive(value, root);
    }

    private Node addRecursive(int data, Node current){
        if(current == null){
            current = new Node(data);
        } else {
            if(data < current.data){
                current.left = addRecursive(data, current.left);
            } else if (data > current.data){
                current.right = addRecursive(data, current.right);
            }
        }
        return current;
    }

    private Node getMinRecursive(Node current){
        if(current.left == null){
            return current;
        } else {
            return getMinRecursive(current.left);
        }
    }

    private String preOrderTraversalRecursive(Node current){
        if(current == null){
            return "";
        }else{
            return " " + current.data + preOrderTraversalRecursive(current.left) + preOrderTraversalRecursive(current.right);
        }
    }

    private String inOrderTraversalRecursive(Node current) {
        if(current == null){
            return "";
        } else {
            return inOrderTraversalRecursive(current.left) + " " + current.data + inOrderTraversalRecursive(current.right);
        }

    }
    private Node deleteRecursive(int value, Node current){
        if(current == null){
            return current;
        }

        if(value < current.data){
            current.left = deleteRecursive(value, current.left);
        }else if (value > current.data){
            current.right = deleteRecursive(value, current.right);
        }else{
            if(current.left == null){
                return current.right;
            }else if(current.right == null){
                return current.left;
            }else{
                Node successor = getMinRecursive(current.right);
                current.data = successor.data;
                current.right = deleteRecursive(successor.data, current.right);
            }
        }

        return current;
    }

}


