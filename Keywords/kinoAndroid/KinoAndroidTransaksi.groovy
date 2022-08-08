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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import org.openqa.selenium.Keys as Keys

import java.lang.Integer as Integer

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

public class KinoAndroidTransaksi {

	@Keyword
	def addProduct(checkProduct) {
		
		// Tap Beranda
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.FrameLayout - Menu Beranda'), 0)

		// Check Validasi
		if (checkProduct == '')
		{
			Mobile.comment('Product Kosong')
		} else {
			Mobile.comment('Ada Product')
			// Check Product Mau Input Berapa ex: cappanda, 10,pcs; cap badak,11,ctn; (diambil pemisah berdasarkan ;)
			String[] cp = checkProduct.split(';')
			for (int i = 0; i < cp.length; i++) {
				String tampungCP = cp[i]
				// dipisah berdasarkan ,
				String [] cpd = tampungCP.split(',')

				// Enter Product Name
				String productName = cpd[0].trim()
				Mobile.comment('Beli ' +productName)

				// Check Mau Klik Fitur Search Dimana
				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Cari produk'), 2, FailureHandling.OPTIONAL)) {
					// Click Fitur Searching Product DiBeranda
					Mobile.comment('Ini Searching Diberanda')
					Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Cari produk'), 0)
					Mobile.setText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.EditText - Search product'), productName +'\\n', 2)

				} else {
					// Click Fitur Searching Product di Detail Product
					Mobile.comment('Ini Searching DiDetail Product')
					Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.EditText - Cari produk Didalam detail Product'), 2)
					Mobile.setText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.EditText - Cari produk Didalam detail Product'), productName +'\\n', 2)
				}

				// Click Product
				if (Mobile.verifyElementNotVisible(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.FrameLayout - Product After Search'), 2, FailureHandling.OPTIONAL)) {
					Mobile.comment('Product ' +productName+ ' Tidak Ada')
				} else {
					Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.ImageView - Get Produk After Search'), 2)
				}
				
				Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView -  Klik Keranjang Sebelum Input'), 0)
				// Input Quantity
				Integer quantity = cpd[1].toInteger()
				Mobile.comment('Sebanyak ' +quantity)

				for (int b = 0; b < (quantity-1); b++) {
					Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.ImageView - Tombol Plus Tambah Quantity ProductDetail'), 0)
				}

				// Check Type Unit
				Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.RelativeLayout - Pilih Unit'), 0)
				String unit = cpd[2]
				// Check Type Unit yang dipilih
				if (unit.contains('pcs')) {
					Mobile.comment('Unit PCS')
					Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - PCS'), 0)

				} else if (unit.contains('ctn')) {
					Mobile.comment('Unit CTN')
					Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - CTN'), 0)

				} else {
					Mobile.comment('Unit Not Found')
				}

				// Input Ke Keranjang
				Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView -  Klik Keranjang Setelah Input'), 0)
				Mobile.comment('Product Berhasil Ditambahkan')
			}
		}

		// Click Menu Keranjang
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.ImageView - Menu Keranjang'), 0)
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Beli Dimenu Keranjang'), 0)
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Belanja Kurang Dari Minimum Transaksi'), 2, FailureHandling.OPTIONAL)) {
			Mobile.comment('Total Belanja Kurang')
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - OK Belanja Kurang Dari Minimum Transaksi'), 0)
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.ImageView - Tombol Back'), 0)
			} else {
			Mobile.comment('Checkout Berhasil')
		}
	}

	@Keyword
	def paymentMethod(typePaymentMethod, namePayment, useKinoKoin, typeKinoKoin, kinoKoin) {

		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Pilih Metode Pembayaran'), 0)

		// Check Type Payment Method
		if(typePaymentMethod == 'bt') {
			Mobile.comment('Bank Transfer')
			paymentMethodBankTransfer(namePayment)

		} else if (typePaymentMethod == 'va') {
			Mobile.comment('Virtual Account')
			paymentMethodVA(namePayment)

		} else if (typePaymentMethod == 'ewallet') {
			Mobile.comment('E-Wallet')
			paymentMethodEWallet(namePayment)

		} else if (typePaymentMethod == 'cod') {
			Mobile.comment('COD')
			paymentMethodCOD()
		} else {
			Mobile.comment('CAD')
			paymentMethodCAD()
		}

		// Close typePaymentMethod
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Confirm Metode Pembayaran'), 0)

		// Check Kino Koin
		doKinoKoin(useKinoKoin, typeKinoKoin, kinoKoin)

		// Click Konfirmasi Pesanan
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Konfirmasi Pesanan'), 0)

		// Tata Cara Bayar (harusnya get datanya)
		//Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.ImageView - Copy Total Tagihan'), 0)
		//Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.ImageView - Copy No VA'), 0)
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - OK di Tata Cara Bayar'), 0)
	}

	@Keyword
	def paymentMethodBankTransfer(namePayment) {

		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Transfer Bank (Verifikasi Manual)'), 0)

		// Check Name Payment Channel
		if (namePayment == 'bca') {
			Mobile.comment('Bank Transfer BCA')
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Transfer Bank BCA'), 0)
		} else if (namePayment == 'mandiri') {
			Mobile.comment('Bank Transfer Mandiri')
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Transfer Bank Mandiri'), 0)
		} else {
			Mobile.comment('Bank Transfer Not Found')

		}
	}

	@Keyword
	def paymentMethodVA(namePayment) {

		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Virtual Account'), 0)

		// Check Name Payment Channel
		if (namePayment == 'bca') {
			Mobile.comment('Virtual Account BCA')

		} else if (namePayment == 'mandiri') {
			Mobile.comment('Virtual Account Mandiri')
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Mandiri Virtual Account'), 0)
		} else {
			Mobile.comment('Virtual Account Not Found')
		}
	}

	@Keyword
	def paymentMethodEWallet(namePayment) {
		
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - E Wallet'), 0)
		
			// Check Name Payment Channel
			if (namePayment == 'gopay') {
				Mobile.comment('EWallet Gopay')
				Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Gopay E-Wallet'), 0)
			} else {
				Mobile.comment('EWallet Not Found')
			}
		}
	
	@Keyword
	def paymentMethodCOD() {
		
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Cash On Delivery'), 0)
		
	}
	
	@Keyword
	def paymentMethodCAD() {
		
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Cash After Delivery'), 0)
		
	}

	@Keyword
	def doKinoKoin(useKinoKoin, typeKinoKoin, kinoKoin) {
		
		Mobile.scrollToText('Alamat Penagihan')
		
		// Check Total Product
		String tp = Mobile.getText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Total Product'), 2)
		Mobile.comment('Total Product tp'+tp)
		
		// Check Total Tagihan Awal
		String ttawal = Mobile.getText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Total Tagihan'), 2)
		Mobile.comment('Total Tagihan Awal '+ttawal)
		
		// Check Kino Koin
		String kk = Mobile.getText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Total Kino Koin Punya'), 2)
		Mobile.comment('Kino Koin '+kk)
		
		Mobile.scrollToText('Alamat Penagihan')

		// Check Apakah Ingin Menggunakan Kino Koin?
		if (useKinoKoin == 'tidak') {
			Mobile.comment('Not Use Kino Koin')

			// Cek Potensial Bonus
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Lihat potensial bonus Anda'), 0)
			String pb = Mobile.getText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Potensial Kino Koin'), 0)
			Mobile.comment('Cek Potensial Bonus '+pb)
			Mobile.delay(2)
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.ImageView - Tombol Back'), 0)
		} else {
			Mobile.comment('Use Kino Koin')

			// Cek Potensial Bonus
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Lihat potensial bonus Anda'), 0)
			String pb = Mobile.getText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Potensial Kino Koin'), 0)
			Mobile.comment('Cek Potensial Bonus '+pb)
			Mobile.delay(2)
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.ImageView - Tombol Back'), 0)
			
			// Click Checkbox
			Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.CheckBox - Kino Koin'), 0)
			
			if (typeKinoKoin == 'semua') {
				
				// Check Jikalau kk kinoKoin < tp Total Product
//				if(kk.toInteger() < tp.toInteger()) {
//					
//					// Click Checkbox
//					Mobile.comment('Kino Koin Tidak Cukup')
//					Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.CheckBox - Kino Koin'), 0)
//				} else {
//					Mobile.comment('Use Semua Kino Koin')
//				}
								
				Mobile.comment('Use Semua Kino Koin')
				// Check Total Tagihan Akhir
				String ttakhir = Mobile.getText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Total Tagihan'), 2)
				Mobile.comment('Total Tagihan Akhir '+ttakhir)
				Mobile.delay(2)
			} else {
				
				// Check jikalau kinokoin < inputan Kino Koin
//				if (kk.toInteger() < kinoKoin) {
//					// Click Checkbox
//					Mobile.comment('Kino Koin Tidak Cukup')
//					Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.CheckBox - Kino Koin'), 0)
//				} else {
//					Mobile.comment('Use Sebagian Kino Koin ' +kinoKoin)
//				}
				
				Mobile.comment('Use Sebagian Kino Koin ' +kinoKoin)
				
				Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Dropdown Use Kino Koin'), 0)
				Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Pakai sebagian kino coin'), 0)
				Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.EditText - Input Kino Koin'), 0)
				AndroidDriver<?> driver = MobileDriverFactory.getDriver()

				String [] koin = kinoKoin
				for(int i = 0;i < koin.length; i++) {
					//Mobile.comment(koin[i])
					switch(koin[i]) {
						case (koin[i] = '0') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
							break
						case (koin[i] = '1') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1))
							break
						case (koin[i] = '2') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))
							break
						case (koin[i] = '3') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3))
							break
						case (koin[i] = '4') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4))
							break
						case (koin[i] = '5') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5))
							break
						case (koin[i] = '6') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6))
							break
						case (koin[i] = '7') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7))
							break
						case (koin[i] = '8') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8))
							break
						case (koin[i] = '9') :
							driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9))
							break
					}
				}

				driver.pressKey(new KeyEvent(AndroidKey.ENTER));
				Mobile.delay(2)
				
				// Check Total Tagihan Akhir
				String ttakhir = Mobile.getText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Total Tagihan'), 2)
				Mobile.comment('Total Tagihan Akhir '+ttakhir)
				
				// Check Potensial Bonus Update
				Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Lihat potensial bonus Anda'), 0)
				String pbu = Mobile.getText(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.TextView - Potensial Kino Koin'), 0)
				Mobile.comment('Cek Potensial Bonus Update '+pbu)
				Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.ImageView - Tombol Back'), 0)

			}
		}
	}
}
