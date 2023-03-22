package kr.co.codemaker.user.lessoninfo.vo;
/**
* ReviewStarVO.java
*
* @author 우송이
* @version 1.0
* @Since 2020. 12
*
* 수정자 수정내용
* ------ ------------------------
* 수강후기 별점을 조회하기 위한 VO
*
 */
public class ReviewStarVO {

	private int five;	//별점5점
	private int four;	//별점4점
	private int one;	//별점1점
	private int two;	//별점2점
	private int three;	//별점3점
	
	public int getFive() {
		return five;
	}
	public void setFive(int five) {
		this.five = five;
	}
	public int getFour() {
		return four;
	}
	public void setFour(int four) {
		this.four = four;
	}
	public int getOne() {
		return one;
	}
	public void setOne(int one) {
		this.one = one;
	}
	public int getTwo() {
		return two;
	}
	public void setTwo(int two) {
		this.two = two;
	}
	public int getThree() {
		return three;
	}
	public void setThree(int three) {
		this.three = three;
	}
	
	@Override
	public String toString() {
		return "ReviewStarVO [five=" + five + ", four=" + four + ", one=" + one + ", two=" + two + ", three=" + three
				+ "]";
	}
	
}
