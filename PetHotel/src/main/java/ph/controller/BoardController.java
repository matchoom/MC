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

import ph.service.BoardService;
import ph.service.BoardVO;
import ph.service.MembersService;
import ph.service.MembersVO;

@Controller
public class BoardController {
	
	@Resource(name = "memberService")
	private MembersService service;
	
	@Resource(name="boardService")
	private BoardService boardService; 
	
	@RequestMapping("freeboard.do")
	public String board(HttpSession session, HttpServletRequest request,Model model,MembersVO membersVo,BoardVO boardVo) throws Exception {
		String memberId ="";
		session = request.getSession();
		memberId = (String) session.getAttribute("SessionMemberId");	
		session.setAttribute("SessionMemberId",memberId);
		List<MembersVO> membersList = service.selectMembers(membersVo);
		List<BoardVO> boardList = boardService.boardList(boardVo);
		model.addAttribute("memberList", membersList);
		model.addAttribute("boardList",boardList);
		return "board/QnA";
	}
	
	@RequestMapping(value="insert.do",method = RequestMethod.GET)
	public String insert(HttpSession session, HttpServletRequest request,Model model) throws Exception {
		String memberId ="";
		session = request.getSession();
		memberId = (String) session.getAttribute("SessionMemberId");	
		session.setAttribute("SessionMemberId",memberId);
		//model.addAttribute("boardSelect", boardService.selectBoard(boardNo));
		model.addAttribute("memberSelect", service.selectMember(memberId));
		
		return "board/insertBoard";
	}
	
	@ResponseBody
	@RequestMapping(value="ins.do", method = RequestMethod.POST)
	public String ins(BoardVO boardVo) {
		System.out.println("123123");
		boardService.boardInsert(boardVo);
		System.out.println("asfasf");
		
		return "";
	}
}
