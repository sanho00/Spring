package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//����¡ ���, sql���� rownum�� ����Ͽ� ���� ����� ��ȣ�� �ο���
//�˻��� ���� (MVC �� Model)
public class Criteria {
	
	private int pageNum;  //������ ��ȣ
	private int amount;   //�� �������� �� ���� ������
	
	private String type;   //�˻� ����
	private String keyword;   //�˻���
	
	//������ => �ʵ��� �ʱⰪ ����
	public Criteria() {
		this(1, 10);  //1�������� 10��
	}
	
	public Criteria(int pageNum, int amount) {   //�ܺο��� ���� ����
		//    �ʵ�   =   �Ű�����
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		
		return type == null ? new String[] {} : type.split("");
	}
}
