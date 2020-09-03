package result.vo.admin;

import java.util.Date;
import lombok.Data;

import java.io.Serializable;

@Data
public class BulletinResult implements Serializable {
    private Long bnid;
    private String number;
    private String bulletinTitle;
    private String bulletinContent;
    private Integer browseCount;
    private Integer status;
    private Date releaseTime;


}
