package com.home.example;

public class Node {

	Node head;
	Node next;
	int data;
	Node prev;


public void push(int n){
	if(head!=null){
		Node curr = head;
		Node node = new Node();
		node.data = n;
		node.next = null;
		while(curr.next!= null){
			curr = curr.next;
		}
		curr.next = node;
		node.prev = curr;
	}
	else{
		head = new Node();
		head.data = n;
		head.next = null;
		}
}

public void printlist(){
	Node curr = head;
	while(curr!=null){
		System.out.print(curr.data + "->");
		curr = curr.next;
	}
}

public void printlist(Node newNode){
	Node curr = newNode.head;
	while(curr!=null){
		System.out.print(curr.data + "->");
		curr = curr.next;
	}
}
public void reverse(){
	Node newNode = new Node();
	Node curr = head;
	while(curr!= null){
		newNode.prev = curr.next;
		newNode = curr;
		newNode.next = curr.prev;
		if(curr.next == null)
			newNode.head = curr;
		curr = curr.next;
}
	newNode.printlist();
}
public static void main(String args[]){
	Node node = new Node();
	node.push(2);
	node.push(5);
	node.push(6);
	node.printlist();
	node.reverse();
	
}
}
