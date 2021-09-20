package com.qaprosoft.carina.demo.onliner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.gui.pages.onliner.AuthorizedPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onliner.HomePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.onliner.LoginPageOnliner;
import com.zebrunner.agent.core.annotation.TestLabel;

import org.openqa.selenium.Dimension;


public class OnlinerAllTestsWithLoginCodeInChildAnnotattion extends LoginBaseTestCodeInChildAnnotation implements IAbstractTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OnlinerAllTestsWithLoginCodeInChildAnnotattion.class);
	
	private HomePageOnliner homePageOnliner;  
	
	@BeforeSuite
    public void beforeSuiteLoginChild() {
		LOGGER.info("@LoginTest-BeforeSuite-Child-(Code-In-Child-Annotation)");
    }

	@BeforeTest
	public void beforeTestLoginChild() {
		LOGGER.info("@LoginTest-BeforeTest-Child-(Code-In-Child-Annotation)");
	}

	@BeforeClass
	public void beforeClassLoginChild() {
		LOGGER.info("@LoginTest-BeforeClass-Child-(Code-In-Child-Annotation)");
		
    	// Open Home page
		homePageOnliner = new HomePageOnliner(getDriver());
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home page is not opened");
        pause(3.0);
        
        getDriver().manage().window().setSize(new Dimension(1100, 768));
        pause(1);
        Assert.assertTrue(homePageOnliner.getTopHeaderBar().isUIObjectPresent());

        getDriver().manage().window().setSize(new Dimension(1000, 700));
        pause(1);
        Assert.assertTrue(homePageOnliner.getTopHeaderBar().isUIObjectPresent());
        
        getDriver().manage().window().maximize();
        pause(1);
        Assert.assertTrue(homePageOnliner.getTopHeaderBar().isUIObjectPresent());
        
        getDriver().manage().window().setSize(new Dimension(900, 600));
        pause(1);
        Assert.assertTrue(homePageOnliner.getTopHeaderBar().isUIObjectPresent());
        
        getDriver().manage().window().fullscreen();
        pause(1);
        Assert.assertTrue(homePageOnliner.getTopHeaderBar().isUIObjectPresent());
        
        getDriver().manage().window().setSize(new Dimension(1100, 768));
        pause(1);
        Assert.assertTrue(homePageOnliner.getTopHeaderBar().isUIObjectPresent());        
	}

	@BeforeMethod
	public void beforeMethodLoginChild() {
		LOGGER.info("@LoginTest-BeforeMethod-Child-(Code-In-Child-Annotation)");
		
		//Refresh Home Page
        homePageOnliner.open();
        Assert.assertTrue(homePageOnliner.isPageOpened(), "Home page is not opened");
        pause(3.0);
        
        while (!(homePageOnliner.getTopHeaderBar().getAuthLink().isElementPresent())){
        	homePageOnliner.refresh(); 
        	pause(0.5);
        };
	}
	
	
	
	@Test()
    @MethodOwner(owner = "dkharevich")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    
    //testcase000 Verify that Login page is opened.
    public void testAuthBarIsOpened() {
               
        // Open Authorization page
        LoginPageOnliner loginPageOnliner = homePageOnliner.getTopHeaderBar().clickOnAuthLink();
        loginPageOnliner.pause(5.0);
        Assert.assertTrue(loginPageOnliner.isPageOpened(), "Login page is not opened");
        
    }    
    
    @Test()
    @MethodOwner(owner = "dkharevich")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    
    //testcase001 Verify that the user can Activate the login and password fields and can Type in it.
    public void testUserCanActivateFieldsAndCanTypeInIt() {
                
        // Open Authorization page
        LoginPageOnliner loginPageOnliner = homePageOnliner.getTopHeaderBar().clickOnAuthLink();
        Assert.assertTrue(loginPageOnliner.isPageOpened(), "Login page is not opened");
        
        // Type in Login field
        loginPageOnliner.typeInLoginField("adaxdeaeca");
        Assert.assertTrue(loginPageOnliner.getLoginFieldLink().isClickable(), "Login field is not clickable");  
        
        // Type in Password field
        loginPageOnliner.typeInPasswordField("adaxdeaeca");
        Assert.assertTrue(loginPageOnliner.getPasswordFieldLink().isClickable(), "Password field is not clickable");
        
        // Password checking  
        loginPageOnliner.showPasswordInPasswordField();;
        loginPageOnliner.pause(5.0);

    }        
    
    @Test()
    @MethodOwner(owner = "dkharevich")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    
    //testcase002 Verify that the user can Enter letters in different cases, numbers and special symbols that are different from letters and numbers such as \, |, /,  <, >, *, ?, !, ', ", ~, `, :, ;, &, %, $, #, @, etc. into the login and password fields.
    public void testUserCanEnterLettersNumbersAndSpecialSymbols() {
                
        // Open Authorization page
        LoginPageOnliner loginPageOnliner = homePageOnliner.getTopHeaderBar().clickOnAuthLink();
        Assert.assertTrue(loginPageOnliner.isPageOpened(), "Login page is not opened");
        
        // Type in Login field
        loginPageOnliner.typeInLoginField("SolvD_@#$%^&_2020");
        Assert.assertTrue(loginPageOnliner.getLoginFieldLink().isClickable(), "Login field is not clickable");  
        
        // Type in Password field
        loginPageOnliner.typeInPasswordField("SolvD_@#$%^&_2020");
        Assert.assertTrue(loginPageOnliner.getPasswordFieldLink().isClickable(), "Password field is not clickable");
        
        // Password checking
        loginPageOnliner.showPasswordInPasswordField();;
        loginPageOnliner.pause(5.0);
        
    }    
        
    @Test()
    @MethodOwner(owner = "dkharevich")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    
    //testcase003 Verify that the user can Access his registered personal account through the registration form entering correct login (email) and correct password.
    public void testUserCanAccessAccountThroughEnteringValidLogAndPas() {
                
        AuthorizedPageOnliner authorizedPageOnliner = homePageOnliner.getTopHeaderBar().clickOnAuthLink().getAuthorizedPageOnliner("dmiterkh@mail.ru", "3909091");
        pause(5.0);
        Assert.assertTrue(authorizedPageOnliner.isPageOpened(), "Authorized page is not opened");
        
        
        homePageOnliner = authorizedPageOnliner.returnPopupProfileLink().openHomePageOnliner();
        pause(5.0);
        Assert.assertTrue(authorizedPageOnliner.isPageOpened(), "Authorized page is not opened");
        
        
    }
    
    @Test()
    @MethodOwner(owner = "dkharevich")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    
    //testcase007 (Negative) Verify that the user Cannot Access his registered personal account through the registration form entering incorrect login (email) and correct password.
    public void testUserCanNotAccessAccountThroughEnteringInvalidLogValidPas() {
                
        LoginPageOnliner loginPageOnliner = homePageOnliner.getTopHeaderBar().clickOnAuthLink().getNotAuthorizedLoginPageOnliner("dmiterkh.mail.ru", "3909091");
        pause(5);  
        Assert.assertTrue(loginPageOnliner.isPageOpened(), "Not Authorized Login page is not opened");
        
    }    
    
    
    
	@AfterMethod
	public void afterMethodLoginChild() {
		LOGGER.info("@LoginTest-AfterMethod-Child-(Code-In-Child-Annotation)");
	}	
	
	@AfterClass
	public void afterClassLoginChild() {
		LOGGER.info("@LoginTest-AfterClass-Child-(Code-In-Child-Annotation)");
	}

	@AfterTest
	public void afterTestLoginChild() {
		LOGGER.info("@LoginTest-AfterTest-Child-(Code-In-Child-Annotation)");
	}
	
    @AfterSuite
    public void afterSuiteLoginChild() {
    	LOGGER.info("@LoginTest-AfterSuite-Child-(Code-In-Child-Annotation)");
    }
}