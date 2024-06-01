________________________________________________________________________________________________________________________
KRATEK OPIS aka upam da sm logicno napisal Tilen hahah
------------------------------------------------------------------------------------------------------------------------
MKVFile:
 mkvFileToBits(): prebere Mkv file in pretvori v byte array in bite

 mapF8Bits(): steje frekvenco blokov 8bitov nism uporabil nobene fency struktrure ker je array velikosti 256
    (max vrednost 8 bitov) -> pretvori v desetisko stevko in zapise poveca count na tistem mestu v arrayu mapFBitBloke

 mapP8Bits(): isti princip samo da deli mapF8Bits[i]/st. vseh blokov 8bitov
........................................................................................................................
 HuffmanNode:
    node za izgradno Huffman drevesa
    String 8bitov
    Vrjetnost
........................................................................................................................
 Huffman:
    HuffmanCodeTree(): generira hufmano drevo, tako da v min heap vstavi vse bloke 8bitov in njihove vrjetnosti
    v obliku HuffmanNode (ponovno dobimo string 8bitov da pretvorimo desetisko stevilo i ( od mapF8Bits[i])
    da dobimo string 8bitnega bloka, in vrjetnost ki je v arrayu (mapF8Bits[i])

    potem vzamemo dva min elementa in jih zdruzimo v HuffmanNode, kjer sestejemo njihovi vrjetnosti a brez, stringa
    ponavljamo dokler min heap ni velikosti 1 aka, samo huffman tree.

    getArrayOfCodeWords(): klice funkcijo getArrayOfCodeWordsRec(), ki je rekurzivna

    getArrayOfCodeWordsRec(): rekurzivno se sprehodi cez drevo ko pride do lista shrani kodnobesedo 8bitnega seta
    v array ArrayOfCodeWords[i] kjer je ponovno i desetiski zapis 8bitmega seta in njegova vrednost
    ArrayOfCodeWords[String na i mestu], njegova kodna beseda.

   encode(): kodira po huffmanu zaceten niz, dostop do kodnih besed v ArrayOfCodeWordl, po istem principu kot prej.
------------------------------------------------------------------------------------------------------------------------
Komentarji
________________________________________________________________________________________________________________________


