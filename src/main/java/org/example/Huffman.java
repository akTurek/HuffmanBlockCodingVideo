package org.example;

import java.util.PriorityQueue;


public class Huffman {
    public MKVfile video = new MKVfile("C:\\Users\\lukat\\Downloads\\1031108996-preview.mkv");
    public HuffmanNode root= new HuffmanNode();
    public String [] ArrayOfCodeWords = new String[256];

    public void HuffmanCodeTree() {
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a.getProb(), b.getProb()));
        String decimalIntToBinaryString;
        MKVfile file = new MKVfile("C:\\Users\\lukat\\Downloads\\1031108996-preview.mkv");
        float [] prob = file.getMapP8BitBloke();
        for (int i = 0; i < prob.length; i++) {
            if (prob[i] > 0.0) {
                HuffmanNode hn = new HuffmanNode();
                decimalIntToBinaryString = Integer.toBinaryString(i);
                hn.setBit8Block(String.format("%8s", decimalIntToBinaryString).replace(' ', '0'));
                hn.setProb(prob[i]);
                minHeap.add(hn);
            }
        }


        while (minHeap.size() > 1) {

            // first min extract.
            HuffmanNode x = minHeap.peek();
            minHeap.poll();

            // second min extract.
            HuffmanNode y = minHeap.peek();
            minHeap.poll();

            // new node f which is equal
            HuffmanNode f = new HuffmanNode();

            // to the sum of the frequency of the two nodes
            // assigning values to the f node.
            f.setProb(x.getProb()+ y.getProb());
            f.setBit8Block("");
            // first extracted node as left child.
            f.left = x;
            // second extracted node as the right child.
            f.right = y;


            root = f;

            // add this node to the priority-queue.
            minHeap.add(f);
        }

    }

    public void getArrayOfCodeWords(){
        getArrayOfCodeWordsRec(root, "");
    }

    public void getArrayOfCodeWordsRec(HuffmanNode root, String code) {
        int binaryStringToDecimalint;
        if (root.left == null && root.right == null) {
            binaryStringToDecimalint = Integer.parseInt(root.getBit8Block().toString(), 2);
            ArrayOfCodeWords [binaryStringToDecimalint] = code;
            System.out.println("bit: "+root.getBit8Block().toString()+" koda: "+code+" verjetnost; "+root.getProb());
            return;
        }

        getArrayOfCodeWordsRec(root.getLeft(), code + "0");
        getArrayOfCodeWordsRec(root.getRight(), code + "1");
    }
}