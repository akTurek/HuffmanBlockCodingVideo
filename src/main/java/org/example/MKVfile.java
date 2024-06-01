package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MKVfile {

    private byte [] bytes;
    private String allBits;
    private float [] mapFBitBloke;
    private float [] mapPBitBloke;
    private int stBitBloke = 0;
    private int sizeOfBitBloke;


    public MKVfile(String filePath, int sizeOfBitBlock) {
        this.bytes = mkvFileToBits(filePath);
        this.allBits = bytesToBits();
        this.mapFBitBloke = new float[(int) Math.pow(2,sizeOfBitBlock)];
        this.mapPBitBloke = new float[(int) Math.pow(2,sizeOfBitBlock)];
        this.sizeOfBitBloke = sizeOfBitBlock;
        mapFBits();
        mapPBits();

    }

    public String getAllBits() {
        return allBits;
    }

    public float[] getmapFBitBloke() {
        return mapFBitBloke;
    }

    public float[] getmapPBitBloke() {
        return mapPBitBloke;
    }

    public byte [] mkvFileToBits (String filePath){  //array bytev
        try {
            // Pretvorba poti v objekt razreda Path
            Path path = Paths.get(filePath);

            // Branje vsebine datoteke v byte array
            bytes = Files.readAllBytes(path);

            //System.out.println("MKV datoteka uspešno prebrana v byte array.");
        } catch (IOException e) {
            System.err.println("Napaka pri branju datoteke: " + e.getMessage());
            e.printStackTrace();
        }
        return bytes;
    }

    public String bytesToBits() {      // string vseh bitov
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            String binaryString = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            stringBuilder.append(binaryString);
        }
        return stringBuilder.toString();
    }





    public void mapFBits(){
        StringBuilder stringBuilder = new StringBuilder();
        int lenght = allBits.length();
        for(int i = 0; i < lenght; i+= sizeOfBitBloke){
            if(i+sizeOfBitBloke <= lenght) {
                stringBuilder.append(allBits.substring(i, i + sizeOfBitBloke ));
                int stevilo = Integer.parseInt(stringBuilder.toString(), 2);
                mapFBitBloke[stevilo] += 1;
                //System.out.println(stringBuilder.toString());
                stringBuilder.setLength(0);
                stBitBloke++;
            } else {
                stringBuilder.append("00000000");
                stringBuilder.append(allBits.substring(i, i + 8 ));
            }
        }
        System.out.println("Stevilo vseh bit blokov je: "+stBitBloke);
        //System.out.println("Stevilo bytov je: "+bytes.length);

    }

    public void mapPBits(){
        double pow = Math.pow(2, sizeOfBitBloke);
        int lenght = (int) pow;
        for(int i = 0; i < lenght; i++) {
            mapPBitBloke[i] = mapFBitBloke[i] / stBitBloke;
        }
    }

    public void printProb(){
        for(int i = 0; i < 256; i++) {

            System.out.println(mapPBitBloke[i]);
        }
    }

    public void printFrek(){
        for(int i = 0; i < 256; i++) {
            System.out.println(mapFBitBloke[i]);
        }
    }

    public float entopyX(){
        float  H = 0;

        for(int i = 0; i < mapPBitBloke.length; i++) {
            if (mapPBitBloke[i] > 0) {
                float zacasno = 1 / mapPBitBloke[i];
                H+= mapPBitBloke[i] * Math.log(zacasno) / Math.log(2);
                //System.out.println(mapPBitBloke[i]);
            }
        }
        return H;
    }




}
