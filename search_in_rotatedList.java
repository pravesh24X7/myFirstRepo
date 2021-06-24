public class search_in_rotatedList {

    public static int binarySearch(int[] arr, int l, int r, int key) {
        if (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[l] <= arr[mid]) {
                if (key >= arr[l] && key <= arr[mid])
                    return binarySearch(arr, l, mid - 1, key);
                return binarySearch(arr, mid + 1, r, key);
            }
            if (key >= arr[mid] && key <= arr[r])
                return binarySearch(arr, mid + 1, r, key);
            return binarySearch(arr, l, mid - 1, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,1,2,3};
        int n = arr.length;

        int k = 6;
        System.out.println(binarySearch(arr, 0, n-1, k));
    }
    

}
