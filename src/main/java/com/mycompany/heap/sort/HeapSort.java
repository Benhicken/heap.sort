/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heap.sort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author BeHic3368
 */
public class HeapSort {
    
    public void runHeapSort(int[] a)
    {
        // Performs the 'heapify' using only the first half of the array
        for (int i = (a.length / 2) - 1; i >= 0; i--)
        {
            heapify(a, a.length, i);
        }
        
        // Confirms the highest values and reorders to see any changes
        for (int i = a.length - 1; i > 0; i--)
        {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            
            heapify(a, i, 0);
        }
    }
    
    void heapify(int[] a, int length, int i)
    {
        int largest = i; // The position of the parent node
        int left = 2 * i + 1; // The position of the left child node
        int right = 2 * i + 2; // The position of the right child node
        
        // Test to see if the value of the left node is greater than the parent node
        if (left < length && a[left] > a[largest])
        //if (left < length && a[left] < a[largest])
        {
            largest = left;
        }
        
        // Test to see if the value of the right node is greater than the parent node
        if (right < length && a[right] > a[largest])
        //if (right < length && a[right] < a[largest])
        {
            largest = right;
        }
        
        // If one of the child nodes is greater than it's parent, it swaps them.
        if (largest != i)
        {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            
            // Check to see if the swapped node needs to be swapped again.
            heapify(a, length, largest);
        }
    }
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int length = 0;
        
        System.out.println("Enter the array length: ");
        length = scan.nextInt();
        
        int[] a = new int[length];
        for (int i = 0; i < length; i++)
        {
            a[i] = rand.nextInt(100);
        }
        System.out.print("Original Array: ");
        printArray(a);
        
        long startTime = System.nanoTime();
        HeapSort ob = new HeapSort();
        ob.runHeapSort(a);
        
        long endTime = System.nanoTime();
        long timeElapsed = (endTime - startTime);
        System.out.println("Processing Time: " + timeElapsed + "ns");
        
        System.out.print("Sorted Array: ");
        printArray(a);
    }
    
    static void printArray(int arr[])
    {
        // Prints the array using a for loop.
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
