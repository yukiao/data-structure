class BinarySearchTree{

    Node root;

    BinarySearchTree(){
        root = null;
    }

    void insert(int data){
        root = insertRecursive(root, data);
    }

    Node insertRecursive(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left = insertRecursive(root.left, data);
        }else if(data > root.data){
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    void delete(int data){
        root = deleteRecursive(root, data);
    }

    Node deleteRecursive(Node root, int data){
        if( root == null){
            return root;
        }

        if(data < root.data){
            root.left = deleteRecursive(root.left, data);
        }else if (data > root.data){
            root.right = deleteRecursive(root.right, data);
        }else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            root.data = minValue(root.right);

            root.right = deleteRecursive(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root){
        int min = root.data;
        while(root.left != null){
            min = root.left.data;
            root = root.left;
        }

        return min;
    }

    void inOrder(){
        inOrderRecursive(root);
    }

    void inOrderRecursive(Node root){
        if(root != null){
            inOrderRecursive(root.left);
            System.out.println(root.data);
            inOrderRecursive(root.right);
        }
    }

    public static void main(String args []){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inOrder();
        tree.delete(70);
        tree.delete(80);
        System.out.println();
        tree.inOrder();
    }

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
}