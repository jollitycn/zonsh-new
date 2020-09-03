package user.service.impl;

import constant.Constant;
import enums.MessageTypeEnum;
import enums.ReadStatusEnum;
import enums.SourceTypeEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import request.PageParam;
import request.user.RpcBulletinMessageParameter;
import result.vo.message.*;
import user.entity.Message;
import user.mapper.MessageMapper;
import user.service.IMessageService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xc
 * @since 2019-06-28
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

	@Override
	public List<MessageTypeResult> getMessageType(Long uid) {
		/*分别查询每个类型的最新消息
		1 小助手消息 assistant
		2邀请消息 invitation
		3评论消息
		4关注消息
		*/
		List<MessageTypeResult> result=new ArrayList<>();
		MessageTypeResult assistant=baseMapper.getAssistantMessage();
		if(null==assistant){
			assistant=new MessageTypeResult();
		}
		
		MessageTypeResult invitation=baseMapper.getInvitationMessage(uid);
		if(invitation!=null){
			//获取话题id
			Long tid=invitation.getRelationId();
			//查询该话题有多少人邀请，是否有官方
			List<String> title= baseMapper.getInvitationMessageCount(uid,tid);
			String titleStr="无";
			if(title.size()==1){
				titleStr="重拾官方邀请您回答";
			}else{
				titleStr=title.get(0)+"、"+title.get(1)+"等"+title.size()+"人邀请您回答";
			}
			invitation.setMessageTitle(titleStr);
		}else{
			invitation=new MessageTypeResult();
		}
		
		MessageTypeResult comment=baseMapper.getCommentMessage(uid);
		if(null==comment){ 
			comment=new MessageTypeResult();
		}
		
		MessageTypeResult follow=baseMapper.getfollowMessage(uid);
		if(null==follow){ 
			follow=new MessageTypeResult();
		}
		
		result.add(assistant);
		result.add(invitation);
		result.add(comment);
		result.add(follow);
//		List<MessageTypeResult> query=baseMapper.getMessageType(uid);
//		result.addAll(query);
		return result;
	}

	@Override
	public Page<MessageResult> getMessageList(Long uid, Integer type, Integer pageNum, Integer pageSize) {
		Page<MessageResult> page = new Page<>(pageNum, pageSize);
		if(type.intValue()==2){
			List<MessageResult> result= baseMapper.getMessageList(page,uid);
			for (MessageResult messageResult : result) {
				Long tid=messageResult.getRelationId();
				//查询该话题有多少人邀请，是否有官方
				List<String> title= baseMapper.getInvitationMessageCount(uid,tid);
				String titleStr="无";
				if(title.size()==1){
					titleStr=title.get(0)+"邀请您回答";
				}else{
					titleStr=title.get(0)+"、"+title.get(1)+"等"+title.size()+"人邀请您回答";
				}
				messageResult.setMessageTitle(titleStr);
			}
			return page.setRecords(result);
		}
		return null;
	}

	@Override
	public Boolean delMessage(Long uid, Integer type) {
		EntityWrapper< Message> wrapper=new EntityWrapper<>();
		wrapper.eq("type", type);
		wrapper.eq("from_uid", uid);
		baseMapper.delete(wrapper);
		return true;
	}

	@Override
	public Boolean readMessage(Long uid, Long relationId, Integer type) {
		Message entity=new Message();
		entity.setIsView(1);
		
		EntityWrapper< Message> wrapper=new EntityWrapper<>();
		wrapper.eq("from_uid", uid);
		wrapper.eq("type", type);
		wrapper.eq("relation_id", relationId);
		baseMapper.update(entity, wrapper);
		return true;
	}

	@Override
	public Boolean addMessage(RpcBulletinMessageParameter param) {
		Message message = new Message();
		BeanUtils.copyProperties(param, message);
		Integer isSuccess = baseMapper.insert(message);
		if(isSuccess!=null&&isSuccess>0){
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteBulletinMessage(Long bnid, Long type) {
		EntityWrapper< Message> wrapper=new EntityWrapper<>();
		wrapper.eq("type", type);
		wrapper.eq("relation_id", bnid);
		Integer isSuccess = baseMapper.delete(wrapper);
		if(isSuccess!=null&& isSuccess>0){
			return true;
		}
		return false;
	}

	@Override
	public Page<InteractiveMessageResult> listInteractivePage(PageParam pageParam, Long loginUid) {
		Page<InteractiveMessageResult> page = new Page<>(pageParam.getPageNum(),pageParam.getPageSize());
		page.setRecords(baseMapper.listInteractivePage(page, loginUid));
		return page;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Page<FollowMessageResult> listFollowPage(PageParam pageParam, Long loginUid) {
		Page<FollowMessageResult> page = new Page<>(pageParam.getPageNum(),pageParam.getPageSize());
		page.setRecords(baseMapper.listFollowPage(page, loginUid));

		// 无数据直接返回
		if (page.getTotal() == Constant.SYSTEM_ZERO_LONG) {
			return page;
		}

		// 查询完之后将所有标记为已读
		Message update = new Message();
		update.setIsView(ReadStatusEnum.HAS_READ.getStatus());
		EntityWrapper<Message> wrapper = new EntityWrapper<>();
		wrapper.eq("type", MessageTypeEnum.FOLLOW.getType()).eq("from_uid", loginUid);
		baseMapper.update(update, wrapper);

		return page;
	}

	@Override
	public Page<HelperMessageResult> listHelperPage(PageParam pageParam, Long loginUid) {
		Page<HelperMessageResult> page = new Page<>(pageParam.getPageNum(),pageParam.getPageSize());
		page.setRecords(baseMapper.listHelperPage(page, loginUid));
		return page;
	}


}
