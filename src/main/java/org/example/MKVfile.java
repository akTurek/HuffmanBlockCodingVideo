package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class MKVfile {


    private byte [] bytes;
    private float [] mapF8BitBloke = new float[256];
    private float [] mapP8BitBloke = new float[256];
    private int st8bitBloke;

    public MKVfile(String filePath) {
        this.bytes = mkvFileToBits(filePath);
        mapF8Bits();
        mapP8Bits();

    }

    public float[] getMapF8BitBloke() {
        return mapF8BitBloke;
    }

    public float[] getMapP8BitBloke() {
        return mapP8BitBloke;
    }

    public byte [] mkvFileToBits (String filePath){
        try {
            // Pretvorba poti v objekt razreda Path
            Path path = Paths.get(filePath);

            // Branje vsebine datoteke v byte array
            bytes = Files.readAllBytes(path);

            System.out.println("MKV datoteka uspešno prebrana v byte array.");
        } catch (IOException e) {
            System.err.println("Napaka pri branju datoteke: " + e.getMessage());
            e.printStackTrace();
        }
        st8bitBloke = bytes.length;
        return bytes;
    }

    public void mapF8Bits(){
        StringBuilder stringBuilder = new StringBuilder();
        NodeList16BitSet list = new NodeList16BitSet();
        for(int i = 0; i < bytes.length; i++){
            stringBuilder.append(String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0'));
            int stevilo = Integer.parseInt(stringBuilder.toString(), 2);
            mapF8BitBloke[stevilo] += 1;
            stringBuilder.setLength(0);
        }

    }

    public void mapP8Bits(){
        for(int i = 0; i < 256; i++) {
            mapP8BitBloke[i] = mapF8BitBloke[i] / st8bitBloke;
        }
    }

    public void printProb(){
        for(int i = 0; i < 256; i++) {
            System.out.println(mapP8BitBloke[i]);
        }
    }

    public void printFrek(){
        for(int i = 0; i < 256; i++) {
            System.out.println(mapF8BitBloke[i]);
        }
    }




}
