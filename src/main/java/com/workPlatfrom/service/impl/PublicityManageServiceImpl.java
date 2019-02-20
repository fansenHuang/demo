package com.workPlatfrom.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.User;
import com.workPlatfrom.entity.Article;
import com.workPlatfrom.entity.ArticleSection;
import com.workPlatfrom.entity.Viewpager;
import com.workPlatfrom.mapper.PublicityManageMapper;
import com.workPlatfrom.service.PublicityManageService;

/**
 * 宣传管理
 * 
 * @author Administrator
 *
 */
@Service
public class PublicityManageServiceImpl implements PublicityManageService {

	@Autowired
	private PublicityManageMapper publicityManageMapper;

	// 查询所有栏目
	@Override
	public List<ArticleSection> selectArticleSectionOneAll() {

		return publicityManageMapper.selectArticleSectionOneAll();

	}

	// 添加文章栏目
	@Override
	public void andArticleSection(ArticleSection articleSection) {

		User user = (User) SecurityUtils.getSubject().getPrincipal();

		articleSection.setCreateBy("admin");
		articleSection.setCreateTime(new Date());
		publicityManageMapper.andArticleSection(articleSection);

	}

	// 根据时间 or 标题 or createBy搜索
	@Override
	public List<ArticleSection> selectArticleSectionBy(String time, String content) {

		return publicityManageMapper.selectArticleSectionBy(time, content);

	}

	// 删除栏目
	@Override
	public void deleteArticleSection(Integer[] intArr) {

		publicityManageMapper.deleteArticleSection(intArr);

	}

	// 根据ID查详情
	@Override
	public ArticleSection selectArticleSectionByID(String iD) {

		return publicityManageMapper.selectArticleSectionByID(iD);
	}

	// 更新
	@Override
	public void updateArticleSection(ArticleSection articleSection) {

		User user = (User) SecurityUtils.getSubject().getPrincipal();

		// articleSection.setUpdateBy(user.getUsername());
		articleSection.setUpdateTime(new Date());
		publicityManageMapper.updateArticleSection(articleSection);
	}

	// 查询所有文章
	@Override
	public List<Article> selectArticleAll() {

		return publicityManageMapper.selectArticleAll();
	}

	// 查询所有的栏目
	@Override
	public List<ArticleSection> selectArticleSectionAll() {
		return publicityManageMapper.selectArticleSectionAll();
	}

	// 添加文章
	@Override
	public void andArticle(Article article) {

		User user = (User) SecurityUtils.getSubject().getPrincipal();

		// article.setCreateBy(user.getUsername());
		article.setCreateTime(new Date());
		publicityManageMapper.andArticle(article);

	}

	// 查询文章 by 栏目
	@Override
	public List<Article> selectArticleByArticleSection(Integer articleSectionId) {

		return publicityManageMapper.selectArticleByArticleSection(articleSectionId);
	}

	// 查询文章 by search
	@Override
	public List<Article> selectArticleBySearch(String time, String content, Integer articleSectionId) {

		return publicityManageMapper.selectArticleBySeach(time, content, articleSectionId);
	}

	// 删除文章
	@Override
	public void deleteArticle(Integer[] intArr) {

		publicityManageMapper.deleteArticle(intArr);

	}

	// 根据ID查详情
	@Override
	public Article selectArticleByID(String iD) {

		return publicityManageMapper.selectArticleByID(iD);
	}

	@Override
	public List<Viewpager> selectViewpagerAll() {

		return publicityManageMapper.selectViewpager();
	}

	// 添加文章栏目
	@Override
	public void andViewpager(Viewpager viewpager) {

		User user = (User) SecurityUtils.getSubject().getPrincipal();

		// articleSection.setCreateBy("admin");
		viewpager.setCreateTime(new Date());
		publicityManageMapper.andViewpager(viewpager);

	}

	//搜索 viewpager
	@Override
	public List<Viewpager> selectViewpagerBySearch(String time, String content) {
		
		return publicityManageMapper.selectViewpagerBySeach(time, content);
	}

	//删除轮播图
	@Override
	public void deleteViewpager(Integer[] intArr) {
		
		publicityManageMapper.deleteViewpager(intArr);
		
	}

	//详情 
	@Override
	public Viewpager selectViewpagerByID(String iD) {
		
		return publicityManageMapper.selectViewpagerByID(iD);
	}

}
