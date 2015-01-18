package com.study;

/**
 * 5 by 5 미로찾기 문
 * 
 * 조건
 * 정답은 한개만 찾으면 된다.

   풀이
   MazeNode.java라는 파일 하나 필요
   1. loof를 통한 방법
   2. recursive 통한 방법  
 * @author nunssuby
 *
 */
import java.util.Stack;

public class Maze {
	int[][] path = {	{0,0,0,0,0,0,0},
						{0,1,1,1,1,1,0},
						{0,1,0,0,0,1,0},
						{0,1,1,0,0,1,0},
						{0,1,1,1,1,1,0},
						{0,1,1,1,0,1,0},
						{0,0,0,0,0,0,0}
					};
	boolean[][] visit = new boolean[7][7];
	public Stack<MazeNode> searchPathByLoof(){
		Stack<MazeNode> stack = new Stack<MazeNode>();
		MazeNode mazeNode = new MazeNode(1,1);
		visit[1][1] = true;
		stack.push(mazeNode);
		
		while(stack.peek().x != 5 || stack.peek().y !=5){
			MazeNode node = stack.peek();
			
			//System.out.println("x,y : "+ node.x + node.y);
			
			//손 코딩을 하게 되면 확실히 결과가 조잡해짐. 이를 극복할 방법은?
			if((path[node.x+1][node.y]==1) && (visit[node.x+1][node.y]==false)){
				MazeNode newNode = new MazeNode(node.x+1,node.y);
				visit[node.x+1][node.y] = true;
				stack.push(newNode);
			} else if ((path[node.x-1][node.y]==1) && (visit[node.x-1][node.y]==false)){
				MazeNode newNode = new MazeNode(node.x-1,node.y);
				visit[node.x-1][node.y] = true;
				stack.push(newNode);
			}  else if ((path[node.x][node.y-1]==1) && (visit[node.x][node.y-1]==false)){
				MazeNode newNode = new MazeNode(node.x,node.y-1);
				visit[node.x][node.y-1] = true;
				stack.push(newNode);
			}  else if ((path[node.x][node.y+1]==1) && (visit[node.x][node.y+1]==false)){
				MazeNode newNode = new MazeNode(node.x,node.y+1);
				visit[node.x][node.y+1] = true;
				stack.push(newNode);
			} else {
				//newNode.visit = true;
				stack.pop();
			}
		}
		
		return stack;
	}
	
	public Stack<MazeNode> searchPathByRecursive(Stack<MazeNode> stack){
		MazeNode node = stack.peek();
		if(node.x==5 && node.y==5)
			return stack;
		//System.out.println("x,y : "+ node.x + node.y);
		
		//손 코딩을 하게 되면 확실히 결과가 조잡해짐. 이를 극복할 방법은?
		if((path[node.x+1][node.y]==1) && (visit[node.x+1][node.y]==false)){
			MazeNode newNode = new MazeNode(node.x+1,node.y);
			visit[node.x+1][node.y] = true;
			stack.push(newNode);
		} else if ((path[node.x-1][node.y]==1) && (visit[node.x-1][node.y]==false)){
			MazeNode newNode = new MazeNode(node.x-1,node.y);
			visit[node.x-1][node.y] = true;
			stack.push(newNode);
		}  else if ((path[node.x][node.y-1]==1) && (visit[node.x][node.y-1]==false)){
			MazeNode newNode = new MazeNode(node.x,node.y-1);
			visit[node.x][node.y-1] = true;
			stack.push(newNode);
		}  else if ((path[node.x][node.y+1]==1) && (visit[node.x][node.y+1]==false)){
			MazeNode newNode = new MazeNode(node.x,node.y+1);
			visit[node.x][node.y+1] = true;
			stack.push(newNode);
		} else {
			//newNode.visit = true;
			stack.pop();
		}
		searchPathByRecursive(stack);
		return stack;
	}
	
	public static void main(String[] args){
		Maze maze = new Maze();
//		Stack<MazeNode> stack = maze.searchPathByLoof();
		Stack<MazeNode> stack = new Stack<MazeNode>();
		MazeNode mazeNode = new MazeNode(1,1);
		maze.visit[1][1] = true;
		stack.push(mazeNode);
		stack = maze.searchPathByRecursive(stack);
		
		
		while(!stack.isEmpty()){
			MazeNode result = stack.pop();
			System.out.println("x,y : "+ result.x + result.y);
		}
		
		//System.out.println(stack.peek().x);
		
		//System.out.println(maze.path[5][2]);
	}
	
}
