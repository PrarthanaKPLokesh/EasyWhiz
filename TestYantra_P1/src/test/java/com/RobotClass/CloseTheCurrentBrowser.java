package com.RobotClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseTheCurrentBrowser {

	public static void main(String[] args) throws IOException {
		Runtime r=Runtime.getRuntime();
		Process proc=r.exec("taskkill /IM chrome.exe /F");
		Process proc1=r.exec("taskkill /IM msedge.exe /F");
		Process proc2=r.exec("taskkill /IM firefox.exe /F");
		
	}
}
