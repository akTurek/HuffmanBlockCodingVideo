package org.example;

public class Node {
    private String biti;
    private int freq;
    private Node next;
    private float prob;

    public Node(String biti) {
        this.biti = biti;
        this.freq = 1;
        this.next = null;
    }

    public void setBiti(String biti) {
        this.biti = biti;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public float getProb() {
        return prob;
    }

    public void setProb(float prob) {
        this.prob = prob;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getBiti() {
        return biti;
    }

    public void incrDepth() {
        this.freq++;
    }

    public boolean insertNode(String biti) {
        if (this.getBiti().equals(biti)) {
            this.incrDepth();
            return false;
        } else if (this.getNext() != null) {
            this.getNext().insertNode(biti);
        } else {
            this.setNext(new Node(biti));
            return true;
        }
        return false;
    }

    public void calProbNode(int st8BitBlock){
        while (this.getNext() != null) {
            this.setProb(freq/st8BitBlock);
        }
    }

   
}
