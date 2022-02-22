package Question.interview.MS.aks;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Elevator implements Runnable{

    class DlinkedNode{
        int floor;
        DlinkedNode pre;
        DlinkedNode next;

        public DlinkedNode(int floor) {
            this.floor = floor;
        }
    }

    int capacity;
    DlinkedNode curFloor;
    DlinkedNode dummyHead;
    String curStatus;

    ReentrantLock lock = new ReentrantLock();
    Condition isEmpty = lock.newCondition();

    public Elevator(int capacity) {
        this.capacity = capacity;
        this.dummyHead = new DlinkedNode(0);
        this.curFloor = new DlinkedNode(1);
        this.curFloor.pre = dummyHead;
        dummyHead.next = curFloor;
        this.curStatus = "Up";
    }

    public void gotoFloor(int k) throws Exception {
        if (k == curFloor.floor) return;
        lock.lock();
        insertNode(new DlinkedNode(k));
        isEmpty.signalAll();
        lock.unlock();
    }

    private void insertNode(DlinkedNode node) {
        DlinkedNode cur = dummyHead;
        DlinkedNode pre = dummyHead;
        while (cur!=null && cur.floor < node.floor) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = node;
        node.next = cur;
    }

    public void gotoNextTarget() throws Exception {
        if (dummyHead.next == null){
            isEmpty.await();
            return;
        }

        if (curStatus.equals("Up")){
            if (curFloor.next!= null){
                curFloor = curFloor.next;
            }else{
                curStatus = "Down";
                curFloor = curFloor.pre;
            }
        }else if(curStatus.equals("Down")){
            if (curFloor.pre!= null){
                curFloor = curFloor.pre;
            }else{
                curStatus = "Up";
                curFloor = curFloor.next;
            }

        }else {
            throw new Exception("Evevator is broken.");
        }
    }

    public boolean goUp(int incomingFloor){
        return incomingFloor < capacity;
    }

    public boolean goDown(int incomingFloor){
        return incomingFloor > 1;
    }

    public void terminate(){
        this.curStatus = "Error";
    }


    public static void main(String[] args) {

    }

    @Override
    public void run() {
        while (!curStatus.equals("Error")){
            try {
                gotoNextTarget();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}