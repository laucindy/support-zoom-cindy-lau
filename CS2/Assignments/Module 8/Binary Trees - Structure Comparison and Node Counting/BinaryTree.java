import java.util.ArrayList;

public class BinaryTree 
{
    private String     data;
    private BinaryTree leftChild;
    private BinaryTree rightChild;
    
    // A constructor that takes root data only and
    // makes a tree with no children (i.e., a leaf)
    public BinaryTree(String d) 
    {
        data = d;
        leftChild = null;
        rightChild = null;
    }
    
    // A constructor that takes root data as well as two subtrees
    // which then become children to this new larger tree.
    public BinaryTree(String d, BinaryTree left, BinaryTree right)
    {
        data = d;
        leftChild = left;
        rightChild = right;
    }
    
    // Get methods
    public String getData() { return data; }
    public BinaryTree getLeftChild() { return leftChild; }
    public BinaryTree getRightChild() { return rightChild; }
    
    // Set methods
    public void setData(String d) { data = d; }
    public void setLeftChild(BinaryTree left) { leftChild = left; }
    public void setRightChild(BinaryTree right) { rightChild = right; }

    /**
     * Check that the current instance of the binary tree is the same as a specific tree
     * It is the same if they have exactly the same structure, data at each node, and left and right children
     * @param tree - the binary tree to compare the current instance with
     * @return - true if the trees are exactly the same, false otherwise
     */
    public boolean hasSameContentsAs(BinaryTree tree) {
      // check whether this binary tree, and the tree to compare this instance with, has children nodes
      boolean thisHasAtLeastOneChildNode = (this.leftChild != null) || (this.rightChild != null);
      boolean otherHasAtLeastOneChildNode = (tree.leftChild != null) || (tree.rightChild != null);

      // base case: check that there are no children nodes, and that the data at the current node is the same
      if ((this.data == tree.data) && !thisHasAtLeastOneChildNode && !otherHasAtLeastOneChildNode) {
        return true;
      }

      // recursive case: check whether the current node has a left and/or right child node(s)
      boolean thisHasLeftChildNodeOnly = (this.leftChild != null) && (this.rightChild == null);
      boolean thisHasRightChildNodeOnly = (this.leftChild == null) && (this.rightChild != null);
      boolean thisHasBothChildNodes = (this.leftChild != null) && (this.rightChild != null);

      boolean otherHasLeftChildNodeOnly = (tree.leftChild != null) && (tree.rightChild == null);
      boolean otherHasRightChildNodeOnly = (tree.leftChild == null) && (tree.rightChild != null);
      boolean otherHasBothChildNodes = (tree.leftChild != null) && (tree.rightChild != null);

      // check that the contents of the child node(s) are the same in both trees
      if (thisHasLeftChildNodeOnly && otherHasLeftChildNodeOnly) {
        return this.leftChild.hasSameContentsAs(tree.leftChild);
      } else if (thisHasRightChildNodeOnly && otherHasRightChildNodeOnly) {
        return this.rightChild.hasSameContentsAs(tree.rightChild);
      } else if (thisHasBothChildNodes && otherHasBothChildNodes) {
        return this.leftChild.hasSameContentsAs(tree.leftChild) && this.rightChild.hasSameContentsAs(tree.rightChild);
      }

      return false;
    }
    
    /**
     * Get the total number of nodes in the binary tree, and return the number
     * @return - the number of nodes in the tree
     */
    public int numberOfNodes() {
      // tree is empty: no nodes
      if (this.data == null) {
        return 0;
      }

      // base case: no children nodes
      if ((this.leftChild == null) && (this.rightChild == null)) {
        return 1;
      }

      // recursive case: check number of nodes on left side and right side
      int nodes = 1;

      if (this.leftChild != null) {
        nodes += this.leftChild.numberOfNodes();
      }

      if (this.rightChild != null) {
        nodes += this.rightChild.numberOfNodes();
      }

      return nodes;
    }
    
    // Return the height of the tree
    public int height()  
    {
        // Base case: if there are no more children, return 1
        if (leftChild == null && rightChild == null)
        {
            return 1;
        }
        
        // Recursive case: one or neither child is null
        if (leftChild == null)
        {
            return 1 + rightChild.height();
        }
        else if (rightChild == null)
        {
            return 1 + leftChild.height();
        }
        else
        {
            return 1 + Math.max(leftChild.height(),
                                rightChild.height());
        }
    }
    
    
    // Return all the leaves of the tree
    public ArrayList<String> leafData()  
    {
        ArrayList<String> result = new ArrayList<String>();
        
        if (data != null) 
        {
            // Base case: check if the current tree is a leaf, and if so,
            // add the data
            if ((leftChild == null) && (rightChild == null))
            {
                result.add(data);
            }
        }
        
        // Recursive case: collect the leaves of the children and add them
        if (leftChild != null)
        {
            result.addAll(leftChild.leafData());
        }
        if (rightChild != null)
        {
            result.addAll(rightChild.leafData());
        }
        
        // Return all the leaves part of this tree
        return result;
    }
}