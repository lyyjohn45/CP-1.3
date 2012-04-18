#include "replceBlank.h"
#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>



/*
* Write a method to replace all spaces in a string with ‘%20’
*/
using namespace std;
char* replace (char s[])
{
    //pointer safe
    size_t tail = strlen(s) - 1;
    while(tail > 0)
    {
        if(s[tail] == ' ')
        {
            s = (char*) realloc(s, sizeof(char) *2);
            strcpy(&s[tail+3], &s[tail+1]);
            s[tail] = '%';
            s[tail+1] = '2';
            s[tail+2] = '0';
        }
        tail--;
    }

    return s;
}

void mai()
{
   char test[] = "a b c";
   char* result = replace(test);

   cout<<"afte the replace :"<< result << endl;

   cin.get();
}