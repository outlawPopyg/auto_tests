package org.example;

import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://google.com");

	}
}