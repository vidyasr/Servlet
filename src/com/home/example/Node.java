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
	System.out.println();
}

public void printlist(Node newNode){
	Node curr = newNode.head;
	while(curr!=null){
		System.out.println(curr.data + "->");
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
	node.delete(5);
	node.printlist();
	node.delete(2);
	node.delete(6);
	node.printlist();
	node.push(2);
	node.push(5);
	node.push(6);
	node.printlist();
	node.deleteAtPosition(2);
	node.deleteAtPosition(1);
	node.printlist();
	node.deleteAtPosition(0);
	node.printlist();
	node.push(1);
	node.printlist();
}

private void delete(int data) {
	Node curr = head;
	if(data == curr.data)
	{
		head = curr.next;
		return;
	}
	while(curr.next!= null){
		if(curr.data == data){
		  curr.prev.next = curr.next;
			curr = curr.next;
		}
		else
		 curr = curr.next;
	}
}

private void deleteAtPosition(int position) {
	Node curr = head;
	if(position == 0)
	{
		head = curr.next;
		return;
	}
	int i = 1;
	curr = curr.next;
	while(curr!= null){
		if(i == position){
		  curr.prev.next = curr.next;
			curr = curr.next;
			break;
		}
		else
		 curr = curr.next;
		i++;
	}
}
}
