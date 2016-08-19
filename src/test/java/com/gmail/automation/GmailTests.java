package com.gmail.automation;

import businessobjects.Message;
import businessobjects.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.LoginPage;

import java.io.File;
import java.io.IOException;

import static data.Parameters.*;
import static data.UserCredentials.*;
import static data.MessageValues.*;
import static utils.utils.deleteFileFromDownloads;

public class GmailTests extends BaseTest {

    private User user1;
    private User user2;
    private LoginPage loginPage;
    private File textFile;
    private Message message;


    @BeforeClass(groups = {"init"}, alwaysRun = true)
    public void beforeClassInit() throws IOException {
        setDriver(BROWSER.getValue(), SITEURL.getValue());
        user1 = new User(USER1.getValue(), PASSWORD.getValue());
        user2 = new User(USER2.getValue(), PASSWORD.getValue());
        loginPage = new LoginPage();
        textFile = new File(GmailTests.class.getResource("/textfile.txt").getFile());
        message = new Message(user2.getEmail(), SUBJECT.getValue(), textFile);
        deleteFileFromDownloads(textFile);
    }

    @AfterClass(groups = {"init"}, alwaysRun = true)
    public void afterClassInit() throws IOException {
        deleteFileFromDownloads(textFile);
        tearDown();
    }

    @Test
    public void testSendMessageWithAttachment() throws Exception {
        loginPage
                .loginAsUser(user1)
                .composeNewMessage(message)
                .signOut()
                .loginAsUser(user2)
                .verifyReceivedMessage(message);
    }
}
