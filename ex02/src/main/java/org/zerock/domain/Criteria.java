package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//페이징 기법, sql문의 rownum을 사용하여 실행 결과에 번호를 부여함
//검색의 기준 (MVC 중 Model)
public class Criteria {
	
	private int pageNum;  //페이지 번호
	private int amount;   //한 페이지에 몇 개의 데이터
	
	private String type;   //검색 조건
	private String keyword;   //검색어
	
	//생성자 => 필드의 초기값 지정
	public Criteria() {
		this(1, 10);  //1페이지에 10개
	}
	
	public Criteria(int pageNum, int amount) {   //외부에서 별도 지정
		//    필드   =   매개변수
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		
		return type == null ? new String[] {} : type.split("");
	}
}
