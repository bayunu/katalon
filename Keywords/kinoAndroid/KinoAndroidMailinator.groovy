package kinoAndroid

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

public class KinoAndroidMailinator {

	@Keyword
	def openMailinatorSignUp(username){
		// Buka Hi Browser
		Mobile.startExistingApplication('com.talpa.hibrowser', FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Object Repository/Android/HiBrowser/android.widget.FrameLayout - Trigger Search URL'), 2)
		Mobile.setText(findTestObject('Object Repository/Android/HiBrowser/android.widget.EditText - Search or type URL'), GlobalVariable.mailinator, 0)
		Mobile.tap(findTestObject('Object Repository/Android/HiBrowser/android.widget.TextView - Enter'), 0)
		
		Mobile.setText(findTestObject('Object Repository/Android/HiBrowser/android.widget.EditText - Input Username Mailinator'), username, 0)
		Mobile.tap(findTestObject('Object Repository/Android/HiBrowser/android.widget.Button - GO'), 0)
		
//		Mobile.tap(findTestObject('Object Repository/Android/HiBrowser/android.webkit.WebView - PreapreRefersh'), 0)
//		Mobile.tap(findTestObject('Object Repository/Android/HiBrowser/android.widget.ImageButton - Refresh'), 0)
		
		// Get Data
		Mobile.tap(findTestObject('Object Repository/Android/HiBrowser/android.view.View - Kino Siap no-replypowerbiz.asia'), 2)
		String sGet = Mobile.getText(findTestObject('Object Repository/Android/HiBrowser/android.widget.TextView - OTP'), 0)
		GlobalVariable.otp = sGet
		
		
		Mobile.tap(findTestObject('Object Repository/Android/HiBrowser/android.widget.TextView - TabBrowser'), 0)
		Mobile.tap(findTestObject('Object Repository/Android/HiBrowser/android.widget.ImageView - TriggerCloseTab'), 0)
		Mobile.tap(findTestObject('Object Repository/Android/HiBrowser/android.widget.TextView - CloseAllTab'), 0)
		
		Mobile.closeApplication()
		Mobile.startExistingApplication('id.powercommerce.mobile_commerce', FailureHandling.STOP_ON_FAILURE)
	}
}
