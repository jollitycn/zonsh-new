package result.vo.comment;

import lombok.Data;

import java.util.Date;

/**
 * @author wangJin
 */
@Data
public class CommentReportDetailResult extends CommentDetailResult{
    private Long arid;
    private String reportTitle;
    private String reportContent;
    private Date createTime;
    private String reportUName;
    private String reportHeadUrl;


}
