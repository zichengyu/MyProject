package com.learn.pattern.srp.section1;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * �û���Ϣ����
 */
public interface IUserInfo {

	//����û���ID
	public String getUserID();

	//�����û���ID
	public void setUserID(String userID);

	//����û�������
	public String getPassword();

	//�����û�������
	public void setPassword(String password);

	//����û�������
	public String getUserName();

	//�����û�������
	public void setUserName(String userName);

	//�޸��û�������
	public boolean changePassword(String oldPassword);

	//ɾ���û�
	public boolean deleteUser();

	//�û�ӳ��
	public void mapUser();
}
