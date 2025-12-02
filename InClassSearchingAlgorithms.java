
public class InClassSearchingAlgorithms{

public static int linear_search(int[] array, int x){
    for(int i = 0; i < array.length; i++){
        if (array[i] == x){
            return i;
        }

    }
    return -1;
}
public static int binary_search(int[]array,int x){
    int low = 0;
    int high = array.length - 1;

    while (low <= high){
        int mid = (low + high) /2;
        if (array[mid] == x){
            return mid;
        }else if (array[mid]<x){
            low = mid + 1;
        } else{
            high = mid - 1;
        }
    }
    return -1;
}

public static void main(String[] args){
    int [] array = {1, 2, 4, 5, 7, 9};
    int x = 5;
    int x2 = 7;
    int linearResult = linear_search(array, x);
    System.out.println(linearResult);
    int binaryResult = binary_search(array, x);
    System.out.println(binaryResult);
    int linearResult2 = linear_search(array, x2);
    System.out.println(linearResult2);
    int binaryResult2 = binary_search(array, x2);
    System.out.println(binaryResult2);
}
}

