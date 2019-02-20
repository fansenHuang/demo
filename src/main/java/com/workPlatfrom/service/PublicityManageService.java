package com.workPlatfrom.service;

import java.util.List;

import com.workPlatfrom.entity.Article;
import com.workPlatfrom.entity.ArticleSection;
import com.workPlatfrom.entity.Viewpager;

/**
 * 宣传管理
 * @author Administrator
 *
 */
public interface PublicityManageService{

	
	List<ArticleSection> selectArticleSectionOneAll();

	
	void andArticleSection(ArticleSection articleSection);


	List<ArticleSection> selectArticleSectionBy(String time, String content);


	void deleteArticleSection(Integer[] intArr);


	ArticleSection selectArticleSectionByID(String iD);


	void updateArticleSection(ArticleSection articleSection);


	List<Article> selectArticleAll();


	List<ArticleSection> selectArticleSectionAll();


	void andArticle(Article article);


	List<Article> selectArticleByArticleSection(Integer articleSectionId);


	List<Article> selectArticleBySearch(String time, String content,Integer articleSectionId);
	
	void deleteArticle(Integer[] intArr);
	
	Article selectArticleByID(String iD);
	
	List<Viewpager> selectViewpagerAll();


	void andViewpager(Viewpager viewpager);


	List<Viewpager> selectViewpagerBySearch(String time, String content);
	
	void deleteViewpager(Integer[] intArr);

	Viewpager selectViewpagerByID(String iD);
}
