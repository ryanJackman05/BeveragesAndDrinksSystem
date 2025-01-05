package controller;

public class LinkList<L> { // L - list type
    public Node<L> head=null; //where head = index 0
    public void addElement(L e) { //Add element to head of list
        Node<L> fn=new Node<>();
        fn.setContents(e);
        fn.next=head;
        head=fn;
        System.out.println("added");
    }
    public void clear() { //Empty list
        head=null;
    } // removing parent node in hierarchy makes all nodes inaccessable
    public String ListAllShows(){
        return "idk";
    }
    public boolean updateNode(int index, L nodeInfo)
    {
        if(index<0) return false;
        Node<L> n = head;

        int i = 0;
        while (i != index){ //if index is 5, iterator stops at 5
            if(n.next == null) return false; // not found, at end of list
            n=n.next;
            i++;
        } // node found
        n.setContents(nodeInfo); // contents (either Show, Performance, etc.) are set, and linkedList remains intact on a Node level, as contents are separate from .next reference
        return true;
    }
    public boolean deleteNode(int index) //WORKS
    {
        Node<L> n = head;
        if(index==0) {
            head = head.next;
            System.out.println("deleting index: 0");
            return true;
        }
        int i = 0;
        while (i != index-1){ //if index is 4, iterator stops at 3
            if(n.next == null) return false; // not found, at end of list
            n=n.next;
            i++;
        } // node found
        System.out.println("deleting index: "+index);
        Node<L> deleted = n.next;
        n.next = n.next.next; // next swap at end
        return true;
    }
    public Node<L> getNode(int index)
    {
        //System.out.println("getting with index: "+index);
        if(index<0) return null;
        Node<L> n = head;
        int i = 0;
        while (i != index){ //if index is 5, iterator stops at 5
            if(n.next == null) return null; // not found, at end of list
            n=n.next;
            i++;
        } // node found
        return n;
    }
    public int getLength()
    {
        Node<L> node = head;
        int count = 0;
        while(node!=null){
            count++;
            node = node.next;
        }
        return count;
    }
    // Add other insertion, deletion, access, search, etc. methods too
    // Inner class approach.
    public class Node<N> {
        public Node<N> next=null;
        private N contents; //ADT reference
        public N getContents() { return contents; }
        public void setContents(N c) { contents=c; }
    }
}
