#ifndef DICTIONARY
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define CURRENT_BUFFER character_buffer[buffer_length-1]

typedef enum t_file_status{
    OK,
    NOT_FOUND
} file_status;

typedef struct t_dictionary{
    int length;
    char* path;
    char** contents;
} dictionary;

dictionary createDictionary(char* path);
file_status open(dictionary* dict);
void appendEntry(char* word, dictionary* dict);
void logDictionary(dictionary* dict);
char* genWords(int count, dictionary* dict);

#define DICTIONARY
#endif
