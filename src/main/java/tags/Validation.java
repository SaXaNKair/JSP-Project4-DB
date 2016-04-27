package tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
/**
 * Created by admin on 4/21/16.
 */
public class Validation extends TagSupport{
    private String target;

    @Override
    public int doStartTag() throws JspException {
        try {
            if (target.length() == 0){
                return EVAL_BODY_INCLUDE;
            }else{
                return SKIP_BODY;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }


}
