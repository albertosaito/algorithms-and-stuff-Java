package com.alberto.tinkering.concurrent;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * FutureExample represents ...
 *
 * @author <a href="mailto:nobuji.saito@gmail.com">nobuji.saito</a>
 * @version $Id$
 * @since Oct 20, 2015
 *
 */
public class FutureExample
{
   private static final ExecutorService threadPool = Executors.newFixedThreadPool (3);


   /**
    * Represents main
    *
    * @param args
    * @throws InterruptedException
    * @throws ExecutionException
    * @since Oct 20, 2015
    *
    */
   public static void main (final String args[]) throws InterruptedException, ExecutionException
   {

      final LongTimeConsumingTask task = new LongTimeConsumingTask ();

      System.out.println ("Invoke time consuming task");
      final Future <String> future = threadPool.submit (task);


      while ( !future.isDone ())
      {
         System.out.println ("Not completed yet....");
         Thread.sleep (10); // sleep for 10 millisecond before checking again
      }
      System.out.println ("Task Completed!");
      final String result = future.get ();
      System.out.println ("Result: " + result);
      threadPool.shutdown ();
   }

   private static class LongTimeConsumingTask implements Callable <String>
   {

      /**
       * Constructs an instance of LongTimeConsumingTask object.
       */
      public LongTimeConsumingTask ()
      {
         super ();
      }


      /**
       * Overrides call
       *
       * @return String
       * @since Oct 20, 2015
       * @see java.util.concurrent.Callable#call()
       */
      @Override
      public String call ()
      {
         try
         {
            Thread.sleep (100);
         }
         catch (final InterruptedException e)
         {
            // Do nothing
         }
         return "Finally Done";
      }

   }



}
