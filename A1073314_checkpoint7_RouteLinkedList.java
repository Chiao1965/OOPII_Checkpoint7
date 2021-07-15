public class A1073314_checkpoint7_RouteLinkedList{
    private A1073314_checkpoint7_Node head;
    //Description : the constructor of leading the head Node as null.
    public A1073314_checkpoint7_RouteLinkedList(){
        this.head = null;
    }
    //Description : the constructor of input a Node as the head node.
    public A1073314_checkpoint7_RouteLinkedList(A1073314_checkpoint7_Node head){
        this.head = head;
    }
    public void delete(int axis, int direction){ 
        /*********************************The Past TODO (Checkpoint5)******************************
        //TODO(1):      Input value of Node as the reference Node,
        //              you have to delete the first Node that is same as the reference Node,
        //              and connect the following one and the previous one.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073314_checkpoint7_Node node = new A1073314_checkpoint7_Node(direction, axis);
        A1073314_checkpoint7_Node prev = null;
        A1073314_checkpoint7_Node current = head;
        if(head == null){
            return;
        }
        else{
            while(!(current.getAxis()==node.getAxis() && current.getDirection()==node.getDirection()) && current.getNext() != null){
                prev = current;
                current = current.getNext();
            }
            if(current.getAxis()==node.getAxis() && current.getDirection()==node.getDirection()){
                if(prev == null){
                    head = current.getNext();
                }
                else{
                    prev.setNext(current.getNext());
                }
            }
        }
        
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }

    public A1073314_checkpoint7_Node search(int axis, int direction){ 
        /*********************************The Past TODO (Checkpoint5)********************************
        //TODO(2):      Input value of Node as the reference Node,
        //              you have to find the first Node that is same as the reference Node,
        //              and return it.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073314_checkpoint7_Node node = new A1073314_checkpoint7_Node(direction, axis);
        A1073314_checkpoint7_Node current = head;
        if(head == null){
            return null;
        }
        else{
            while(current.getNext() != null){
                if(current == node){
                    return current;
                }
                current = current.getNext();
            }
            if(current.getNext() == null){
                if(current == node){
                    return current;
                }
                else{
                    return null;
                }
            }
            else{
                return null;
            }
        }
        
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
    public void insert(int referenceAxis, int referenceDirection, int axis, int direction){ 
        /*********************************The Past TODO (Checkpoint6)********************************
        //TODO(3):      Input value of Node as the reference Node,
        //              and insert a Node BEFORE the first Node same as the reference Node,
        //              and connect the following one and the previous one.
        //Hint          The value of the Node is int variable axis and dirsction.
        //Hint2         If there is no reference node in linkedlist, print "Insertion null".
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073314_checkpoint7_Node insertNode = new A1073314_checkpoint7_Node(direction, axis);
        A1073314_checkpoint7_Node prev = null;
        A1073314_checkpoint7_Node current = head;
        if(head == null){
            return;
        }
        else{
            while(!(current.getAxis() == referenceAxis && current.getDirection() == referenceDirection) && current.getNext() != null){
                prev = current;
                current = current.getNext();     
            }
            if(current.getAxis() == referenceAxis && current.getDirection() == referenceDirection){
                insertNode.setNext(current);
                if(prev == null){
                    head = insertNode;
                }
                else{
                    prev.setNext(insertNode);
                }
            }
            else{
                System.out.print("Insertion null");
                return;
            }
        }

        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
    public int length(){
        /*********************************The Past TODO (Checkpoint5)********************************
        //TODO(4):      return how long the LinkedList is.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073314_checkpoint7_Node current = head;
        int size = 0;
        if(head == null){
            return size;
        }
        else if(head != null){
            size = 1;
        }
        while(current.getNext() != null){
            size++;
            current = current.getNext();
        }
        return size;
        
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
    public void append(int axis, int direction){
        // A1073314_checkpoint7_Node node = this.head;
        // while(node.getNext() != null){
        //     node = node.getNext();
        // }
        // node.setNext(new A1073314_checkpoint7_Node(direction, axis));

        A1073314_checkpoint7_Node node = new A1073314_checkpoint7_Node(direction, axis);
        A1073314_checkpoint7_Node current = head;
        if(head == null){
            head = node;
        }
        else{
            // System.out.println("else??????");
            // A1073314_checkpoint5_Node next = head.getNext();
            while(current.getNext() != null){
                current = current.getNext();
                // System.out.println(current.getAxis());
            }
            current.setNext(node);
        }
    }
    public A1073314_checkpoint7_Node getHead(){
        return this.head;
    }
    public void setHead(A1073314_checkpoint7_Node head){
        this.head = head;
    }
}
    

