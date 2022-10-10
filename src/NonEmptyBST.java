public class NonEmptyBST<T extends Comparable> implements Tree<T>{

        T data;
        Tree<T> left; //do not know if empty or not
        Tree<T> right;
    public NonEmptyBST(T data){

        this.data = data;
        left = new EmptyBST<T>();
        right = new EmptyBST<T>();


    }
    public NonEmptyBST(T data, Tree<T> leftTree, Tree<T> rightTree){

        this.data = data;
        left = leftTree;
        right = rightTree;


    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality(); //if left or right have members then they will return 1, and children will return 1 as well
    }

    @Override
    public boolean member(T element) {

        if(this.data == element){ //the root here is the this.data. //quick check that obviously data is here if it is the root
            return true;
        } else{ //if data is not root, is it left or right?
            if(element.compareTo(data)<0){ //if less than data it must be on left node. if less than compareTo results less than zero

                return left.member(element); //return true if since element will be checked against the root in this case which is the left element

            }
            else{
                return right.member(element);
            }
        }

    }

    @Override
    public NonEmptyBST<T> add(T element) {

        if(data == element){ //if data or root is the element, then do not need to add anything
            return this;
        }else{
            if(element.compareTo(data)<0){
                return new NonEmptyBST<T>(data, left.add(element), right);
            }
            else{
                return new NonEmptyBST<>(data, left, right.add(element));//create an add'l contructor for this method
            }
        }

    }
}


