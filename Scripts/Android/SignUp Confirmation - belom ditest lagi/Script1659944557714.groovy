import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Masukkan nama toko'), 
    'Bachtiar', 0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Masukkan tempat lahir'), 
    'Jakarta', 0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Tanggal'), '31', 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.Spinner - Bulan'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - January'), 0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Tahun'), '2000', 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Selanjutnya ke Page 2'), 
    0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Street name'), 'Jalan', 
    0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - RTRW'), '002/005', 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Pilih Negara'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Indonesia'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Pilih KabupatenKota - Provinsi'), 
    0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Input Kota'), 'Jakarta Selatan', 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Jakarta Selatan - DKI Jakarta'), 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - pilih DesaKelurahan - Kecamatan'), 
    0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Kelurahan'), 'Lebak Bulus', 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Lebak Bulus - Cilandak'), 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Tandai Lokasi'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Pilih Lokasi'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Selanjutnya Ke Page 3'), 
    0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Masukkan No KTP'), 
    '123456789', 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView -  Upload File Ktp'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Take Photo Ktp'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.ImageView - Jepret Photo Ktp'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.ImageView - Photo Ok Ktp'), 0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Masukkan No NPWP'), 
    '1234567890', 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView -  Upload File Npwp'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Take Photo Npwp'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.ImageView - Jepret Photo Npwp'), 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.ImageView - Photo Ok Npwp'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Choose Toko Offline'), 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - No Toko Offline'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Choose Toko Online'), 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Yes Toko Online'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Nama Toko Online'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Tambah Toko Online'), 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - No Toko Online'), 0)

Mobile.setText(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.EditText - Password'), 'password', 
    0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.ImageView - Lihat Password'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Lengkapi Data'), 0)

Mobile.tap(findTestObject('Object Repository/Android/Kino/SignUpConfirm/android.widget.TextView - Menuju Sign in'), 0)

Mobile.closeApplication()

