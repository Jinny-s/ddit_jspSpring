package com.spring.pointcut;

public class BehaviorImpl implements Behavior {

	@Override
	public void 잠자기() {
		System.out.println("자라");
	}

	@Override
	public void 공부하기() {
		System.out.println("공부해라");
	}

	@Override
	public void 밥먹기() {
		System.out.println("냠냠쩝쩝");
	}

	@Override
	public void 데이트() {
		System.out.println("서울갈거야ㅏㅏㅏ");
	}

	@Override
	public void 운동() {
		System.out.println("숨쉬기 운동 쓰읍하아");
	}

	@Override
	public void 놀기() {
		System.out.println("유툽보기");
	}

	@Override
	public void 정신수양() {
		System.out.println("누워서 정신수양");
	}

}
