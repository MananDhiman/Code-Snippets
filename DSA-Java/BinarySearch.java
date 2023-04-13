public class BinarySearch {
    void search(int[] arr, int num){
        int low = 0, high = arr.length-1;
        search(arr, num, low, high);
    }

    void search(int[] arr, int num, int low, int high){
        if(high - low == 1){
            System.out.println(num + " Not Found");
            return;
        }

        int mid = (low + high) / 2;
        if(num == arr[mid]){
            System.out.println("Found " + num + " at " + mid);
            return;
        }
        else if(num == arr[low]){
            System.out.println("Found " + num + " at " + low);
            return;
        }
        else if(num == arr[high]){
            System.out.println("Found " + num + " at " + high);
            return;
        }
        else if(num < arr[mid]){
            search(arr, num, low, mid);
            return;
        } 
        else if(num > arr[mid]){
            search(arr, num, mid, high);
            return;
        } 
        

    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        BinarySearch bSearch = new BinarySearch();
        for(int i=0;i<=10;i++){
            bSearch.search(arr, i);
        }
        
    }
}
