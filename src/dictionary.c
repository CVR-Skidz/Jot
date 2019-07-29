#include "dictionary.h"

dictionary createDictionary(char* path){
    dictionary dict = { 0 };
    dict.contents = malloc(sizeof(char*));
    dict.path = path;

    open(&dict);

    return dict;
}

file_status open(dictionary* dict){
    FILE* file = fopen(dict->path, "r");

    if(!file){
        return NOT_FOUND;
    }

    int read = 1;

    while(read){
        int buffer_length = 1;
        char* character_buffer = malloc(sizeof(char));

        while((CURRENT_BUFFER = fgetc(file)) != '\n' && CURRENT_BUFFER != EOF){
            character_buffer = realloc(character_buffer, ++buffer_length * sizeof(char));
        } 

        read = CURRENT_BUFFER == EOF ? 0 : 1;

        CURRENT_BUFFER = '\0';
        appendEntry(character_buffer, dict);
    }

    return OK;
}

void appendEntry(char* word, dictionary* dict){
    dict->contents = realloc(dict->contents, (dict->length + 1)*sizeof(char*));
    dict->contents[dict->length++] = word;
}

void logDictionary(dictionary* dict){
    puts(dict->path);
    printf("[%d]\n", dict->length);
}