________________________________________________________________________________________________________________________
Kratek Opis
Ta Java aplikacija omogoča branje MKV datotek, analizo frekvence bitnih blokov, in Huffmanovo kodiranje za stiskanje podatkov.
------------------------------------------------------------------------------------------------------------------------
MKVFile:
 mkvFileToBits(): prebere Mkv file in pretvori v byte array in bite

 mapFBits(): steje frekvenco blokov 8 ali 16 bitov nism uporabil uporabili  array velikosti 2^velikost bloka
             -> pretvori bit blok v desetisko stevko i (i-to mesto v arrayu) in zapise poveca count na tistem mestu v arrayu mapFBitBloke

 mapPBits(): isti princip samo da deli mapFBits[i]/st. vseh blokov bitov
........................................................................................................................
 HuffmanNode:
    node za izgradno Huffman drevesa
    String bitov
    Vrjetnost
........................................................................................................................
 Huffman:
    HuffmanCodeTree(): generira hufmano drevo, tako da v min heap vstavi vse bloke bitov in njihove vrjetnosti
    v obliku HuffmanNode (gremo cez cel array mapPbits ponovno dobimo string bitov da pretvorimo desetisko stevilo i v dvojiski zapis ( od mapF8Bits[i])
    da dobimo string bitnega bloka, in vrjetnost ki je v arrayu (mapF8Bits[i])

    potem vzamemo dva min elementa in jih damo kot lista novemu HuffmanNode, kjer sestejemo njihovi vrjetnosti a brez, stringa
    ponavljamo dokler min heap ni velikosti 1, ostane samo root huffman tree.

    getArrayOfCodeWords(): klice funkcijo getArrayOfCodeWordsRec(), ki je rekurzivna

    getArrayOfCodeWordsRec(): rekurzivno se sprehodi cez drevo ko pride do lista shrani kodnobesedo bitnega seta
    v array ArrayOfCodeWords[i] kjer je ponovno i desetiski zapis bitmega seta in ArrayOfCodeWords[String na i mestu], njegova kodna beseda.

   encode(): kodira po huffmanu zaceten niz, dostop do kodnih besed v ArrayOfCodeWordl, po istem principu kot prej.
------------------------------------------------------------------------------------------------------------------------
Komentarji: za implementacijo funkcije decode, potrebno spremeniti podatkovno struktoro namesto arraya za codewords, v drevo,
za hitrejso iskanje
________________________________________________________________________________________________________________________


