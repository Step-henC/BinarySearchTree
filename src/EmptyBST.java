public class EmptyBST<T extends Comparable> implements Tree<T>{


    public EmptyBST(){


    }

    public boolean isEmpty(){

        return true; //has to be true for this class
    }

    public int cardinality(){
        return 0; //if empty, then there are no members
    }

    @Override
    public boolean member(T data) {
        return false; //tree is empty so data is not in tree
    }

    @Override
    public NonEmptyBST<T> add(T data) { //this method is called on empty tree
        return new NonEmptyBST<T>(data); //tree started empty so data is only element in tree
    }
}
