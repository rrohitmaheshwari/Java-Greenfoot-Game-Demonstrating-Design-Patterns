import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Composite here.
 * 
 * @author Saket Relan
 */
public class Composite extends Component
{
  
    private List<Component> childs;
    
    public Composite(){
        childs = new ArrayList<Component>();
    }
    
    public void addChild(Component c) {
        childs.add(c);
    }
    
    public void removeChild(Component c) {
        childs.remove(c);
    }
    
    public Component getChild(int i) {
        return childs.get(i);
    }
    
    public List<Component> getAllChild(){
        return childs;
    }
    
    public void setFasterFlag(){
        for(Component eachChild: childs){
            eachChild.setFasterFlag();
        }
    }
    public void unsetFasterFlag() {
       for(Component eachChild: childs){
            eachChild.unsetFasterFlag();
        }
    }
    public void addCoinScore() {}
}
