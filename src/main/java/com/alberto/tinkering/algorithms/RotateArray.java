package com.alberto.tinkering.algorithms;


import java.util.Arrays;


/**
 *
 * @author <a href="mailto:nobuji.saito@gmail.com">nobuji.saito</a>
 * @version $Id$
 * @since Jul 24, 2015
 *
 *        Rotates an array k steps (clockwise)
 *
 */
public class RotateArray
{
   /**
    * Represents rotate
    *
    * @param arr
    * @param order
    * @since Jul 24, 2015
    *
    */
   public static void rotate (final int[] arr, final int order)
   {
      final int orderLocal = order % arr.length;

      if ( (arr == null) || (orderLocal < 0))
      {
         throw new IllegalArgumentException ("Illegal argument!");
      }

      // length of first part
      final int a = arr.length - orderLocal;

      reverse (arr, 0, a - 1);
      reverse (arr, a, arr.length - 1);
      reverse (arr, 0, arr.length - 1);

   }


   /**
    * Represents reverse
    *
    * @param arr
    * @param left
    * @param right
    * @since Jul 24, 2015
    *
    */
   public static void reverse (final int[] arr, final int left, final int right)
   {
      int leftLocal = left;
      int rightLocal = right;

      if ( (arr == null) || (arr.length == 1))
      {
         return;
      }

      while (leftLocal < rightLocal)
      {
         final int temp = arr[leftLocal];
         arr[leftLocal] = arr[rightLocal];
         arr[rightLocal] = temp;
         leftLocal++;
         rightLocal--;
      }
   }


   /**
    * Represents main
    *
    * @param args
    * @since Jul 24, 2015
    *
    */
   public static void main (final String args[])
   {
      final int[] array = new int[100];
      for (int i = 1; i <= 100; i++)
      {
         array[i - 1] = i;
      }
      System.out.println ("Original: " + Arrays.toString (array));
      rotate (array, 24);
      System.out.println ("Rotated+24: " + Arrays.toString (array));
   }



}
