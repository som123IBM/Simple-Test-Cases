package com.training.sanity.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sampletest {
	
@Test(dependsOnMethods="C")
	public void A() {
	System.out.println("1st");
	}

/*@Test
public void K() {
	System.out.println("2nd");
	}*/
	
@Test
	public void C() {
		System.out.println("3rd");
		}

@Test
	public void D() {
		System.out.println("4th");
		}

@Test
	public void E() {
		System.out.println("5th");
		}

}

