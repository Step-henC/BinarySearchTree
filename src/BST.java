

public class BST {

    public static void main(String[] args) throws Exception {


        //Binary Search Tree Practice

        //Trees consists of roots (parent node) and then children

        //A Heap: root has relationship but children but children have no
        //relationship with each other

        //Mini heap has smallest element at root
        //root or parent are smaller than children in mini heap but order does not matter

        //Max Heap is opposite of mini Heap with largest element as the root

        //Find children in max heap multiply parent index by child index for first child then add parent child 1 to the product to get second child

        //Use indexing to find parent
        //to get Node's parent, take index num and divide by 2

        //Binary search tree

        //children have relationships

        //left child node is less than root and right child node is greater than root
        //find parent: take index num and divide by two to get parent index
        //to find left node from root: root index * two
        //to find right node from root: root index * two + 1;


        EmptyBST e = new EmptyBST();

        NonEmptyBST n = new NonEmptyBST(5);
        Testers.checkIsEmpty(n);
        Testers.checkIsEmpty(e);
        Testers.checkAddMemberCardinality(e, 5);
        Testers.checkAddMemberCardinality(n, 5); //cardinality should stay same since one since member in there
        Testers.checkAddMemberCardinality(n, 6);

        int tests = 1000;
        for(int i=0; i<tests; i++){ //run one thousand tests at once
            Tree t;
            if(i%10==0){// every tenth interval. Completely arbitrary
                t = Testers.randomTree(0); //return EmptyBST
            }else{

                t = Testers.randomTree(10); //all trees will have ten members or be ten in length. Again, arbitrary

            }
            Testers.checkAddMemberCardinality(t, i);
        }

    }
}
