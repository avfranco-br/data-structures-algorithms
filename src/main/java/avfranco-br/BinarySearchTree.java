package avfranco_br;

public class BinarySearchTree {
    class Node {
        Node left;
        Node right;
        int value;
    }

    // top Tree Node
    private Node root;
    private int length = 0;

    // Create a new empty Node
    private Node createNode(int value) {
        Node newNode = new Node();
        newNode.left = null;
        newNode.right = null;
        newNode.value = value;
        this.length++;

        return newNode;
    }

    // Build an empty Tree and Initilises properties
    public BinarySearchTree() {
        root = null;
    }

    public Node insert(int value) {
        Node newNode;

        newNode = createNode(value);
        // Check BST is empty
        if (this.root == null) {
            this.root = newNode;
            //this.root.value = value;
        } else {
            Node holdingPointer = findNextNode(this.root, value);

            if (holdingPointer != null) {
                if (value > holdingPointer.value) {
                    //System.out.println(value + " right to " + holdingPointer.value);
                    holdingPointer.right = newNode;
                } else {
                    //System.out.println(value + " left to " + holdingPointer.value);
                    holdingPointer.left = newNode;
                }
            }
        }

        return newNode;
    }

    private Node findNextNode (Node root, int value) {
        Node pointer = root;
        if (root != null) {
            if (value > root.value) {
                pointer = (root.right == null) ? root : findNextNode(root.right, value);
            } else if (value < root.value) {
                pointer = (root.left == null) ? root : findNextNode(root.left, value);
            } else {
                return pointer;
            }
        }
        return pointer;
    }

    private Node findNode(Node root, int value) {
        Node pointer = root;

        if (pointer == null) {
            return null;
        }

        if (value > root.value) {
            pointer = findNode(root.right, value);
        } else if (value < root.value) {
            pointer = findNode(root.left, value);
        }
        return pointer;
    }


    public Node lookup(int value) {

        if (this.root.value == value) {
            return this.root;
        }

        return (findNode(this.root, value));
    }

    private Node traverse(Node node) {
        Node tree = node;

        tree.left = (node.left == null) ? null : traverse(node.left);
        tree.right = (node.right == null) ? null : traverse(node.right);

        System.out.println(tree.value);

        return tree;
    }

    public String stringfy() {
        return (traverse(this.root).toString());
    }

    public Node remove(int value) {
        Node nodeToDelete = this.root;
        Node parentToDeletedNode = this.root;
        Node parentSuccessor = this.root;

        // Empty BST?
        if (this.root == null) {
            return null;
        } else if (value == root.value && this.length == 1) {
            nodeToDelete = this.root;
            this.root = null;
            this.length = 0;
            return nodeToDelete;
        }

        // FIND nodeToDelete & parent
        while (nodeToDelete != null && this.root.value != value) {
            if (value < nodeToDelete.value) {
                if (nodeToDelete.left != null && nodeToDelete.left.value == value) {
                    parentToDeletedNode = nodeToDelete;
                    nodeToDelete = nodeToDelete.left;
                    break;
                }
                nodeToDelete = nodeToDelete.left;
            } else if (value > nodeToDelete.value) {
                if (nodeToDelete.right != null && nodeToDelete.right.value == value) {
                    parentToDeletedNode = nodeToDelete;
                    nodeToDelete = nodeToDelete.right;
                    break;
                    }
                nodeToDelete = nodeToDelete.right;
            }
        }

        // Node NOT found
        if (nodeToDelete == null) {
            return null;
        }

        // nodeToDelete is a Leaf
        if (nodeToDelete.left == null && nodeToDelete.right == null) {
            if (parentToDeletedNode.value > nodeToDelete.value) {
                parentToDeletedNode.left = null;
            } else {
                parentToDeletedNode.right =null;
            }
            return nodeToDelete;
        }

        // FIND Successor
        Node nodeSuccessor = null;

        // Successor with 1 child ONLY
        if (nodeToDelete.right == null) {
            nodeSuccessor = nodeToDelete.left;
            if (parentToDeletedNode.value > nodeToDelete.value) {
                parentToDeletedNode.left = nodeSuccessor.left;
            } else if (parentToDeletedNode.value < nodeToDelete.value) {
                parentToDeletedNode.right = nodeSuccessor.left;
            } else { // Delete Root
                this.root = nodeSuccessor;
            }
            return nodeToDelete;
        } else if (nodeToDelete.left == null) {
            nodeSuccessor = nodeToDelete.right;
            if (parentToDeletedNode.value > nodeToDelete.value) {
                parentToDeletedNode.left = nodeSuccessor.right;
            } else if (parentToDeletedNode.value < nodeToDelete.value) {
                parentToDeletedNode.right = nodeSuccessor.right;
            } else {
                this.root = nodeSuccessor;
            }
            return nodeToDelete;
        }

        // Smaller Successor
        parentSuccessor = nodeToDelete;
        nodeSuccessor = nodeToDelete.right;
        while (nodeSuccessor.left != null) {
            parentSuccessor = nodeSuccessor;
            nodeSuccessor = nodeSuccessor.left;
        }

        System.out.println("Deleted: " + nodeToDelete.value);
        System.out.println("Parent: " + parentToDeletedNode.value);
        System.out.println("Successor: " + nodeSuccessor.value);
        System.out.println("parentSuccessor: " + parentSuccessor.value);

        if (nodeToDelete.value > parentToDeletedNode.value) {
            parentToDeletedNode.right = nodeSuccessor;
            nodeSuccessor.right = null;
            nodeSuccessor.left = nodeToDelete.left;
            parentSuccessor.left = null;
        } else if (nodeToDelete.value < parentToDeletedNode.value) {
            parentToDeletedNode.left = nodeSuccessor;
            nodeSuccessor.left = nodeToDelete.left;
            nodeSuccessor.right = nodeToDelete.right;
            parentSuccessor.left = null;
        } else {
            if (this.root.value < nodeSuccessor.value) {
                nodeSuccessor.left = this.root.left;
                nodeSuccessor.right  = parentSuccessor.right;
            } else {
                nodeSuccessor.right = this.root.right;
                nodeSuccessor.left = parentSuccessor.left;
            }
            parentSuccessor.left = null;
            this.root = nodeSuccessor;
        }

        return nodeToDelete;
    }

}
