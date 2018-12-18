package in.com.prestige.autodetectcollection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuetionDTO {
   private Integer questionId;
   private String name;
   private Map answers;
   private UserDTO user1;
   private UserDTO user2;
   
   public void showInfo(){
	   AnswerDTO ans ;
	   UserDTO user;
	   System.out.println("QuestionId : "+questionId);
	   System.out.println("QuestionName : "+name);
	   Set s = answers.entrySet();
	   Iterator it = s.iterator();
	   while(it.hasNext()){
		   Map.Entry pair = (Map.Entry)it.next();
		   user = (UserDTO)pair.getKey();
		   ans = (AnswerDTO)pair.getValue();
		   System.out.println(user.getUserId()+"---"+user.getUserName()+"---"+user.getEmail());
		   System.out.println("Answers : "+ans.getAnswerId()+"---"+ans.getAnswers()+"---"+ans.getPostedDate());
	   }
   }
}
