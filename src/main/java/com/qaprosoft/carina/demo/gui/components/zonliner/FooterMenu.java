package com.qaprosoft.carina.demo.gui.components.zonliner;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.zonliner.HomePageOnliner;
import com.qaprosoft.carina.demo.gui.pages.zonliner.VacanciesPageOnliner;
import com.qaprosoft.carina.demo.gui.pages.zonliner.ContactsPageOnliner;

public class FooterMenu extends AbstractUIObject {
	
    @FindBy(xpath = "//a[@href='https://blog.onliner.by/vacancy']")

    private ExtendedWebElement vacanciesLink;

    @FindBy(xpath = "//a[@href='https://people.onliner.by/contacts']")
    private ExtendedWebElement contactsLink;
        
    @FindBy(xpath = "//img[@class='onliner_logo']")
    private ExtendedWebElement homeLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePageOnliner openHomePageOnliner() {
        homeLink.click();
        return new HomePageOnliner(driver);
    }
    
    public VacanciesPageOnliner openVacanciesPageOnliner() {
    	vacanciesLink.scrollTo();
    	vacanciesLink.click();
        return new VacanciesPageOnliner(driver);
    }
    
    public ContactsPageOnliner openContactsPageOnliner() {
    	contactsLink.scrollTo();
    	contactsLink.click();
        return new ContactsPageOnliner(driver);
    }
}
