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
    printf("Dictionary Path: %s [LENGTH: %d]\n", dict->path, dict->length);

    for(int entry = 0; entry < dict->length; ++entry){
        puts(dict->contents[entry]);
    }
}

char* genWords(int count, dictionary* dict){
    char* result = malloc(sizeof(char));
    int size = 0;

    for(int pass = 0; pass < count; ++pass){
        char* word_buffer = dict->contents[rand()%dict->length];
        int gen_size = strlen(word_buffer);

        result = realloc(result, size + ++gen_size);

        sprintf(&result[size], "%s", word_buffer);
        size+=gen_size;

        printf("%d[%d]%s\n", pass, size, result);

        result[size-1] = ' ';
    }

    result[size] = '\0';
    
    return result;
}

