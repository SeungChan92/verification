package com.daou.asp.webtest.suite;

import org.junit.BeforeClass;
import org.openqa.selenium.support.PageFactory;

import com.daou.asp.webtest.infra.webdriverextension.Tool;
import com.daou.asp.webtest.page.section.LoginSection;

public abstract class LoginedSuite extends Suite {
	
	@BeforeClass
	public static void login () {
		
		LoginSection loginSection = null;
		
		Tool.goToPage("/");
		loginSection = PageFactory.initElements(driver, LoginSection.class);
		loginSection.login();
	}
}
