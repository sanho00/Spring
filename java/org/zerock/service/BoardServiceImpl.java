package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service    //객체임을 표시
@AllArgsConstructor   //모든 파라미터를 이용하는 생성자를 만든다.
public class BoardServiceImpl implements BoardService {  
	//MVC 중 Controller 사용자 입력 처리, 데이터 연동, 화면 입력 추출
	//인터페이스를 이용해서 *.xml에 의존성 주입
	
	private BoardMapper mapper;   //AllArgsConstructor로 BoardMapper를 주입 받는 생성자가 만들어짐
	
	@Override
	public void register(BoardVO board) {  //등록 작업 구현
		
		log.info("register........." + board);
		
		mapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {    //게시물 조회, 게시물의 번호가 파라미터
		
		log.info("get........" + bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {   //수정 작업
		
		log.info("modify........" + board);
		
		return mapper.update(board) == 1;   //정상적으로 수정되면 1 반환하여 true/false 처리 가능
	}

	@Override
	public boolean remove(Long bno) {   //삭제 작업
		
		log.info("remove........" + bno);
		
		return mapper.delete(bno) == 1;   //정상적으로 삭제되면 1 반환하여 true/false 처리 가능
	}

	/*
	 * @Override public List<BoardVO> getList() { //목록 작업 구현
	 * 
	 * log.info("getList..........");
	 * 
	 * return mapper.getList(); }
	 */

	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("get List with criteria: " + cri);
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}
	
}
