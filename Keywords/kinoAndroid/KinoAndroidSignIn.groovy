package kinoAndroid

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

public class KinoAndroidSignIn {

	@Keyword
	def signInKinoAndroid(username, password) {

		Mobile.startExistingApplication('id.powercommerce.mobile_commerce')
		
		Mobile.tap(findTestObject('Object Repository/Android/Kino/Transaksi/android.widget.FrameLayout - Menu Profile'), 0)

		// Cek Kondisi Kalo Misal Udah Login atau Belum Login
		if (Mobile.verifyElementExist(findTestObject('Object Repository/Android/Kino/SignInSignOut/android.widget.TextView - Tombol Masuk Sebelum Input Username'), 2, FailureHandling.OPTIONAL)) {

			//Mobile.verifyElementExist(null, 0)
			// Login Pertama Kali
			Mobile.comment('signInKinoAndroid for First Time')
			Mobile.tap(findTestObject('Object Repository/Android/Kino/SignInSignOut/android.widget.TextView - Tombol Masuk Sebelum Input Username'), 0)
			Mobile.setText(findTestObject('Object Repository/Android/Kino/SignInSignOut/android.widget.EditText - Masukkan email  nomor handphone'), username, 0)
			Mobile.setText(findTestObject('Object Repository/Android/Kino/SignInSignOut/android.widget.EditText - Masukkan kata sandi'), password, 0)
			Mobile.tap(findTestObject('Object Repository/Android/Kino/SignInSignOut/android.widget.ImageView - View Password Login'), 0)
			Mobile.tap(findTestObject('Object Repository/Android/Kino/SignInSignOut/android.widget.TextView - Tombol Masuk Setelah Input Username'), 0)
		} else {

			// Login Pertama Kali
			Mobile.comment('Already signInKinoAndroid')
		}
	}
}
