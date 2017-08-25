package com.ecs.example;

/**
 * @author vutran
 *
 */
public class Network {

	private int[] nodes;
	private int[][] connections;
	private int[] labels;
	

	private int numberOfElements;
	public Network(int numberOfElements) throws Exception{
		if (numberOfElements < 1){
			throw new Exception("Number of element must be greater than 0");
		}
		this.numberOfElements = numberOfElements;
		nodes = new int[numberOfElements];
		connections = new int[numberOfElements][numberOfElements];
		for (int i=0; i < this.numberOfElements ;i++){
			nodes[i]= i+1;
			for (int j=0; j < this.numberOfElements; j++){
				connections[i][j] =0;
			}
		}
	}
	
	public void connect(int element1, int element2) throws Exception{
		
		if (!isValidElement(element1)){
			throw new Exception(String.format( "Invalid element: %s ", element1));
		}
		
		if (!isValidElement(element2)){
			throw new Exception(String.format( "Invalid element: %s ", element2));
		}
		connections[element1-1][element2-1] = 1;
		connections[element2-1][element1-1] = 1;
		
	}
	
	public boolean query(int element1, int element2) throws Exception{
		if (!isValidElement(element1)){
			throw new Exception(String.format( "Invalid element: %s ", element1));
		}
		
		if (!isValidElement(element2)){
			throw new Exception(String.format( "Invalid element: %s ", element2));
		}
		scanConnections();
		return labels[element1 -1] == labels[element2 -1];
	}
	
	private void scanConnections(){
		labels = new int[numberOfElements];
		for (int i=0; i < numberOfElements ;i++){
			labels[i] = 0;
		}
		
		int label = 0;
		for (int i=0; i < numberOfElements ;i++){
			if (labels[i] == 0){
				label += 1;
				
				visit(i,label);
				
			}
		}
		
//		System.out.println("======================");
//		for (int i=0; i < numberOfElements ;i++){
//			System.out.print(i+1+ " "); 
//		}
//		System.out.println();
//		for (int i=0; i < numberOfElements ;i++){
//			System.out.print(labels[i] + " "); 
//		}
	}
	
	private void visit(int i, int label){
		labels[i] = label;
		for (int j=0; j < numberOfElements ;j++){
			if (connections[i][j] ==1 ){
				if (labels[j] == 0 ){
					visit(j,label);
				}
			}
		}
	}
	
	
	public void printNodes(){
		StringBuilder nodeBuilder = new StringBuilder();
		for (int node: nodes){
			nodeBuilder.append(node + " ");
			
		}
		System.out.println("DEBUG INFO:");
		System.out.println(nodeBuilder.toString());
		System.out.println("==================================");
		for (int i=0; i < this.numberOfElements ;i++){
			nodes[i]= i+1;
			String line = "";
			for (int j=0; j < this.numberOfElements; j++){
				line += connections[i][j] + " ";
			}
			System.out.println(line);
		}
		System.out.println("==================================");
		
	}
	
	
	private boolean isValidElement(int element){
		return (element > 0 && element<= this.numberOfElements)? true: false;
	}
	

}
