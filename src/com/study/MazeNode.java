package com.study;

/**
 * 두 문자열이 애너그램인지 여부 찾기
 * 
 * 조건
 * 1. 문자열의 길이는 자바에서 지원하는 범위
 * 2. 문자의 범위는 a~z (소문자)
 * 3. 입력은 두 문자열(인자)
 * 4. 리턴 타입은 참/거짓
 * @author nunssuby
 *
 */

public class MazeNode {
	public int x;
	public int y;
	public boolean visit;
	
	public MazeNode(int x, int y){
		this.x = x;
		this.y = y;
	}
}
