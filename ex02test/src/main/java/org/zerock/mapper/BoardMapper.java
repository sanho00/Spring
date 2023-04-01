package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//MVC �� Controller
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	//@SelectKey��� MyBatis�� ������̼� �̿�, PK ���� �̸�(before) SQL�� ���ؼ� ó���صΰ� Ư���� �̸����� ��� ����
	
	public BoardVO read(Long bno);
	//MyBatis�� Mapper �������̽��� ����Ÿ�Կ� �°� select�� ��� ó��
	//tbl_board�� ��� Ŀ���� BoardVO�� �Ӽ������� ó���ȴ�.
	
	public int delete(Long bno);
	//���� Ÿ�� int�� �����Ͽ� ���������� �����Ͱ� �����Ǹ� 1 �̻��� ���� �������� �Ѵ�.
	
	public int update(BoardVO board);
	//�� ���� �����Ͱ� �����Ǿ������� ó���� �� �ֵ��� int Ÿ������ ����
}
