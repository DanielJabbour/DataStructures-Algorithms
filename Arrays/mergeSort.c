#include <stdio.h>
#include <stdlib.h>

void mergesort(int* arr, int left, int right);
void merge(int* arr, int left, int mid, int right);

void mergesort(int* arr, int left, int right){

    if (left < right){

        int mid = left + (right-1)/2;

        mergesort(arr, left, mid);
        mergesort(arr, mid, right);
        merge(arr, left, mid, right);
    }

}

void merge(int* arr, int left, int mid, int right){

    int n1 = mid - left + 1;
    int n2 = right - mid;

    //Temp arrays
    int* leftArr = malloc(n1*sizeof(int));
    int* rightArr = malloc(n2*sizeof(int));

    for (int i = 0; i< n1; i++)
        leftArr[i] = arr[left + i]; 

    for (int j = 0; j < n2; j++) 
        rightArr[j] = arr[mid + left + j]; 

    int k = 0;
    int i = 0;
    int j = 0;

    while(i < n1 && j < n2){
        
        if(leftArr[i] <= rightArr[j]){ 
            arr[k] = leftArr[i]; 
            i++; 
        } 
        else{ 
            arr[k] = rightArr[j]; 
            j++; 
        }

        k++; 
    }

     /* Copy the remaining elements of L[], if there 
       are any */
    while (i < n1){ 
        arr[k] = leftArr[i]; 
        i++; 
        k++; 
    } 
  
    /* Copy the remaining elements of R[], if there 
       are any */
    while (j < n2){ 
        arr[k] = rightArr[j]; 
        j++; 
        k++; 
    }

}