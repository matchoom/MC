package ph.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.service.QnABoardService;
import ph.service.BoardVO;
import ph.service.MembersService;
import ph.service.MembersVO;

@Controller
public class QnABoardController {
	
	@Resource(name = "memberService")
	private MembersService service;
	
	@Resource(name="QnAboardService")
	private QnABoardService qnAboardService; 
	
	@RequestMapping("freeboard.do")
	public String board(HttpSession session, HttpServletRequest request,Model model,MembersVO membersVo,BoardVO boardVo) throws Exception {
		String memberId ="";
		session = request.getSession();
		memberId = (String) session.getAttribute("SessionMemberId");	
		session.setAttribute("SessionMemberId",memberId);
		List<MembersVO> membersList = service.selectMembers(membersVo);
		System.out.println("qweqwe");
		List<BoardVO> boardList = qnAboardService.qnABoardList(boardVo);
		System.out.println(boardList);
		model.addAttribute("memberList", membersList);
		model.addAttribute("boardList",boardList);
		return "QnAboard/QnA";
	}
	
	@RequestMapping(value="insert.do",method = RequestMethod.GET)
	public String insert(HttpSession session, HttpServletRequest request,Model model) throws Exception {
		String memberId ="";
		session = request.getSession();
		memberId = (String) session.getAttribute("SessionMemberId");	
		session.setAttribute("SessionMemberId",memberId);
		//model.addAttribute("boardSelect", boardService.selectBoard(boardNo));
		model.addAttribute("memberSelect", service.selectMember(memberId));
		
		return "QnAboard/insertBoard";
	}
	
	@RequestMapping(value="ins.do", method = RequestMethod.POST)
	public String ins(BoardVO boardVo) {
		System.out.println("123123");
		qnAboardService.QnABoardInsert(boardVo);
		System.out.println("asfasf");
		
		return "QnAboard/QnA";
	}
}
