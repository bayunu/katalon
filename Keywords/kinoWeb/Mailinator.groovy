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

public class Mailinator {

	GlobalVariable gv = new GlobalVariable()

	@Keyword
	def openMailinator(currentWindow,username,otp) {
		// Setup Tab
		currentWindow = WebUI.getWindowIndex()
		WebUI.executeJavaScript('window.open();', [])
		WebUI.switchToWindowIndex(currentWindow + 1)
		WebUI.navigateToUrl(GlobalVariable.mailinator)
		WebUI.delay(1)

		// Input Email
		WebUI.setText(findTestObject('Object Repository/Web/Mailinator/Page_Mailinator/Input Email'),username)
		WebUI.click(findTestObject('Object Repository/Web/Mailinator/Page_Mailinator/Button Go'))
		WebUI.delay(1)

		// Click Email Inbox & Copy OTP
		WebUI.click(findTestObject('Object Repository/Web/Mailinator/Page_Mailinator/List Pertama Inbox'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Web/Mailinator/Page_Mailinator/Tab Text'))
		otp = WebUI.getText(findTestObject('Web/Mailinator/Page_Mailinator/OTP'))
		gv.otp = otp
		WebUI.comment('Copy OTP'+otp)
		WebUI.delay(2)
	}

	@Keyword
	def openMailinatorForForget(currentWindow,otp,username) {

		// Back to Forget Page & Input Otp
		WebUI.switchToWindowTitle('Kino Siap - Forgot Password')
		WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Forgot Password/Input OTP'),otp)
		//WebUI.closeWindowIndex(1)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Forgot Password/Verify OTP'))
	}
}
