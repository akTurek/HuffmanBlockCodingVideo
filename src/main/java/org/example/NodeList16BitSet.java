package org.example;

public class NodeList16BitSet {

    private Node head = null;
    private int size = 0;

    public NodeList16BitSet() {

    }

    public void incSize(){
        size += 1;
    }

    public int getSize(){
        return size;
    }

    public void insert(String biti) {
        incSize();
        if (head == null) {
            head = new Node(biti);
        } else  {
            if (head.insertNode(biti)){
                incSize();
            }
        }
    }

    public void calProb(int st8BitBlock){
        if (head != null) {
            head.calProbNode(st8BitBlock);
        }
    }

    public Node popHead() {
        if (head != null) {
            Node temp = head;
            head = head.getNext();
            return temp;
        }
        return null;
    }




}
