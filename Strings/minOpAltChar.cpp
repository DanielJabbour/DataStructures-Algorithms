#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'minimalOperations' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts STRING_ARRAY words as parameter.
 */

int adjChar(string word){

    int del = 0;

    for(int i=1;i<word.size();i++){
        if(word[i-1] == word[i]){
          word[i] = '_';
          del++;
        }
    }
    return del;
}

vector<int> minimalOperations(vector<string> words) {

    vector<int> result;
    result.reserve(words.size());

    for(int i=0;i<words.size();i++){
        result.push_back(adjChar(words[i]));
    }

    return result;

}

int main()