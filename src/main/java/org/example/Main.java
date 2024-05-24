package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*MKVfile file = new MKVfile("C:\\Users\\lukat\\Downloads\\1031108996-preview.mkv");
        file.printProb();*/

        Huffman huffman = new Huffman();
        huffman.HuffmanCodeTree();
        huffman.getArrayOfCodeWords();

    }
}