package everywhere.com.mynetgear.ccvf2.admin.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import everywhere.com.mynetgear.ccvf2.admin.service.main.AdminMainService;
import everywhere.com.mynetgear.ccvf2.comm.dto.commoncode.CommonCodeDto;
import everywhere.com.mynetgear.ccvf2.comm.service.commoncode.CommonCodeService;

/**
 * @author 안희진
 * @createDate 2015. 12. 5.
 * @described 몰라 알수가 없어!!!
 * @reference Controller
 */
// 컨트롤러 김성광
@Controller
public class AdminMainController {
	@Autowired
	private AdminMainService adminMainService;
	@Autowired
	private CommonCodeService commonCodeService;

	/**
	 * @author 이것도 깨졌네!!
	 * @createDate 2015. 12. 5.
	 * @return
	 */
	@RequestMapping(value="/admin/main/main.do", method=RequestMethod.GET)
	public ModelAndView mainPage() {
		ModelAndView mav= new ModelAndView();
		System.out.println("而⑦듃濡ㅻ윭");
		adminMainService.mainPage(mav);
		return mav;
	}
	
	
	/*
	 * 배고프다... 
	 * 졸립다...
	 * 
	 */
	
	
	@RequestMapping(value="/admin/commoncode/code.do", method=RequestMethod.GET)
	public ModelAndView showCode() {
		ModelAndView mav= new ModelAndView();
		commonCodeService.callCodeSettingPage(mav);
		return mav;
	}
	
	//졸려... 넘나 귀찮은 것..
	@RequestMapping(value="/admin/commoncode/code.do", method=RequestMethod.POST)
	public ModelAndView settingCode(HttpServletRequest request, HttpServletResponse response,CommonCodeDto dto) {
		ModelAndView mav= new ModelAndView();
		System.out.println("�엯�젰�슂泥�");
		mav.addObject("request",request);
		mav.addObject("commonCodeDto",dto);
		commonCodeService.callCodeSetting(mav);
		return mav;
	}
}
