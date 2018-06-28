package tests;

import org.testng.annotations.Test;

import practice.BaseTest;

public class GridFrameworkTest extends BaseTest
{
	@Test
	public void testA()
	{
		String title=driver.getTitle();
		System.out.println("Title is"+title);
	}

}
