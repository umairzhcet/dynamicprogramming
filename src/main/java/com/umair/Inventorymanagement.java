package com.umair;

import java.io.IOException;
import java.math.BigInteger;

public class Inventorymanagement {

    public static void main(String[] args) throws InterruptedException {

        InventoryCounter counter=new InventoryCounter();

        Thread t1=new IncrementingThread(counter);
        Thread t2=new DecrementingThread(counter);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Items:"+counter.getItems());

    }

    private static class WaitingForUserInput implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    char input = (char) System.in.read();
                    if(input == 'q') {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
            };
        }
    }

    public static class IncrementingThread extends Thread{

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter counter){
            this.inventoryCounter=counter;

        }

        @Override
        public void run() {

            for(int i=0;i<1000;i++){
                inventoryCounter.increment();
            }
        }
    }

    public static class DecrementingThread extends Thread{

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter counter){
            this.inventoryCounter=counter;

        }

        @Override
        public void run() {

            for(int i=0;i<1000;i++){
                inventoryCounter.decrement();
            }
        }
    }

    private static class InventoryCounter{
        private int items=0;

        Object lock=new Object();

        public void increment(){
            synchronized (this.lock){
                items++;
            }

        }

        public void decrement(){
            synchronized (this.lock){
                items--;
            }
        }

        public int getItems(){
            return items;
        }


    }
}
