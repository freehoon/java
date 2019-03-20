package com.freehoon.web.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.freehoon.web.UploadFile;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.board.service.BoardService;

@RestController
@RequestMapping(value = "/restBoard")
public class RestBoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/getReqlyList", method = RequestMethod.POST)
	public List<ReplyVO> getReplyList(@RequestParam("bid") int bid) throws Exception {
		return boardService.getReplyList(bid);
	}
	
	@RequestMapping(value = "/saveReqly", method = RequestMethod.POST)
	public Map<String, Object> saveReply(@RequestBody ReplyVO replyVO) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			boardService.saveReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/updateReqly", method = RequestMethod.POST)
	public Map<String, Object> updateReply(@RequestBody ReplyVO replyVO) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			boardService.updateReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/deleteReqly", method = RequestMethod.POST)
	public Map<String, Object> deleteReply(@RequestParam("rid") int rid) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			boardService.deleteReply(rid);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public Map<String, Object> uploadImage(MultipartFile file, HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			Map<String, Object> savedFilePath = UploadFile.uploadFile(file, request);
			savedFilePath.get("savedPath");
			
		//	boardService.deleteReply(rid);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	}
	
}
