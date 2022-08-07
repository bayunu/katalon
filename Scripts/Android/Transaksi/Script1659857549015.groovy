import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import kinoAndroid.*

KinoAndroidSignIn kasi = new KinoAndroidSignIn()
KinoAndroidTransaksi kat = new KinoAndroidTransaksi()

Mobile.startExistingApplication('id.powercommerce.mobile_commerce')

//kasi.signInKinoAndroid(username, password)
//kat.addProduct(checkProduct)

kat.paymentMethod(typePaymentMethod, namePayment, useKinoKoin, typeKinoKoin, kinoKoin)
