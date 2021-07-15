import java.util.*;

public class A1073314_checkpoint7_BlockQueue implements A1073314_checkpoint7_Fringe {
    Queue<A1073314_checkpoint7_Block> queue;
    //Description : the constuctor of BlockQueue.
    public A1073314_checkpoint7_BlockQueue(){
        //TODO(Past) : Initialize the queue.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        queue = new LinkedList<A1073314_checkpoint7_Block>();
        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/

    }
    //Description : add the input object into Fringe
    public void add(A1073314_checkpoint7_Block block){
        //TODO(Past) : add block into the queue.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        queue.offer(block);
        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/
    }
    //Description : return and remove the object from Fringe.
    public A1073314_checkpoint7_Block remove(){
        //TODO(Past) :First check the queue is empty or not and return and remove the object from the queue.
        // If queue is empty return null.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        return queue.poll();

        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/

    }
    //Description : Check if the Fringe has a object at least. if it is empty return true, vice versa. 
    public boolean isEmpty(){
        //TODO(Past) :Check the queue is empty or not.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        if(queue.size() == 0) return true;
        else return false;
        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/

    }
}