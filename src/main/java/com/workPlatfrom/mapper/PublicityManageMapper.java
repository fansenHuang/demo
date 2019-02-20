package com.workPlatfrom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.workPlatfrom.entity.Article;
import com.workPlatfrom.entity.ArticleSection;
import com.workPlatfrom.entity.Viewpager;

/**
 * 宣传管理
 * 
 * @author Administrator
 *
 */
@Repository
public interface PublicityManageMapper {

	// 查询所有一级栏目
	public List<ArticleSection> selectArticleSectionOneAll();

	// 添加栏目
	public void andArticleSection(ArticleSection articleSection);

	// 根据时间 or 标题 or createBy搜索
	public List<ArticleSection> selectArticleSectionBy(@Param("time") String time, @Param("content") String content);

	// 删除栏目
	public void deleteArticleSection(@Param("ids") Integer[] ids);

	// 根据id查询栏目
	public ArticleSection selectArticleSectionByID(@Param("ID") String iD);

	// 更新
	public void updateArticleSection(ArticleSection articleSection);

	// 查询所有文章
	public List<Article> selectArticleAll();

	// 查询所有栏目
	public List<ArticleSection> selectArticleSectionAll();

	// 添加文章
	public void andArticle(Article article);

	// 根据栏目查询文章
	public List<Article> selectArticleByArticleSection(Integer articleSectionId);

	// 查询文章 by search
	public List<Article> selectArticleBySeach(@Param("time") String time, @Param("content") String content,
			@Param("articleSectionId") Integer articleSectionId);

	// 删除文章
	public void deleteArticle(@Param("ids") Integer[] ids);

	// 根据id查询栏目
	public Article selectArticleByID(@Param("ID") String iD);

	//查询所有的轮播图
	public List<Viewpager> selectViewpager();

	//添加轮播图
	public void andViewpager(Viewpager viewpager);

	//查询轮播图 by search
	public List<Viewpager> selectViewpagerBySeach(@Param("time")String time, @Param("content")String content);

	//删除轮播图
	public void deleteViewpager(@Param("ids")Integer[] ids);

	//轮播图 --- 详情
	public Viewpager selectViewpagerByID(String iD);

}
