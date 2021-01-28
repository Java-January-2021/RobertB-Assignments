package com.robertbuckley.DisplayDate.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String homePage() {
		return "index.jsp";
	}
		@RequestMapping("/date")
		public String date(Model viewModel) {
		Date myDate = new Date();
		String datePattern = "EEEE, 'the' dd 'of' MMMM, YYYY";
		SimpleDateFormat theDate = new SimpleDateFormat(datePattern);
		
		String date = theDate.format(myDate);
        System.out.println(date);
        viewModel.addAttribute("date", date);
        return "date.jsp";
	}
		@RequestMapping("/time")
		public String time(Model viewModel) {
		Date myTime = new Date();
		String timePattern = "K:mm a z";
		SimpleDateFormat theTime = new SimpleDateFormat(timePattern);
		String time = theTime.format(myTime);
		viewModel.addAttribute(("time"), time);
        System.out.println(time.toString());
        return "time.jsp";
	}
//		myString = DateFormat.getDateInstance().format(myDate
		
	
	
}
