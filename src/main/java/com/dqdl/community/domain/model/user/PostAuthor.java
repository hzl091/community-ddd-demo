/**
 * 
 */
package com.dqdl.community.domain.model.user;

import com.dqdl.community.constant.ExceptionCode;
import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.exception.BusinessException;

/**
 * 帖子作者
 * @author DAOQIDELV
 * @CreateDate 2017年9月16日
 *
 */
public class PostAuthor extends User{
	
	public PostAuthor(long id) {
		super(id);
	}
	/**
	 * 发布帖子
	 * @param title
	 * @param sourceContent
	 * @return Post 发布得到的帖子
	 */
	public Post posting(String title, String sourceContent) throws BusinessException {
		if(sourceContent.length() < 16) {
			throw new BusinessException(ExceptionCode.POST_SOURCE_CONTENT_AT_LEAST_SIXTEEN_WORDS); //抛出业务异常
		}
		Post post = new Post(this.getId(), title, sourceContent);
		return post;
	}

}
