#include <stdio.h>
#include <stdlib.h>

int search(int** sortedMat, int matSize, int val);

int main(){

    return 0;
}

int search(int** sortedMat, int matSize, int val){

    //Index for top right element
    int c = 0;
    int r = matSize - 1;

    //While we are horizontally and vertically within the right bounds
    while(c<matSize && r >= 0){

        if(sortedMat[c][r] == val)
            return 1;
        else if(sortedMat[c][r] < val)
            r--;
        else
            c++;
    }

    return 0;

}