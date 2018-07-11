package wfx;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestxxxAc {
	public static ApplicationContext ct; 
	public static void main(String[] args) {
	    ct =new  ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) ct.getBean("dataSource");
		System.out.println(dataSource);
	    System.out.println("你好");
//	    TestxxxAc test = new TestxxxAc();
//	    test.deplo();
//	    test.deleplo();
//	    test.runplo();
//	    test.queryMyTask();
//	    test.completeTask();
//	    test.variables();
//	    test.getvariables();
//	    test.historyService();
	    
	}
	
	public void deplo(){
	    RepositoryService repositoryService =(RepositoryService) ct.getBean("repositoryService");
	     Deployment deployment =  (Deployment) repositoryService.createDeployment()
	    		                                             .name("部署流程定义名称")
			                                                 .addClasspathResource("MyProcess.bpmn")
			                                                 .addClasspathResource("MyProcess.png")
			                                                 .deploy();
	        System.out.println(deployment.getId() +"     "  + deployment.getName());    
	}
	
	
	public void deleplo(){
	    RepositoryService repositoryService =(RepositoryService) ct.getBean("repositoryService");
		repositoryService.deleteDeployment("15001");
		
		
	}
	
	
	public void runplo(){
		Map<String,Object>  var = new HashMap<String,Object>();
		var.put("userId1", "张三");
		var.put("userId2", "李四");
	    RuntimeService runtimeService  = (RuntimeService) ct.getBean("runtimeService");
//        ProcessInstance  processInstance  = runtimeService.startProcessInstanceByKey("hellowordvariable");
        ProcessInstance  processInstance  = runtimeService.startProcessInstanceByKey("hellowordvariable", var);
		System.out.println("pid:" +  processInstance.getId() +"ActivityId:"+processInstance.getActivityId());
	}
	
	public void queryMyTask(){
		String assignee = "李四";
	    TaskService taskService =  (TaskService) ct.getBean("taskService");
        List<Task> tasks = taskService.createTaskQuery()
        		                       .taskAssignee(assignee)
        		                       .list();
		for(Task task:tasks){
			
			System.out.println("taskId:"+ task.getId() +"taskName"+task.getName());
			System.out.println("*************************");
		}
		
	}
	
	public void variables(){
		 String taskId="65002";
		  TaskService taskService =  (TaskService) ct.getBean("taskService");
		  taskService.setVariable(taskId, "请假天数", 5);

	}
	
	public void getvariables(){
		 String taskId="65002";
		  TaskService taskService =  (TaskService) ct.getBean("taskService");
		Object xx=  taskService.getVariable(taskId, "请假天数");
         System.out.println(xx);
	}
	
	
	
	
	
	public void completeTask(){
		String taskId="65002";
	    TaskService taskService =  (TaskService) ct.getBean("taskService");
        taskService.complete(taskId);
        System.out.println("完成个人任务办理");
		
	}
	
	public void historyService(){
		HistoryService historyService =   (HistoryService) ct.getBean("historyService");
	String kk=	historyService.createHistoricVariableInstanceQuery()
		              .processInstanceId("20001")
		              .variableName("请假天数").singleResult().toString();
	System.out.println(kk);
		
		
/*	List< HistoricVariableInstance> s=	historyService.createHistoricVariableInstanceQuery()
		             .processInstanceId("20001")
		              .list();
        System.out.println("完成个人任务办理");
     if(s!=null&&s.size()>0){
    	 for(HistoricVariableInstance k:s){
    		 System.out.println(k.getProcessInstanceId() + "    " +k.getVariableName()+ "    " +k.getValue());
    		 
    		 
    	 }
    	 
    	 
     }*/
        
        
        
		
	}
	

}
 