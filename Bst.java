import java.util.LinkedList;
import java.util.Queue;

class Node implements Comparable<Node> {
    public int data;
    public Node RightNode;
    public Node LeftNode;

    public Node(int data) {
        this.data = data;
        RightNode = null;
        LeftNode = null;
    }

	@Override
	public int compareTo(Node secondNode) {
		return ((Integer) this.data).compareTo((Integer) secondNode.data);
	}
}

public class Bst {
	public Node head;
	int size;

    public Bst(){
        head=null;
    }

    public Bst(int data){
        Node newNode= new Node(data);
        head=newNode;
    }

	/*
		UC1: Ability to create a bst and
		add elemnts to it  
	*/
    public void add(int data){

        Node newNode= new Node(data);

        if(head==null) {
            head=newNode;
			return;
        }

        Node prev=null;
        Node curr=head;

        while(curr!=null){
            prev=curr;
            if(curr.data > data)   
				curr=curr.LeftNode;
            else if(curr.data < data)
				curr=curr.RightNode;
			else{
				System.out.println("Element(" + data + ") already present");
				return;
			}
        }

        curr=newNode;
        if(prev.compareTo(curr) > 0) 
			prev.LeftNode=curr;
        else 
			prev.RightNode=curr;
    }

	public int size(){
		System.out.println("Size: " + size);
		return size;
	}

	public boolean search(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data){
				System.out.println(data + " is present.");
                return true;
			}

            if (data < current.data)
                current = current.LeftNode;
            else
                current = current.RightNode;
        }
		
		System.out.println(data + " is present.");
        return false;
    }

	public void printTree() {
        if (head == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
		size=1;	

        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();

            while (nodesAtCurrentLevel > 0) {
                Node node = queue.poll();
                assert node != null;
                System.out.print(node.data + " ");

                if (node.LeftNode != null){
                    size++;
					queue.add(node.LeftNode);
				}

                if (node.RightNode != null){
					size++;
                    queue.add(node.RightNode);}

                nodesAtCurrentLevel--;
            }

            System.out.println();
        }
	}

	public static void main(String[] args) {

        // UC1: Create bst with 56 and then 30 and 70
        Bst tree = new Bst(56);
        tree.add(30);
        tree.add(70);
        tree.printTree();
		tree.size();

		// UC2: Create tree and return size
		tree.add(22);
        tree.add(40);
        tree.add(60);
        tree.add(95);
        tree.add(11);
        tree.add(65);
        tree.add(3);
        tree.add(16);
        tree.add(63);
        tree.add(67);
        tree.printTree();
		tree.size();

		// UC3: Search for a node in the BST
		tree.search(63);
	}
}