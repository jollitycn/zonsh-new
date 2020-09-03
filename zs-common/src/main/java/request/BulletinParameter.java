package request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 王进
 */
@Data
public class BulletinParameter implements Serializable {
    private Integer status;
    private String bulletinTitle;
    private String bulletinContent;
}
