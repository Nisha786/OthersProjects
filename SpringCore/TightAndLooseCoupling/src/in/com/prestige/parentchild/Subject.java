package in.com.prestige.parentchild;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Subject {
   private String subjectName;
   public abstract void method();
}
