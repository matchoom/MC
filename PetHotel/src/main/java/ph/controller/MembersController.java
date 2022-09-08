package ph.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.service.MembersService;
import ph.service.MembersVO;

@Controller
public class MembersController {

	@Resource(name = "memberService")
	private MembersService service;

	@RequestMapping(value = "/signUp.do", method = RequestMethod.GET)
	public String signUp() {
		return "member/signUp";
	}

	@ResponseBody
	@RequestMapping(value = "/memberId_check.do", method = RequestMethod.POST)
	public int memberId_check(@RequestParam(name = "memberId") String memberId) throws Exception {
		int result = service.memberId_check(memberId);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/memberNickname_check.do", method = RequestMethod.POST)
	public int memberNickname_check(@RequestParam(name = "memberNickname") String memberNickname) throws Exception {
		int result = service.memberNickname_check(memberNickname);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/memberTelNumber_check.do", method = RequestMethod.POST)
	public int memberTelNumber_check(@RequestParam(name = "memberTelNumber") String memberTelNumber) throws Exception {
		int result = service.memberTelNumber_check(memberTelNumber);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/signUpMember.do", method = RequestMethod.POST)
	public String joinMember(MembersVO membersVo) throws Exception {

		String data = "";
		int idresult = service.memberId_check(membersVo.getMemberId());
		int nickresult = service.memberNickname_check(membersVo.getMemberNickname());
		int telnumberresult = service.memberTelNumber_check(membersVo.getMemberTelNumber());
		if (idresult == 1) {
			data = "id";
		} else if (nickresult == 1) {
			data = "nick";
		} else if (telnumberresult == 1) {
			data = "tel";
		} else {
			service.signUpMember(membersVo);
			data = "ok";
		}
		System.out.println(data);
		return data;
	}

	@RequestMapping(value = "/login.do")
	public String loginForm() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginMember.do", method = RequestMethod.POST)
	public int loginMember(@RequestParam(name = "memberId") String memberId,
			@RequestParam(name = "memberPassword") String memberPassword, MembersVO membersVo,
			HttpSession session) throws Exception {
		membersVo.setMemberId(memberId);
		membersVo.setMemberPassword(memberPassword);
		int result = service.loginMember(membersVo);
		if(result == 1) {
			System.out.println("로그인 성공");
			session.setAttribute("SessionMemberId", membersVo.getMemberId());
		} else {
			System.out.println("로그인 실패");
		}
		return result; 
	}
	
	@RequestMapping(value = "/main.do")
	public String mainForm() {
		return "main";
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("SessionMemberId");
		return "main";
	}
	
	@RequestMapping(value = "/selectMember.do")
	public String selectMember(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		String memberId ="";
		session = request.getSession();
		memberId = (String) session.getAttribute("SessionMemberId");	
		model.addAttribute("memberSelect", service.selectMember(memberId));
		return "member/selectMember";
	}
	
	@RequestMapping(value = "/modifyMember.do")
	public String modifyMemberForm(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		String memberId ="";
		session = request.getSession();
		memberId = (String) session.getAttribute("SessionMemberId");	
		model.addAttribute("memberSelect", service.selectMember(memberId));
		return "member/modifyMember";
	}
	
	@RequestMapping(value = "/unSignUpMember.do")
	public String unSignUpMemberForm() {
		return "member/unSignUpMember";
	}
	
}
