package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//MVC 중 Controller
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	//@SelectKey라는 MyBatis의 어노테이션 이용, PK 값을 미리(before) SQL을 통해서 처리해두고 특정한 이름으로 결과 보관
	
	public BoardVO read(Long bno);
	//MyBatis는 Mapper 인터페이스의 리턴타입에 맞게 select의 결과 처리
	//tbl_board의 모든 커럼이 BoardVO의 속성값으로 처리된다.
	
	public int delete(Long bno);
	//리턴 타입 int로 지정하여 정상적으로 데이터가 삭제되면 1 이상의 값을 가지도록 한다.
	
	public int update(BoardVO board);
	//몇 개의 데이터가 수정되었는지를 처리할 수 있도록 int 타입으로 설계
}
