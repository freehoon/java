package com.freehoon.web.menu.dao;

import java.util.List;

import com.freehoon.common.Search;
import com.freehoon.web.menu.model.MenuVO;

public interface MenuDAO {
	public List<MenuVO> getMenuList(Search search) throws Exception;
	
	public int saveMenu(MenuVO menuVO) throws Exception;
	
	public int updateMenu(MenuVO menuVO) throws Exception;
	
	public int deleteMenu(String code) throws Exception;
	
	public int getMenuListCnt(Search search) throws Exception;
}
