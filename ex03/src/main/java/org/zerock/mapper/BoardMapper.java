package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();  //���̺� ���ڵ� Ȯ��
	
	public List<BoardVO> getListWithPaging(Criteria cri);  //������ ��ȣ�� ������ �� ���� ������ ����
	
	public void insert(BoardVO board);  //VO�� ������ ����
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno); //�߻� �޼ҵ� �ݵ�� ������ �Ͽ� ���
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);   //��ü �������� ���� ó��
}