package com.crm.vtiger.leadTest;


import org.testng.annotations.Test;

import com.crm.vtiger.objectRepo.CreateNewLeadPage;
import com.crm.vtiger.objectRepo.HomePage;
import com.crm.vtiger.objectRepo.LeadsPage;

import crm.crm.vtiger.genericLibrary.BaseClass;


public class CreateLead extends BaseClass
{
	@Test
	public void createLeadTest() throws Throwable
	{
		/*Step 0: Retrieve lastName and companyName from Excel sheet */
		String lastName = eLib.getExcelData("Leads", 1, 0);
		String companyName = eLib.getExcelData("Leads", 1, 0);
		
		/*Step 1 : Go to Leads Page*/
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();
		
		/*Step 2: Click on Create New Lead*/
		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();
		
		/*Step 3: Create New Lead*/
		CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
		cnlp.createNewLead(lastName, companyName);
		
	}

}
