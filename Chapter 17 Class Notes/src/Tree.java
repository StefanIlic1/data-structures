import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    private Node root;


    static class Node
    {
        public List<Node> children;
        public Object data;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 1;

            for (Node child : this.children) {
                sum += child.size();
            }

            return sum;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<>();

    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return this.root.size();
    }

    // Additional methods will be added in later sections.
    

    /*
     * A visitor whose visit method is called for each visited node during a tree traversa
     */

    public interface Visitor {
        void visit(Object data);
    }

    /*
     * preorder traversal
     */
    public void preorder (Visitor v) {
        Tree.preorder(v, this.root);
    }

    /*
     * traverse the tree with a given root in preorder
     */
    private static void preorder (Visitor v, Node n) {
        if (n == null) {
            return;
        }

        v.visit(n.data);

        for (Node child : n.children) {
            Tree.preorder(v, child);
        }
    }


}
