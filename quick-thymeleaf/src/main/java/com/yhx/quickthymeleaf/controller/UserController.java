package com.yhx.quickthymeleaf.controller;

import com.yhx.quickthymeleaf.models.Apple;
import com.yhx.quickthymeleaf.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: shipeng.yu
 * @time: 2016年12月25日 上午2:38
 * @version: 1.0
 * @since: 1.0
 * @description:
 */
@Controller
@RequestMapping("/user") // 在类中定义,表示该类中的所有方法都将以这个路径作为前缀
public class UserController {

    @GetMapping
    public ModelAndView toLoginForm(@ModelAttribute("errorMsg") String errorMsg, @ModelAttribute("user") User user) {
        return new ModelAndView("/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid User user, BindingResult result,
                              RedirectAttributes redirect) {

        if (result.hasErrors())
            return new ModelAndView("/login", "formErrors", result.getAllErrors());

        if (!User.isUserValid(user)) {
            redirect.addFlashAttribute("errorMsg", "登录失败,用户名或密码错误");
            return new ModelAndView("redirect:/user");
        }

        List<Apple> apples = Apple.generateApples();

        ModelAndView modelAndView = new ModelAndView("/apple");
        modelAndView.addObject("apples", apples);
        return modelAndView;
    }

}
