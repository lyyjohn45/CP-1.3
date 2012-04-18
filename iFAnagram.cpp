#include <iostream>
#include <string>
#include <stdio.h>

using namespace std;

bool ifAnagram (char s1[], char s2[])
{
    //define NULL as non-anagram
    if(strlen(s1) != strlen(s2) || s1 == NULL || s2 == NULL)
    {
        return false;
    }

    int checkTable[256];
    for(int i = 0; i < 256; ++i)
    {
        checkTable[i] = 0;
    }

    for(int i = 0; i < strlen(s1); ++i)
    {
        int ascii = s1[i];
        checkTable[ascii]++;
    }

    for(int i = 0; i < strlen(s2); ++i)
    {
        int ascii = s2[i];
        checkTable[ascii]--;
    }

    for(int i = 0; i < 256; ++i)
    {
        if (checkTable[i] != 0)
        {
            return false;
        }
    }

    return true;
} 

void main()
{
    char s1[] = "abcd";
    char s2[] = "dcba";
    char s3[] = "abcdf";
    char s4[] = "bcfe";

    cout<<"if s1 is a anagram of s2: " << ifAnagram(s1,s2) << endl;
    cout<<"if s2 is a anagram of s3: " << ifAnagram(s2,s3) << endl;
    cout<<"if s2 is a anagram of s4: " << ifAnagram(s2,s4) << endl;
    cin.get();
}