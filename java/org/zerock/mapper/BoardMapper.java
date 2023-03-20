package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();  //테이블 레코드 확인
	
	public List<BoardVO> getListWithPaging(Criteria cri);  //페이지 번호와 페이지 당 들어가는 데이터 개수
	
	public void insert(BoardVO board);  //VO에 데이터 삽입
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno); //추상 메소드 반드시 재정의 하여 사용
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);   //전체 데이터의 개수 처리
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
