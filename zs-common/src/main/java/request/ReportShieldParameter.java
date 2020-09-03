package request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ReportShieldParameter implements Serializable {
    @NotNull(message="id不能为空")
    private Long id;
    @NotNull(message="状态不能为空")
    private Integer status;
}
