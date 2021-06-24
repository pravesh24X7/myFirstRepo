#include <iostream>
using namespace std;

// forward declaration of binarySearch and sort function 
int bs(int[], int, int , int );

void sort(int arr[], int N) {
    for (int i=0; i<N-1; i++) {
        for (int j=i+1; j<N; j++) {
            if (arr[i] > arr[j]) {
                swap(arr[i], arr[j]);
            }
        }
    }
}

// main function 
int main(int argc, char const *argv[])
{
    int arr[] = {8,7,6,4,3,0,2,1};
    int N = sizeof(arr)/sizeof(arr[0]);

    sort(arr, N);
    for (auto &i : arr) {
        cout << i << " ";
    }

    cout << bs(arr, 0, N-1, 8);

    return 0;
}

int bs(int arr[], int lower, int upper, int srcVal) {
    if (lower < upper) {
        int mid = lower+(upper-lower)/2;

        if (arr[mid] == srcVal) return mid+1;
        else if (arr[mid] > srcVal) return bs(arr,lower, mid, srcVal);
        else return bs(arr, mid+1, upper, srcVal);
    }
    return -1;
}