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
import com.kms.katalon.core.testdata.reader.ExcelFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class SignUp {

	GlobalVariable gv = new GlobalVariable()
	Mailinator m = new Mailinator()

	FileInputStream fis = new FileInputStream('Data Files/Data/Kino.xlsx')
	XSSFWorkbook workbook = new XSSFWorkbook(fis)
	XSSFSheet sheet = workbook.getSheet('SignUp')

	@Keyword
	def doSignUp(firstName, lastName, typeSignUp, username, password, confirmPassword1, currentWindow, otpTest, otp, signUpConfirmationTest, urlsignUpConfirmation, nameStore, birthPlace, birthDate, jalan, rtrw, kota, kelurahan, ktp, fotoKtp, npwp, fotoNpwp, punyaTokoOffline, fotoTokoOffline, punyaTokoOnline, namaTokoOnline, confirmPassword2){

		Object excel = ExcelFactory.getExcelDataWithDefaultSheet('Data Files/Data/Kino.xlsx', 'SignUp', true)
		urlsignUpConfirmation = excel.getValue('UrlConfirmSignUp',sheet.getLastRowNum())

		WebUI.comment('Check SignUpConfirmationTest()')
		WebUI.comment('Apakah Sign Up Confirmation Test : '+signUpConfirmationTest)
		WebUI.comment(' URL SignUp Confirmation : '+urlsignUpConfirmation)

		if (signUpConfirmationTest == 'Ya' && urlsignUpConfirmation != '') {

			// Test signUpConfirmation
			WebUI.openBrowser('')
			WebUI.maximizeWindow()
			WebUI.navigateToUrl(urlsignUpConfirmation)
			WebUI.delay(1)
			WebUI.refresh()
			WebUI.comment('Melakukan SignUpConfirmationTest()')
			signUpConfirmation(urlsignUpConfirmation, nameStore, birthPlace, birthDate, jalan, rtrw, kota, kelurahan, ktp, fotoKtp, npwp, fotoNpwp, punyaTokoOffline, fotoTokoOffline, punyaTokoOnline, namaTokoOnline, confirmPassword2)
		} else {

			WebUI.comment('Tidak Melakukan SignUpConfirmationTest()')

			// Click Register
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap/Menu Sign Up'))
			WebUI.delay(2)
			WebUI.refresh()

			// Input Data
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Input First Name'), firstName)
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Input Last Name'), lastName)

			// Check Type of SignUp
			if (typeSignUp == 'phone') {
				// Choose Phone
				WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Sign Up by HP'))
				WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Input HP'),username)
				WebUI.comment('SignUp By Phone')
			} else {
				// Choose Email
				WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Sign Up by Email'))
				WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Input Email'), username)
				WebUI.comment('SignUp By Email')
			}
			// Input Password
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Input Password'), password)
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/View Password'))
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Input Password Confrm'),confirmPassword1)
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/View Konfirmasi Password'))

			// Click Button SignUp
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Click Daftar'))

			//Check Condition
			if (WebUI.verifyElementNotPresent(findTestObject('Web/Kino/Page_Kino Siap - Register/Input OTP'), 2, FailureHandling.OPTIONAL)) {
				WebUI.takeFullPageScreenshot()
				WebUI.comment('Gagal doSignUp()')
			} else {
				WebUI.comment('Berhasil doSignUp()')

				// Open Mailinator
				m.openMailinator(currentWindow, username, otp)

				// Back to Register Page & Input Otp
				WebUI.switchToWindowTitle('Kino Siap - Register')

				// Check Condition OTP Test
				if (otpTest == 'Yes') {
					WebUI.comment('Melakukan OTP Test')
					WebUI.setText(findTestObject('Web/Kino/Page_Kino Siap - Register/Input OTP'), otp)
					WebUI.delay(1)
					WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Verify OTP Sign Up'))

					// Check Condition OTP
					if (WebUI.verifyElementPresent(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Error OTP Salah'), 1, FailureHandling.OPTIONAL)) {
						WebUI.takeFullPageScreenshot()
						WebUI.comment('OTP Test Salah')
					}

				} else {
					otp = gv.otp
					WebUI.comment('Paste OTP '+otp)
					WebUI.setText(findTestObject('Web/Kino/Page_Kino Siap - Register/Input OTP'), otp)
					WebUI.delay(1)
					WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register/Verify OTP Sign Up'))
				}
				// Melakukan SignUpConfirmation
				signUpConfirmation(urlsignUpConfirmation, nameStore, birthPlace, birthDate, jalan, rtrw, kota, kelurahan, ktp, fotoKtp, npwp, fotoNpwp, punyaTokoOffline, fotoTokoOffline, punyaTokoOnline, namaTokoOnline, confirmPassword2)
			}
		}
	}

	@Keyword
	def signUpConfirmation(urlsignUpConfirmation,nameStore, birthPlace, birthDate, jalan, rtrw, kota, kelurahan, ktp, fotoKtp, npwp, fotoNpwp, punyaTokoOffline, fotoTokoOffline, punyaTokoOnline, namaTokoOnline, confirmPassword2) {

		if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/1 Input Nama Toko'), 2, , FailureHandling.OPTIONAL)) {
			WebUI.takeFullPageScreenshot()
			WebUI.comment('Gagal signUpConfirmation()')
		} else {

			WebUI.comment('Melakukan signUpConfirmation()')

			// Input Data
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/1 Input Nama Toko'), nameStore)
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/2 Input Tempat Lahir'),birthPlace)

			// Input Date Format 2000-12-31
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/3.1 Click Tanggal Lahir'))
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/3.2 Input Tanggal Lahir'),
					birthDate)
			WebUI.sendKeys(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/3.2 Input Tanggal Lahir'),
					Keys.chord(Keys.ENTER))

			// Input Address
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/4 Input Nama Jalan'),jalan)
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/5 Input RTRW'), rtrw)

			// Pilih Kota
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/6.1 Click Kota'))
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/6.2 Input Kota'),kota)

			// Pilih Kelurahan
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/7.1 Click Kelurahan'))
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/7.2 Input Kelurahan'),kelurahan)
			WebUI.delay(1)

			// Pin Point Map
			//		WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/8.1 Click Pin Point'))
			//		WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/8.2 OK Pin Point'))

			// Input & Upload KTP getImage C:\\Users\\Powercommerce\\Pictures\\Kino\\komitmen.jpg
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/9.1 Input KTP'),ktp)
			WebUI.uploadFile(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/9.2 KTP Upload'), fotoKtp)

			// Input & Upload Npwp
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/10.1 Input NPWP'),npwp)
			WebUI.uploadFile(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/10.2 NPWP Upload'), fotoNpwp)
			WebUI.delay(1)

			// Plih Toko Offline
			if (punyaTokoOffline == 'Ya') {
				WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/11 Punya Toko Offline'))
				WebUI.uploadFile(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/11 Upload Toko Offline'), fotoTokoOffline)
				WebUI.comment('Ya Punya Toko Offline')
			} else {
				WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/11 Tidak Punya Toko Offline'))
				WebUI.comment('Tidak Punya Toko Offline')
			}

			// Input Toko Online
			if (punyaTokoOnline == 'Ya') {
				if (namaTokoOnline == '') {
					WebUI.comment('Nama Toko Online Kosong')
				} else {
					String[] nama = namaTokoOnline.split(',')
					for (int i = 0; i < nama.length; i++) {
						WebUI.comment(nama[i])
						WebUI.click(findTestObject('Object Repository/Page_Kino Siap - Register Confirmation/12 Toko Online'))
						WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/12 Input Toko Online'),nama[i])
						WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/12 Input Toko Online - Tambah'))
					}
				}
			} else {
				WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/12 Tidak Toko Online'))
				WebUI.comment('Tidak Punya Toko Online')
			}

			// Input Password
			WebUI.setText(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/13 Input Password'),confirmPassword2)
			WebUI.delay(1)

			// Click Daftar Konfirmasi
			WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Kino Siap - Register Confirmation/14 Click Daftar Akun'))

			// Tulis KeExcel URL SignUpConfirmation
			urlsignUpConfirmation = WebUI.getUrl()
			sheet.getRow(sheet.getLastRowNum()).createCell(10).setCellType(CellType.STRING)
			sheet.getRow(sheet.getLastRowNum()).getCell(10).setCellValue(urlsignUpConfirmation)
			FileOutputStream fos = new FileOutputStream('Data Files/Data/Kino.xlsx')
			workbook.write(fos)
			fos.close()
			WebUI.comment('URL Sign Up Confirm ' +urlsignUpConfirmation)
			WebUI.delay(1)

			// Check Kondisi
			if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Web/Kino/Page_Powerbiz/Button Masuk Setelah Konfirmasi Regis'), 2, FailureHandling.OPTIONAL)) {
				WebUI.takeFullPageScreenshot()
				WebUI.comment('Gagal signUpConfirmation()')
			} else {
				WebUI.delay(3)
				WebUI.click(findTestObject('Object Repository/Web/Kino/Page_Powerbiz/Button Masuk Setelah Konfirmasi Regis'))
				WebUI.comment('Berhasil signUpConfirmation()')
			}
		}
	}
}
