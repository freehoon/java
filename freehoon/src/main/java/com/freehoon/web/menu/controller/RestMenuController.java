package com.freehoon.web.menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freehoon.common.Search;
import com.freehoon.web.menu.model.MenuVO;
import com.freehoon.web.menu.service.MenuService;

@RestController
@RequestMapping("/restMenu")
public class RestMenuController {

	private static final Logger logger = LoggerFactory.getLogger(RestMenuController.class);
	
	@Inject
	private MenuService menuService;
	
	@RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
	public Map<String, Object> getMenuList(@RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "code") String searchType
			, @RequestParam(required = false) String keyword
			) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		//전체 게시글 수
		int listCnt = menuService.getMenuListCnt(search);
					
		search.pageInfo(page, range, listCnt);
		result.put("pagination", search);
		
		
		try {
			menuList = menuService.getMenuList(search);
			result.put("status", "OK");
			result.put("menuList", menuList);
		} catch (Exception e) {
			result.put("status",  "False");
			logger.info(e.getMessage());
		}
		
		return result;
	}
	
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	public Map<String, Object> saveMenu(MenuVO menuVO) throws Exception	{
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		logger.info("menuVO : " + menuVO.toString());
		
		try {
			menuService.saveMenu(menuVO);
			result.put("status",  "OK");
		} catch (Exception e) {
			result.put("status",  "False");
			logger.info(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public Map<String, Object> updateMenu(MenuVO menuVO) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			menuService.updateMenu(menuVO);
			result.put("status", "OK");
		} catch (Exception e) {
			result.put("status",  "False");
			logger.info(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public Map<String, Object> deleteMenu(@RequestParam("code") String code) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			menuService.deleteMenu(code);
			result.put("status", "OK");
		} catch (Exception e) {
			result.put("status",  "False");
			logger.info(e.getMessage());
		}
		
		return result;
	}
}
