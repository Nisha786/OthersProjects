package in.com.prestige.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
   private Set<Object> sets;
   private Map<Object,Object> maps;
   private List<Object> list;
}
