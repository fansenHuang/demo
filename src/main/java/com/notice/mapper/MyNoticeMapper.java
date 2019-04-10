package com.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.notice.entity.Notice;

/**
 * 
 * @author wendong
 *
 *         2019年3月30日
 */
@Repository
public interface MyNoticeMapper {

	/**
	 * 我的通知
	 * 
	 * @param type
	 * @param title
	 * @param start
	 * @param end
	 * @param status
	 * @return
	 */
	List<Notice> myNoticeList(@Param("type") String type, @Param("title") String title, @Param("start") String start,
			@Param("end") String end, @Param("status") Integer status, @Param("uid") Integer uid);

	void insertUserNotice(@Param("nid") Integer nid, @Param("uid") Integer uid, @Param("status") Integer status);

	/**
	 * 删除我的通知
	 * 
	 * @param ids
	 */
	void updateMyNoticeStatus(@Param("ids") String[] ids);

	Integer findUserNoticeById(@Param("nid") String id, @Param("uid") String uid);

	void delAll(@Param("ids") String[] ids);

}
