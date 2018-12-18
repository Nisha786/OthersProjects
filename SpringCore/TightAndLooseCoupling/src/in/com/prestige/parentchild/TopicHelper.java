package in.com.prestige.parentchild;

import in.com.prestige.parentchild.Topic1.InnerTest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicHelper {
    private Topic1 topic1;
    private Topic2 topic2;
    private InnerTest topicInner;
    
    public void shoeRecords(){
    	topic1.method();
    	System.out.println(topic1.getSubjectName()+"---"+topic1.getTopicName());
    	topic2.method();
    	System.out.println(topic2.getSubjectName()+"---"+topic2.getTopicName());
    	topicInner.show();
    	
    }
}
