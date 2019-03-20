package com.freehoon.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"classpath:spring/root-context.xml",
		"classpath:spring/servlet-context.xml",
		"classpath:spring/dataSource-context.xml"
		})
public class TxServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(TxServiceTest.class);
	
	@Inject
	private BoardService boardService;
	
	@Test 
	public void testGetBoardContent() throws Exception {
		boardService.getBoardContent(2);
		
	}
}