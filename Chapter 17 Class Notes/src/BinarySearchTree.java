/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {   
        this.root = null;
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    {   
        Node newNode = new Node();
        newNode.data = obj;
        
        if (root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
    }

    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)
    {
        Node current = this.root;
        
        while (current != null) {
            if (obj.compareTo(current.data) == 0) {
                return true;
            } else if (obj.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        if (!this.find(obj)) {
            return;
        }

        Node toRemove = this.root;
        Node parent = null;
        boolean found = false;

        while (!found && toRemove!=null) {
            int diff = obj.compareTo(toRemove.data);
            if (diff == 0) {
                found = true;
            } else {
                parent = toRemove;
                if (diff < 0) {
                    toRemove = toRemove.left;
                } else {
                    toRemove = toRemove.right;
                }
            }
        }

        if (toRemove.left == null && toRemove.right == null) {
            toRemove = null;
            return;
        } else if (toRemove.left == null || toRemove.right == null) {
            Node newChild;
            if (toRemove.left == null) {
                newChild = toRemove.right;
            } else {
                newChild = toRemove.left;
            }

            if (parent == null) {
                this.root = newChild;
            } else if (parent.left == toRemove) {
                parent.left = newChild;
            } else {
                parent.right = newChild;
            }

            return;
        } else {
            Node leastParent = toRemove;
            Node least = toRemove.right;

            while (least.left != null) {
                leastParent = least;
                least = least.left;
            }

            toRemove.data = least.data;
            
            if (leastParent == toRemove) {
                leastParent.right = least.right;
            } else {
                leastParent.left = least.right;
            }

            return;
        }
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {   
        public Comparable data;
        public Node left, right;

        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   
            if (newNode.data.compareTo(this.data) < 0) {
                if (this.left == null) {
                    this.left = newNode;
                } else {
                    this.left.addNode(newNode);
                }
            } else if (newNode.data.compareTo(this.data) > 0) {
                if (this.right == null) {
                    this.right = newNode;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }
    }
}



