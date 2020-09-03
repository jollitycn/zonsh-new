package base;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 所有业务交互的实体继承该BaseVO
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/8/7 12:17
 */
@Data
@ApiModel(value = "基础业务BO")
public abstract class BaseBO implements Serializable {

}
