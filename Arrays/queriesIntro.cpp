#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    
    int num_arr, num_query;
    cin >> num_arr >> num_query;
    
    //Initialize array of arrays
    int** arr = new int*[num_arr]();
    
    for(int i=0;i<num_arr;i++){
        
        int currLen;
        cin >> currLen;
        
        //create array to store current values
        int* currArr = new int[currLen]();
        
        for(int j=0;j<currLen;j++)
            cin >> currArr[j];
        
        //Store subarray in i
        arr[i] = currArr;
    }
    
    //Perform queries
    for(int i=0;i<num_query;i++){ 
        //Obtain query locations and output them on a new line each
        int q1, q2;
        cin >> q1 >> q2;
        cout << arr[q1][q2] << endl;
    }
    
    //Deallocate memory to avoid memory leak
    for (int i=0;i<num_arr;i++)
        delete[] arr[i];
    
    delete[] arr;

    //Same operation with vectors rather than arrays
    
    //Create a vector of vectors of size num_arr
    vector<vector<int>> vect(num_arr);
    
    for(int i=0;i<num_arr;i++){
        int currLen;
        cin >> currLen;
        
        //Resize vector to appropriate length
        vect[i].resize(currLen);
        
        for(int j=0;j<currLen;j++)
            cin >> vect[i][j];
        
    }
    
    //Perform queries
    for(int i=0;i<num_query;i++){
        int q1, q2;
        cin >> q1 >> q2;
        cout << vect[q1][q2] << endl;
    }
    
    return 0;
}