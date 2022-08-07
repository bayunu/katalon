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

class KinoAndroidSignUp {

	KinoAndroidMailinator m = new KinoAndroidMailinator()

	@Keyword
	def signUp(firstName, lastName, typeSignUp, username, password, confirmPassword1) {
		// Buka App Kino
		Mobile.startExistingApplication('id.powercommerce.mobile_commerce')
		Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - Profile'), 5)
		Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - Profile - Daftar'), 0)

		// Input Data
		Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.EditText - Masukkan nama depan'), firstName, 0)
		Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.EditText - Masukkan nama belakang'), lastName, 0)

		// Check Type SignUp
		if (typeSignUp == 'phone'){
			Mobile.comment('typeSignUp Phone')
			Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - No Handphone'), 0)
			// isi bay phonenya
		} else if (typeSignUp == 'email') {
			Mobile.comment('typeSignUp Email')
			Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - Email'), 0)
			Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.EditText - Masukkan email'), username, 0)
		} else {
			Mobile.comment('typeSignUp Kosong')
		}

		// Input Password
		Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.EditText - Masukkan kata sandi'), 'password', 0)
		Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.ImageView - Password'), 0)
		Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.EditText - Konfirmasi kata sandi'), 'password', 0)
		Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.ImageView - ConfrimPassword'), 0)

		// Click Daftar
		Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - Daftar Sekarang'), 0)

		m.openMailinatorSignUp(username)

		String[] otp = GlobalVariable.otp
		for (int i = 0; i < otp.length; i++) {
			Mobile.comment(otp[i])

			if (otp[i] == '0') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 0'), 1)
			} else if (otp[i] == '1') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 1'), 1)
			} else if (otp[i] == '2') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 2'), 1)
			} else if (otp[i] == '3') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 3'), 1)
			} else if (otp[i] == '4') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 4'), 1)
			} else if (otp[i] == '5') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 5'), 1)
			} else if (otp[i] == '6') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 6'), 1)
			} else if (otp[i] == '7') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 7'), 1)
			} else if (otp[i] == '8') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 8'), 1)
			} else if (otp[i] == '9') {
				Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUp/android.widget.TextView - 9'), 1)
			}
		}
		
		// Tambah Click
	}
}