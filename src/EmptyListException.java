// class for throwing an exception when node list is empty
public class EmptyListException extends RuntimeException {
    // constructor
    public EmptyListException() {
        this("List"); // call other EmptyListException constructor
    }

    // constructor
    public EmptyListException(String name) {
        super(name + " is empty"); // call superclass constructor
    }
}
