import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.Variable
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import kinoWeb.*

OpenBrowser ob = new OpenBrowser()
SignUp su = new SignUp() 

ob.openBrowserSIT()
su.doSignUp(firstName, lastName, typeSignUp, username, password, confirmPassword1, currentWindow, otpTest, otp, signUpConfirmationTest, urlsignUpConfirmation, nameStore, birthPlace, birthDate, jalan, rtrw, kota, kelurahan, ktp, fotoKtp, npwp, fotoNpwp, punyaTokoOffline, fotoTokoOffline, punyaTokoOnline, namaTokoOnline, confirmPassword2)(firstName, lastName, typeSignUp, username, password, confirmPassword1, currentWindow, otpTest, otp, signUpConfirmationTest, urlsignUpConfirmation, nameStore, birthPlace, birthDate, jalan, rtrw, kota, kelurahan, ktp, npwp, punyaTokoOffline, punyaTokoOnline, namaTokoOnline, confirmPassword2)