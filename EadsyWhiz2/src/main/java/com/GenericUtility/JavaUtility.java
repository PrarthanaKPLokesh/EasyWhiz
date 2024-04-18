package com.GenericUtility;

import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	public int RandomNo()
	{
	Random ran=new Random();
	int random=ran.nextInt();
	return random;
	}
	
public String getSystemDate()
{
	Date dt=new Date();
	String date=dt.toString();
	return date;
	}

public String getSystemDateInFormat()
{
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	Date dt=new Date();
	String sysdateFormat = dateFormat.format(dt);
	return sysdateFormat;
	}

}
