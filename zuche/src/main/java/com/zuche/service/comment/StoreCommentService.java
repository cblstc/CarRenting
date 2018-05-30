package com.zuche.service.comment;

import java.util.List;
import java.util.Map;

import com.zuche.entity.OrdersComment;
import com.zuche.entity.StoreComment;

/**
 * 门店评论service接口
 * @author cbl
 *
 */
public interface StoreCommentService {

	/**
	 * 保存门店评论
	 * @param storeComment
	 */
	void saveComment(StoreComment storeComment);

	/**
	 * 条件查询门店评论
	 * @param conds
	 * @return
	 */
	List<StoreComment> findStoreCommentByCondition(Map<String, String> conds);
}
