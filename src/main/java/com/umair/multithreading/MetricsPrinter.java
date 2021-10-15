package com.umair.multithreading;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class MetricsPrinter {

    public static void main(String[] args) throws InterruptedException {

        Metrics metrics=new Metrics();

        Thread t1=new BusinessLogic(metrics);
        Thread t2=new BusinessLogic(metrics);

        Thread t3=new PrinterMetrics(metrics);
        t1.start();
        t2.start();
        t3.start();




        System.out.println("Average:"+metrics.getAverage());

    }

    public static class BusinessLogic extends Thread{

        private Random random=new Random();
        private Metrics metrics;


        public BusinessLogic(Metrics metrics){
            this.metrics=metrics;

        }

        @Override
        public void run() {

              while(true) {
                  long start = System.currentTimeMillis();

                  try {
                      Thread.sleep(random.nextInt(10));
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

                  long end = System.currentTimeMillis();

                  metrics.addSample(end - start);

              }
        }
    }

    private static class PrinterMetrics extends Thread{
        private Metrics metrics;

        public PrinterMetrics(Metrics metrics){
            this.metrics=metrics;
        }

        @Override
        public void run() {
           while(true){

               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(metrics.getAverage());
           }
        }
    }


    private static class Metrics{
        private long count;
        private volatile double average;

        public synchronized void addSample(long sample){
            double sum=average*count;
            count++;
            average=(sum+sample)/count;

        }

        public double getAverage(){

            return average;
        }

      }





}
