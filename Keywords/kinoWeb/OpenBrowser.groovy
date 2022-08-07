package kinoWeb

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class OpenBrowser {
	@Keyword
	def openBrowserSIT(){
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.webSiT)
		WebUI.delay(1)
	}

	@Keyword
	def openBrowserProd() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.webProd)
		WebUI.delay(1)
	}
	
	@Keyword
	def checkBahasa() {
		// Indonesia -> English
		WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/span_Indonesia'))
		WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/div_English'))
		
		// English -> Indonesia
		WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/span_English'))
		WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/div_Indonesia'))
	}
}
