/* You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters)... Return the number of boomerangs...
 * Eg 1: Input = [[0, 0], [1, 0], [2, 0]]      Output = (1, 0, 2) , (1, 2, 0) = 2
 * Eg 2: Input = [[1, 1], [2, 2], [3, 3]]      Output = (1, 0, 2) , (1, 2, 0) = 2
 * Eg 3: Input = [[1, 1]]                      Output = 0
 */
import java.util.*;
public class Boomerang
{
    public int[][] SelectionSort(int[][] array)     // Time Complexity - 0(n^2) time...
    {
        for(int i = 0; i < array[0].length; i++)    // Method to get length of 2d array...
        {
            int min = array[0][i] + array[1][i];
            for(int j = 0; j < array[0].length; j++)
            {
                if(min < array[0][j]+array[1][j])    // Sorting using Selection Sort... O(n^2) time...
                {
                    int temp1 = array[0][i];     // Sorting the first row...
                    min = array[0][j]+array[1][j];
                    array[0][i] = array[0][j];
                    array[0][j] = temp1;
                    temp1 = array[1][i];   // Simultaneously sorting the second row...
                    array[1][i] = array[1][j];
                    array[1][j] = temp1;
                }
            }
        }
        return array;
    }
    public int NumberOfBoomerangs(int array[][])     // Time Complexity - O(n) time...
    {
        int boomerangs = 0;
        int i = 1;                 // If array has less than 3 elements...
        if(array[0].length < 3)   
            return boomerangs;
        do
        {
            int sum0 = array[0][i-1] + array[1][i-1];     // Sum at i-1 index...
            int sum1 = array[0][i] + array[1][i];         // Sum of i index...
            int sum2 = array[0][i+1] + array[1][i+1];     // Sum of i+1 index...
            if(sum1 - sum0 == sum2 - sum1)   // If their difference is same then a two way tuple can be formed which will work as a Boomerang...
                boomerangs = boomerangs + 2;      // Increment by 2...
            i++;
        }while(i < array[0].length-2);    // Loop Termination condition...
        return boomerangs;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, a, p;
        System.out.print("Enter the number of Boomerangs : ");
        x = sc.nextInt();
        Boomerang boomer = new Boomerang();    // Object creation...
        int boomerang[][] = new int[2][x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter "+(i+1)+" Boomerang start : ");
            a = sc.nextInt();
            System.out.print("Enter "+(i+1)+" Boomerang end : ");
            p = sc.nextInt();
            boomerang[0][i] = a;
            boomerang[1][i] = p;
        }
        System.out.println("Boomerang Array formed !!");
        for(int i = 0; i < x; i++)
            System.out.print("["+boomerang[0][i]+","+boomerang[1][i]+"]");
        System.out.println();
        boomerang = boomer.SelectionSort(boomerang);
        for(int i = 0; i < x; i++)
            System.out.print("["+boomerang[0][i]+","+boomerang[1][i]+"]");
        System.out.println();
        System.out.println("Maximum Boomerangs : "+boomer.NumberOfBoomerangs(boomerang));
        sc.close();
    }
}

// Time Complexity  - O(n^2) time...
// Space Complexity - O(1) space...
// Optimal Time Complexity - O(nlogn) time...
// Optimal Space Complexity - O(1)space...

/* DEDUCTIONS:- 
 * 1. We sort the array and check for differences...
 * 2. If the difference of left and right element is same then that set can be represented as a tuple with two permutations...
*/