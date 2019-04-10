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
public interface NoticeMapper {

	/**
	 * 保存新增推送的消息
	 * 
	 * @param notice
	 * @return
	 */
	int saveNotice(Notice notice);

	List<Notice> noticeList(@Param("type") String type, @Param("title") String title, @Param("start") String start,
			@Param("end") String end, @Param("status") Integer status);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	void delAll(@Param("ids")String[] ids);

	/**
	 * 草稿箱到发送
	 * @param id
	 */
	void updateStatusById(@Param("id") String id);

	Notice findNoticeById(@Param("id")String id);
	
}
