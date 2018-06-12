package com.zuche.service.comment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zuche.entity.StoreComment;
import com.zuche.entity.StoreCommentExample;
import com.zuche.entity.StoreCommentExample.Criteria;
import com.zuche.mapper.StoreCommentMapper;

/**
 * 门店评论service实现类
 * @author cbl
 *
 */
@Service
public class StoreCommentServiceImpl implements StoreCommentService {
	
	@Autowired
	private StoreCommentMapper storeCommentMapper;

	/**
	 * 保存门店评论
	 */
	@Override
	public void saveComment(StoreComment storeComment) {
		storeCommentMapper.insert(storeComment);
	}

	@Override
	public List<StoreComment> findStoreCommentByCondition(
			Map<String, String> conds) {
		StoreCommentExample storeCommentExample = new StoreCommentExample();
		Criteria criteria = storeCommentExample.createCriteria();
		
		if (conds != null) {
			for (String fieldName : conds.keySet()) {  // 遍历字段名
				String fieldValue = conds.get(fieldName);  // 获得字段对应的值
				if (fieldName != null) {
					if (fieldName.equals("pageNum")) {
						PageHelper.startPage(Integer.parseInt(fieldValue), 5); // 分页
					}
					if (fieldName.equals("id")) {
						criteria.andIdEqualTo(new Integer(fieldValue));  // id
					}
					if (fieldName.equals("userId")) {
						criteria.andUserIdEqualTo(Integer.parseInt(fieldValue));  // 用户id
					}
					if (fieldName.equals("storeId")) {
						criteria.andStoreIdEqualTo(Integer.parseInt(fieldValue));  // 门店id
					}
				}
			}
		}
		
		List<StoreComment> existStoreComments = storeCommentMapper.selectByExample(storeCommentExample);
		return existStoreComments;
	}

}
