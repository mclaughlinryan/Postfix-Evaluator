// class representing one node in a list
class ListNode<T> {
    // package access members
    T data; // data for node
    ListNode<T> nextNode; // reference to the next node in the list

    // constructor creates a ListNode that refers to object
    ListNode(T object) {
        this(object, null);
    }

    // constructor creates ListNode that refers to the specified
    // object and to the next ListNode
    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    // return reference to node data
    T getData() {
        return data;
    }

    // return reference to next node in list
    ListNode<T> getNext() {
        return nextNode;
    }
}
