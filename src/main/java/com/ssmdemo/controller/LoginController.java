package com.ssmdemo.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssmdemo.domain.User;

@Controller
@RequestMapping("/")
public class LoginController {
	
	private Logger logger = Logger.getLogger(LoginController.class);
	
	/**
	 * 根据索引号跳转页面
	 * @param num
	 * @return
	 * 001->二维码页面QR-code.jsp
	 */
	@RequestMapping(value= "index")
	public String index(String num){
		if(num.equals("001")){
			return "QR-code";
		}
		else{
			return "login";
		}
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String dologin(User user,Model model){
		Subject subject = SecurityUtils.getSubject();
		String username = user.getUsername();
		String password = user.getPassword();
		logger.info("userName:"+username);
		logger.info("passWord:"+password);
		
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		try{
			subject.login(token);
		}catch(UnknownAccountException e){
			logger.debug("登录认证账户异常");
			model.addAttribute("msg", "登录认证账户异常");
			return "showResultMsg";
		}catch(IncorrectCredentialsException e){
			logger.debug("登录认证密码异常");
			model.addAttribute("msg", "登录认证密码异常");
			return "showResultMsg";
		}catch(Exception e){
			logger.debug("login error");
			model.addAttribute("msg", "登录认证异常");
			return "showResultMsg";
		}
		model.addAttribute("msg", "登录认证成功");
		return "showResultMsg";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		model.addAttribute("msg", "您已退出登录！");
		return "logout";
	}
	@RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/student")
    public String student(){
        return "admin";
    }

    @RequestMapping("/teacher")
    public String teacher(){
        return "admin";
    }
}
