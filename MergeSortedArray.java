/**
 * 
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, 
 * nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {

    public static void main(String[] args) throws Exception {
        //int[] num1 = {4,5,6,0,0,0}; 
        //int m = 3;
        //int[] num2 = {1,2,3};
        //int n = 3;
        
        //int[] num1 = {1,2,3,0,0,0};
        //int m = 3;
        //int[] num2 = {2,5,6};
        //int n = 3;

        int[] num1 = {1};
        int m = 1;
        int[] num2 = {};
        int n = 0;
        try{
            merge(num1, m, num2, n);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) throws Exception {
        int iLen = m;
        int jLen = n;
        int tLen = m+ n;
        int currentNum1 = 0;
        
        int currentNum2 = 0;
        int max = 1000000000;
        int min = -1000000000;

        for (int i = 0; i < iLen; i++){
            currentNum1 = nums1[i];
            for (int j = 0; j < jLen; j++){
                currentNum2 = nums2[j];
                if (currentNum1 >= currentNum2) {
                    //shift to back
                    for (int x = iLen; x > i; x--){
                        nums1[x] = nums1[x-1];
                    }
                    nums1[i] = currentNum2;
                    nums2[j] = max;
                    iLen++;
                    break;
                }
            }
        }
        
        for (int i = 0; i < jLen; i++){
            if (nums2[i] < max && nums2[i] > min){
                nums1[iLen] = nums2[i];
                nums2[i] = max;
                iLen++;
            }
        }

        for (int i = 0; i < tLen; i++){
            System.out.println(nums1[i]);
        }

    }
}
