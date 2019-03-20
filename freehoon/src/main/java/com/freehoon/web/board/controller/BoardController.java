package com.freehoon.web.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freehoon.common.Search;
import com.freehoon.common.Util;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.board.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Value("#{datasource['jdbc.username']}")
	private String username;
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "title") String searchType
			, @RequestParam(required = false) String keyword
		//	, @RequestParam(required = false, defaultValue = "10") int pageSize
		//	, @RequestParam(required = false, defaultValue = "10") int rangeSize
			) throws Exception {
		
		logger.info("jdbc.username : " + username);
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		//전체 게시글 수
		int listCnt = boardService.getBoardListCnt(search);
				
		//Pagination pagination = new Pagination(curPage, curRange, pageSize, rangeSize, listCnt);
		//search.setPagination(new Pagination(page, range, listCnt));
		search.pageInfo(page, range, listCnt);
		
		//Pagination pagination = new Pagination(page, range, listCnt);

		
		model.addAttribute("pagination", search);
		model.addAttribute("boardList", boardService.getBoardList(search));
		return "board/index";
	}
	
	@RequestMapping(value = "/boardForm", method = RequestMethod.GET)
	public String boardForm(Model model) throws Exception {
		model.addAttribute("boardVO", new BoardVO());
		return "board/boardForm";
	}
	
	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {
		
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("replyVO", new ReplyVO());
		return "board/boardContent";
	}
	
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public String saveBoard(@ModelAttribute("boardVO") BoardVO boardVO
			, @RequestParam("mode") String mode
			, RedirectAttributes rttr) throws Exception {
		
		if (mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		} else {
			boardService.insertBoard(boardVO);
		}

		return "redirect:/board/getBoardList";
	}
	
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(@RequestParam("bid") int bid, @RequestParam("mode") String mode, Model model) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());
		return "board/boardForm";
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(Model model, @ModelAttribute("BoardVO") BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		boardService.updateBoard(boardVO);
		return "redirect:/board/getBoardList";
	}
	
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {
		boardService.deleteBoard(bid);
		return "redirect:/board/getBoardList";
	}
	
//	@ExceptionHandler(RuntimeException.class)
//	public String handleException(Model model, Exception e) {
//		logger.info("exception : " + e.getMessage());
//		model.addAttribute("exception", e);
//		return "error/exception";
//	}

}
