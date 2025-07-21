package leetcode;

import java.math.BigDecimal;
import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int flag = 0;
        while(scan.hasNext()){
            int value1 = scan.nextInt();
            int value2 = scan.nextInt();
            int [] arr1 = exchange(value1);
            int [] arr2 = exchange(value2);
            for (int i : arr1) {
                if(i==1){
                    System.out.print(""+i);
                }else{
                    System.out.print(" ");
                }

            }
            for (int i : arr2) {
                if(i==1){
                    System.out.print(""+i);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            flag+=1;
            if(flag>=16&&flag%16==0){
                System.out.println("\n");
            }
        }
        scan.close();
    }
    //将数字转化为2进制的数
    private static int[] exchange(int value){
        int index=7;
        int arr[]=new int[8];
        Arrays.fill(arr, 0);
        int va = Math.abs(value);
        while(va!=0){
            arr[index] = va%2;
            index--;
            va/=2;
        }
        int flag=0;
        if(value<0){
            for(int i=7;i>=0;i--){
                if(flag==0&&arr[i]==1){
                    flag=1;
                }else{
                    arr[i] = 1-arr[i];
                }

            }
        }
        return arr;
    }

}