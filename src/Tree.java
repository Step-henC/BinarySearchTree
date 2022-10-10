public interface Tree<T extends Comparable> {//trees need to compare less than or greater than thus extends

    public boolean isEmpty(); // is the tree empty?

    public int cardinality(); //returns the size of the tree if not empty

    public boolean member(T data); //we do not know what type of data in our tree so we need generics


    public NonEmptyBST<T> add(T data); // add data making tree non empty
}
