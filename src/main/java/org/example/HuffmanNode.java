package org.example;

import java.util.Comparator;

public class HuffmanNode { // node class is the basic structure
    // of each node present in the Huffman - tree.
    String bit8Block;
    float prob;

    HuffmanNode left;
    HuffmanNode right;

    public float getProb() {
        return prob;
    }

    public void setBit8Block(String bit8Block) {
        this.bit8Block = bit8Block;
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

    public String getBit8Block() {
        return bit8Block;
    }
}

