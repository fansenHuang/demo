package com.workPlatfrom.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.system.config.ParametersConfig;
import com.workPlatfrom.entity.Article;
import com.workPlatfrom.entity.ArticleSection;
import com.workPlatfrom.entity.Viewpager;
import com.workPlatfrom.service.PublicityManageService;

/**
 * 宣传管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/publicityManage/")
public class PublicityManageController {

	@Autowired
	private PublicityManageService publicityManageService;

	@Autowired
	ParametersConfig config;

	// ---------------------------------------------文章栏目管理------------------------------------------------------------
	// 栏目管理列表 一级
	@RequestMapping("selectArticleSectionAll")
	public String selectArticleSectionAll(String callback) throws JsonProcessingException {

		Integer parentId = 0;// 代表一级栏目
		List<ArticleSection> articleSectionAllList = publicityManageService.selectArticleSectionOneAll();
		
		//ztree 实现 数据需要处理成标准格式 属性名要对应（没对应）
//		ObjectMapper objectMapper = new ObjectMapper();
//		String zTreeJson = objectMapper.writeValueAsString(articleSectionAllList);
		
		Gson gson = new Gson();
		Map resultMap = new HashMap<>();
		resultMap.put("articleSectionAllList", articleSectionAllList);
//		resultMap.put("zTreeJson", zTreeJson);
		
		return callback + "(" + gson.toJson(resultMap) + ")";

	}

	// 添加栏目
	@RequestMapping("andArticleSection")
	public String andArticleSection(ArticleSection articleSection, String callback) {

		publicityManageService.andArticleSection(articleSection);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据时间 or 标题 or createBy搜索
	@RequestMapping("selectArticleSectionBySearch")
	public String selectArticleSectionBySearch(Integer page, String callback, String time, String content) {

		PageHelper.startPage(page, 10);

		List<ArticleSection> articleSectionList = publicityManageService.selectArticleSectionBy(time, content);

		PageInfo<ArticleSection> pageInfo = new PageInfo<ArticleSection>(articleSectionList);

		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);
		// resultMap.put("articleSectionList", articleSectionList);
		return callback + "(" + new Gson().toJson(resultMap) + ")";

	}

	// 删除栏目
	@RequestMapping("deleteArticleSection")
	public String deleteArticleSection(String callback, @RequestParam("ids") String ids) {

		String[] split = ids.split(",");
		Integer[] intArr = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			intArr[i] = Integer.parseInt(split[i]);
		}

		publicityManageService.deleteArticleSection(intArr);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据ID查详情 --- 编辑
	@RequestMapping("selectArticleSectionByID")
	public String selectArticleSectionByID(String callback, String ID) {

		ArticleSection articleSection = publicityManageService.selectArticleSectionByID(ID);
		return callback + "(" + new Gson().toJson(articleSection) + ")";
	}

	// 更新
	@RequestMapping("updateArticleSection")
	public String updateArticleSection(String callback, ArticleSection articleSection) {

		publicityManageService.updateArticleSection(articleSection);
		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// ---------------------------------------------------文章管理-----------------------------------------------

	// 文章列表
	@ResponseBody
	@RequestMapping("selectArticleAll")
	public String selectArticleAll(String callback, Integer page) {

		PageHelper.startPage(page, 10);
		List<Article> articleList = publicityManageService.selectArticleAll();
		PageInfo<Article> pageInfo = new PageInfo<>(articleList);
		List<ArticleSection> articleSectionList = publicityManageService.selectArticleSectionAll();

		Gson gson = new Gson();
		Map resultMap = new HashMap<>();
		// resultMap.put("articleAllList", articleAllList);
		resultMap.put("pageInfo", pageInfo);
		resultMap.put("articleSectionList", articleSectionList);

		return callback + "(" + gson.toJson(resultMap) + ")";

	}

	// 添加栏目
	@RequestMapping("andArticle")
	public String andArticle(Article article, String callback,
			/* MultipartFile file, */ HttpServletRequest request) throws IOException {

		// File file2 = FileUploadUtils.upload(file, config.getUploadFile(),
		// request);

		// article.setImgUrl(file2.getPath());

		publicityManageService.andArticle(article);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据栏目搜索文章
	@RequestMapping("selectArticleByArticleSection")
	public String selectArticleByArticleSection(String callback, Integer page, Integer articleSectionId) {

		PageHelper.startPage(page, 10);
		List<Article> articleList = publicityManageService.selectArticleByArticleSection(articleSectionId);
		PageInfo<Article> pageInfo = new PageInfo<>(articleList);

		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + new Gson().toJson(resultMap) + ")";
	}

	// 查找文章
	@RequestMapping("selectArticleBySearch")
	public String selectArticleBySearch(String callback, Integer page, String time, String content,
			Integer articleSectionId) {

		PageHelper.startPage(page, 10);

		List<Article> articleList = publicityManageService.selectArticleBySearch(time, content, articleSectionId);

		PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);

		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);
		// resultMap.put("articleSectionList", articleSectionList);

		return callback + "(" + new Gson().toJson(resultMap) + ")";
	}

	// 删除文章
	@RequestMapping("deleteArticle")
	public String deleteArticle(String callback, @RequestParam("ids") String ids) {

		String[] split = ids.split(",");
		Integer[] intArr = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			intArr[i] = Integer.parseInt(split[i]);
		}

		publicityManageService.deleteArticle(intArr);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据ID查详情 --- 编辑
	@RequestMapping("selectArticleByID")
	public String selectArticleByID(String callback, String ID) {

		Article article = publicityManageService.selectArticleByID(ID);
		return callback + "(" + new Gson().toJson(article) + ")";
	}

	// ---------------------------------------------------轮播图---------------------------------------------------

	// 轮播图列表
	@ResponseBody
	@RequestMapping("selectViewpagerAll")
	public String selectViewpagerAll(String callback, Integer page) {

		PageHelper.startPage(page, 10);
		List<Viewpager> viewpagerList = publicityManageService.selectViewpagerAll();
		PageInfo<Viewpager> pageInfo = new PageInfo<>(viewpagerList);

		Gson gson = new Gson();
		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + gson.toJson(resultMap) + ")";

	}

	// 添加轮播图
	@RequestMapping("andViewpager")
	public String andViewpager(Viewpager viewpager, String callback,
			/* MultipartFile file, */ HttpServletRequest request) throws IOException {

		// File file2 = FileUploadUtils.upload(file, config.getUploadFile(),
		// request);

		// viewpager.setImgUrl(file2.getPath());

		publicityManageService.andViewpager(viewpager);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 查找文章
	@RequestMapping("selectViewpagerBySearch")
	public String selectViewpagerBySearch(String callback, Integer page, String time, String content) {

		PageHelper.startPage(page, 10);

		List<Viewpager> viewpagerList = publicityManageService.selectViewpagerBySearch(time, content);

		PageInfo<Viewpager> pageInfo = new PageInfo<Viewpager>(viewpagerList);

		Map resultMap = new HashMap<>();
		resultMap.put("pageInfo", pageInfo);

		return callback + "(" + new Gson().toJson(resultMap) + ")";
	}

	//
	// 删除轮播图
	@RequestMapping("deleteViewpager")
	public String deleteViewpager(String callback, @RequestParam("ids") String ids) {

		String[] split = ids.split(",");
		Integer[] intArr = new Integer[split.length];
		for (int i = 0; i < split.length; i++) {
			intArr[i] = Integer.parseInt(split[i]);
		}
		publicityManageService.deleteViewpager(intArr);

		return callback + "(" + new Gson().toJson("success") + ")";
	}

	// 根据ID查详情 --- 编辑
	@RequestMapping("selectViewpagerByID")
	public String selectViewpagerByID(String callback, String ID) {

		Viewpager viewpager = publicityManageService.selectViewpagerByID(ID);
		return callback + "(" + new Gson().toJson(viewpager) + ")";
	}

}
