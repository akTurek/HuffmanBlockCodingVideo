package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Huffman huffman = new Huffman("C:\\Users\\lukat\\Downloads\\Asian Woman Not Scared of Iron Man but Black Guy (1).mkv",16);
        huffman.HuffmanCodeTree();
        huffman.getArrayOfCodeWords();
        huffman.encode();




    }
}