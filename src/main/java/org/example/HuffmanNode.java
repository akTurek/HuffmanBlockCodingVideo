package org.example;

public class HuffmanNode { // node class is the basic structure
    // of each node present in the Huffman - tree.
    String bitBlock;
    float prob;

    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(String bitBlock, float prob) {
        this.bitBlock = bitBlock;
        this.prob = prob;
    }
    public HuffmanNode() {

    }

    public float getProb() {
        return prob;
    }

    public void setBitBlock(String bitBlock) {
        this.bitBlock = bitBlock;
    }

    public void setProb(float prob) {
        this.prob = prob;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public String getBitBlock() {
        return bitBlock;
    }
}

