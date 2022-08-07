package kinoWeb

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.Driver

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class SignInOut {

	@Keyword
	def doLogin() {
		if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/Menu Sign In'), 2)) {
			WebUI.takeFullPageScreenshot()
			WebUI.comment('Gagal doLogin()')
		} else {
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/Menu Sign In'))
			WebUI.delay(2)
			WebUI.refresh()
			WebUI.comment('Berhasil doLogin()')
		}
	}

	@Keyword
	def signIn(username, password) {
		if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Sign In/Input Username'), 2)) {
			WebUI.takeFullPageScreenshot()
			WebUI.comment('Gagal signIn()')
		} else {
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Sign In/Input Username'),username)
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Sign In/Input Password'), password)
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Sign In/Tombol Sign In'))
			WebUI.comment('Berhasil signIn()')
		}
	}

	@Keyword
	def signOut() {
		if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/Menu Profile'), 2)) {
			WebUI.takeFullPageScreenshot()
			WebUI.comment('Gagal signOut()')
		} else {
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/Menu Profile'))
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/Menu Profile - Keluar'))
			WebUI.delay(3)
			WebUI.comment('Berhasil signOut()')
		}
	}
}
