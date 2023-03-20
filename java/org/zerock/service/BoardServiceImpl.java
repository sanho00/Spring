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
@Service    //��ü���� ǥ��
@AllArgsConstructor   //��� �Ķ���͸� �̿��ϴ� �����ڸ� �����.
public class BoardServiceImpl implements BoardService {  
	//MVC �� Controller ����� �Է� ó��, ������ ����, ȭ�� �Է� ����
	//�������̽��� �̿��ؼ� *.xml�� ������ ����
	
	private BoardMapper mapper;   //AllArgsConstructor�� BoardMapper�� ���� �޴� �����ڰ� �������
	
	@Override
	public void register(BoardVO board) {  //��� �۾� ����
		
		log.info("register........." + board);
		
		mapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {    //�Խù� ��ȸ, �Խù��� ��ȣ�� �Ķ����
		
		log.info("get........" + bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {   //���� �۾�
		
		log.info("modify........" + board);
		
		return mapper.update(board) == 1;   //���������� �����Ǹ� 1 ��ȯ�Ͽ� true/false ó�� ����
	}

	@Override
	public boolean remove(Long bno) {   //���� �۾�
		
		log.info("remove........" + bno);
		
		return mapper.delete(bno) == 1;   //���������� �����Ǹ� 1 ��ȯ�Ͽ� true/false ó�� ����
	}

	/*
	 * @Override public List<BoardVO> getList() { //��� �۾� ����
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
