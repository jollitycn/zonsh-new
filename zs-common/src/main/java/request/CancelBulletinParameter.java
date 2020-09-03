package request;

import lombok.Data;

import java.io.Serializable;

@Data
public class CancelBulletinParameter implements Serializable {
    private Long bnid;
    private Integer status;
}
