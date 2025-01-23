package com.dkk.pom;

/* Created by: {@Desislava Kancheva/GitHub username: @DesiK736} */

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostModal extends BasePage {
    private final WebElement modalElement;

    public PostModal (WebDriver driver, Logger log) {
        super(driver,log);
        this.modalElement = driver.findElement(By.className("post-modal"));
    }

    public boolean isImageVisible() {
        try {
            WebElement image = modalElement.findElement(By.cssSelector(".post-modal-img img"));
            log.info("CONFIRMATION => The image is visible!");
            return wait.until(ExpectedConditions.visibilityOf(image)).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error(" [ ERROR! ]=> The image is not visible!");
            return false;
        }
    }

    //The method will be used in further activities.
    public String getPostUser() {
        WebElement postUser = modalElement.findElement(By.cssSelector(".post-user"));
        wait.until(ExpectedConditions.visibilityOf(postUser));
        log.info("CONFIRMATION => The user, which created the post is: " + postUser);
        return postUser.getText();
    }
}
