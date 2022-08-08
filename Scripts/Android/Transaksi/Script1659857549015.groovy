import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import kinoAndroid.*

KinoAndroidSignIn kasi = new KinoAndroidSignIn()
KinoAndroidTransaksi kat = new KinoAndroidTransaksi()

kasi.signInKinoAndroid(username, password)
kat.addProduct(checkProduct)
kat.paymentMethod(typePaymentMethod, namePayment, useKinoKoin, typeKinoKoin, kinoKoin)
