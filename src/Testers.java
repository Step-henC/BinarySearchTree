import java.util.Random;

public class Testers {

    //test isEmpty and cardinality together. If tree is empty, cardinality must be zero

    //in our program functionality, if item is not a 'member' of tree, then we will 'add' and increase 'cardinality' by one
    //test all methods together

    public static void checkIsEmpty(Tree t) throws Exception {
        //if tree t is an instance of EmptyBST then t.isEmpty() -> true
        //otherwise tree t is an instance of NonEmptyBST and t.isEmpty is false

        if (t instanceof EmptyBST) {
            if (!t.isEmpty()) {
                throw new Exception("Uh oh. Tree is an EmptyBST BUT it is NOT EMPTY"); //great to avoid print statements
                //throwing exceptions allow us to only worry about the console if something goes wrong
            } else if (t instanceof NonEmptyBST) {
                if (t.isEmpty()) {
                    throw new Exception("Woops. Tree is a NonEmptyBST BUT it is EMPTY");
                }

            }
        }
    }

    public static void checkAddMemberCardinality(Tree t, int x) throws Exception {
        //bypassing intricacies of generics to focus on testing. Assuming tree data will be of type int

        int newTree = (t.add(x)).cardinality(); //methods are non-destructive, do not mutate trees but rather return new trees

        //either data was added and cardinality increased by one
        //or data was already there and thus, it was a member and was not added and cardinality is the same

        if (newTree == (t.cardinality() + 1)) {
            if (t.member(x)) {
                throw new Exception("cardinality increased by one but the thing added was already a member of the tree");
            } else {
                System.out.println("All is good, cardinality increased with new member added"); //just to see if it was tested
            }
        } else if (newTree == t.cardinality()) { //if cardinality stayed the same, we assume data was already a member and data added

            if (!t.member(x)) {
                throw new Exception("Cardinality should have increased since we added a new member that was not already a member of the tree");

            }else{
                System.out.println("All is good, cardinality is same with an existing member unsuccessfully added to tree as we would expect");
            }

        } else {
            throw new Exception("Something is wrong with the program"); //General blanket exception. Data added that is not a member did not increase cardinality
        }
    }

    //make random search trees. We assume trees will be ints even though comparable generics can be used

    public static int randomInt(int min, int max){
        Random rand = new Random();

        return rand.nextInt(((max-min)+1)+min); //add min to number to stay within bounds and add one since random is not inclusive

    }

    public static Tree randomTree(int count){

        if(count == 0){
            return new EmptyBST();
        }else{
            return randomTree(count -1).add(randomInt(0,50)); //minus one to recursively add. use add with hardcoded number for time being
        }


    }
}
