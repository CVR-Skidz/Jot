#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include "dictionary.h"

int main(int argc, char* argv[]){
    srand(time(0));

    int noun = 0;

    switch(argc){
        case 2:
            noun = 1;
            break;
        case 3:
            break;
        default:
            puts("Invalid argument: jot (words) (noun)[optional]");
            return 0;
    }

    dictionary adjectives = createDictionary("test.txt");

    //logDictionary(&adjectives);

    puts(genWords(atoi(argv[1]), &adjectives)); 

    return 0;
}