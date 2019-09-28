package or.kosta.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import or.kosta.mvc.dao.MemberDAO;
import or.kosta.vo.MemberVO;
import or.kosta.vo.RegMemberVO;

@Controller
public class Controll {

	@Autowired
	private MemberDAO dao;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sayhello");
		mav.addObject("msg", "�ȳ��ϼ���?");
		return mav;
	}

	@RequestMapping(value= {"/","/index"})
	public String page() {
		return "index";
	}

	@RequestMapping(value="/insert")
	@ResponseStatus(value = HttpStatus.OK)//����ó�� ���
	@ResponseBody//jsp�� ����� ����
	public synchronized String insertData(RegMemberVO vo) throws IOException
	{
		String ret="";
		try {
			//date ����
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			vo.setMdate(f.format(System.currentTimeMillis()));
			System.out.println("!!! " +vo.getMdate());
			//db�� ������ insert
			ret = dao.insertMember(vo);
			
			List<RegMemberVO> list = new ArrayList<RegMemberVO>();
			list = dao.getMembers();
			return ret;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return ret;
		}
	}
	
	@RequestMapping(value="/signIn", method = RequestMethod.POST)//url�� ����
	@ResponseStatus(value = HttpStatus.OK)//����ó�� ���
	@ResponseBody//jsp�� ����� ����
	public Object signIn(MemberVO mvo) throws IOException {
		// ���� ����
		System.out.println(mvo.getId());
		System.out.println(mvo.getPwd());
		System.out.println(mvo.getName());
		System.out.println(mvo.getMdate());
		try {
			//dao.insertData(mvo);
			List<MemberVO> list = new ArrayList<MemberVO>();
			list = dao.getList();
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				MemberVO d = new MemberVO();
				d = list.get(i);
				System.out.print(d.getNum() + " / ");
				System.out.print(d.getId() + " / ");
				System.out.print(d.getPwd() + " / ");
				System.out.print(d.getName() + " / ");
				System.out.println(d.getMdate());
			}
			return "ok";// ����� �ٽ� jsp�� �����ִ� �޼ҵ�..
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
		
	}
}
