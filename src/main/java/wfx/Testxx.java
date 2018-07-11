package wfx;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class Testxx {
	public static void main(String[] args) {
   System.out.println("你好");   
   
   
   
   
	// ������������������Ϣ����
ProcessEngineConfiguration pec = ProcessEngineConfiguration
		.createStandaloneProcessEngineConfiguration();
//�������ݿ������
/*		pec.setDatabaseType("mysql");*/
//���ô������ݿ�ķ�ʽ
//ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE(true): ���û�����ݿ��ͻᴴ�����ݿ���еĻ����޸ı�ṹ. 
//ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE(false): ���ᴴ�����ݿ��
//ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP(create-drop): �ȴ�������ɾ��.
pec.setDatabaseSchemaUpdate("true");
//�������ݿ�����
pec.setJdbcDriver("com.mysql.jdbc.Driver");
//����jdbcURL
pec.setJdbcUrl("jdbc:mysql:///activiti_db?Unicode=true&amp;characterEncoding=UTF-8");
//�����û���
pec.setJdbcUsername("root");
//��������
pec.setJdbcPassword("976362632xx");	
//���������������
ProcessEngine pe = pec.buildProcessEngine(); // ���÷÷����Żᴴ�����ݱ�		
//����close����ʱ���Ż�ɾ��
//pe.close();	
   
	}

}
