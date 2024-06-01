package org.example;

import java.util.PriorityQueue;


public class Huffman {
    public HuffmanNode root= new HuffmanNode();
    public String [] ArrayOfCodeWords = new String[256];
    private MKVfile file;
    private int sizeOfBitBlock;
    private String encodedBits;
    private float expCodeWorldLenght = 0;


    public Huffman(String filePath, int sizeOfBitBlockInput) {

        if (sizeOfBitBlockInput == 8 || sizeOfBitBlockInput == 16) {
            this.sizeOfBitBlock = sizeOfBitBlockInput;
            this.ArrayOfCodeWords = new String[(int) Math.pow(2, sizeOfBitBlock)];
            this.file = new MKVfile(filePath,sizeOfBitBlock);
        } else {
            throw new Error("Size of BitBlock input must be 8 or 16");
        }


    }

    public void HuffmanCodeTree() {
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a.getProb(), b.getProb()));
        String decimalIntToBinaryString;
        float [] prob = file.getmapPBitBloke();

        for (int i = 0; i < prob.length; i++) {
            if (prob[i] > 0.0) {
                HuffmanNode hn = new HuffmanNode();
                decimalIntToBinaryString = Integer.toBinaryString(i);
                hn.setBitBlock(String.format("%"+sizeOfBitBlock+"s", decimalIntToBinaryString).replace(' ', '0'));
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
            f.setBitBlock("");
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
        if (root.left == null && root.right == null  &&  !root.getBitBlock().equals("")) {
            binaryStringToDecimalint = Integer.parseInt(root.getBitBlock().toString(), 2);
            ArrayOfCodeWords [binaryStringToDecimalint] = code;
            expCodeWorldLenght+= root.getProb()*code.length();
            //System.out.println(" bit: "+root.getBitBlock().toString()+" koda: "+code+" verjetnost; "+root.getProb());

            return;
        }

        getArrayOfCodeWordsRec(root.getRight(), code + "1");
        getArrayOfCodeWordsRec(root.getLeft(), code + "0");
    }


    public void printTree() {
        printTreeRec(root, "");
    }

    private void printTreeRec(HuffmanNode node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.getBitBlock() + " (" + node.getProb() + ")");
        printTreeRec(node.left, indent + "  ");
        printTreeRec(node.right, indent + "  ");
    }

    public void encode(){
        StringBuilder stringBuilder = new StringBuilder();
        String startbits = file.getAllBits();
        int startbitsLength = startbits.length();
        for (int i = 0; i <= startbitsLength; i+=sizeOfBitBlock) {
            if(i+sizeOfBitBlock <= startbitsLength) {
                int indexArrayOfCodeWords = Integer.parseInt(startbits.substring(i, i+sizeOfBitBlock), 2);
                stringBuilder.append(ArrayOfCodeWords[indexArrayOfCodeWords]);
                //System.out.println("beseda "+startbits.substring(i, i+sizeOfBitBlock)+" index " + indexArrayOfCodeWords + " beseda "+ArrayOfCodeWords[indexArrayOfCodeWords]);
            }

        }
        encodedBits = stringBuilder.toString();
        System.out.println("Dolzina zacetnega niza: "+startbitsLength+ " v kB: "+startbitsLength/8000);
        //System.out.println(startbits);
        System.out.println("Dolzina kodirangea niza: "+encodedBits.length()+ " v kB: "+encodedBits.length()/8000 );
        //System.out.println(encodedBits);

        System.out.println("enrotpija: "+ file.entopyX()+ " <= expectedcodewordlenght "+ expCodeWorldLenght+" <= entropija + 1 "+(file.entopyX()+1.F));
    }




}