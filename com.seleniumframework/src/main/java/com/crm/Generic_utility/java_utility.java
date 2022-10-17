package com.crm.Generic_utility;

import java.util.Random;

public class java_utility 
{
	/**
	 * this method is used  to avoid duplicate
	 * @return
	 * @prashanth
	 */
public int getRandomnum()
{
	Random ran = new Random();
    int ranNum = ran.nextInt(1000);
	return ranNum  ;
}
}