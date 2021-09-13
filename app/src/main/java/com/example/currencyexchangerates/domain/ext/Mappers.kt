package com.example.currencyexchangerates.domain.ext

import com.example.currencyexchangerates.data.model.localeCurrency.DbCurrency
import com.example.currencyexchangerates.data.model.remoteCurrency.ResponseCBR
import com.example.currencyexchangerates.ui.model.UICurrency

fun DbCurrency.mapToUICurrency(): UICurrency {

    return this.let {
        UICurrency(
            id = it.id,
            date = it.date,
            charCode = it.charCode,
            nominal = it.nominal,
            name = it.name,
            value = it.value
        )
    }
}

fun UICurrency.mapToDBCurrency(): DbCurrency {

    return this.let {
        DbCurrency(
            id = it.id,
            date = it.date,
            charCode = it.charCode,
            nominal = it.nominal,
            name = it.name,
            value = it.value
        )
    }
}

fun ResponseCBR.mapToUiCurrency(): List<UICurrency> {
    val list = mutableListOf<UICurrency>()
    this.Valute.let {
        list.add(
            UICurrency(
                id = it.AUD.ID,
                date = Date,
                charCode = it.AUD.CharCode,
                nominal = it.AUD.Nominal.toString(),
                name = it.AUD.Name,
                value = it.AUD.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.AZN.ID,
                date = Date,
                charCode = it.AZN.CharCode,
                nominal = it.AZN.Nominal.toString(),
                name = it.AZN.Name,
                value = it.AZN.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.GBP.ID,
                date = Date,
                charCode = it.GBP.CharCode,
                nominal = it.GBP.Nominal.toString(),
                name = it.GBP.Name,
                value = it.GBP.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.AMD.ID,
                date = Date,
                charCode = it.AMD.CharCode,
                nominal = it.AMD.Nominal.toString(),
                name = it.AMD.Name,
                value = it.AMD.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.BYN.ID,
                date = Date,
                charCode = it.BYN.CharCode,
                nominal = it.BYN.Nominal.toString(),
                name = it.BYN.Name,
                value = it.BYN.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.BGN.ID,
                date = Date,
                charCode = it.BGN.CharCode,
                nominal = it.BGN.Nominal.toString(),
                name = it.BGN.Name,
                value = it.BGN.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.BRL.ID,
                date = Date,
                charCode = it.BRL.CharCode,
                nominal = it.BRL.Nominal.toString(),
                name = it.BRL.Name,
                value = it.BRL.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.HUF.ID,
                date = Date,
                charCode = it.HUF.CharCode,
                nominal = it.HUF.Nominal.toString(),
                name = it.HUF.Name,
                value = it.HUF.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.HKD.ID,
                date = Date,
                charCode = it.HKD.CharCode,
                nominal = it.HKD.Nominal.toString(),
                name = it.HKD.Name,
                value = it.HKD.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.DKK.ID,
                date = Date,
                charCode = it.DKK.CharCode,
                nominal = it.DKK.Nominal.toString(),
                name = it.DKK.Name,
                value = it.DKK.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.USD.ID,
                date = Date,
                charCode = it.USD.CharCode,
                nominal = it.USD.Nominal.toString(),
                name = it.USD.Name,
                value = it.USD.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.EUR.ID,
                date = Date,
                charCode = it.EUR.CharCode,
                nominal = it.EUR.Nominal.toString(),
                name = it.EUR.Name,
                value = it.EUR.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.INR.ID,
                date = Date,
                charCode = it.INR.CharCode,
                nominal = it.INR.Nominal.toString(),
                name = it.INR.Name,
                value = it.INR.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.KZT.ID,
                date = Date,
                charCode = it.KZT.CharCode,
                nominal = it.KZT.Nominal.toString(),
                name = it.KZT.Name,
                value = it.KZT.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.CAD.ID,
                date = Date,
                charCode = it.CAD.CharCode,
                nominal = it.CAD.Nominal.toString(),
                name = it.CAD.Name,
                value = it.CAD.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.KGS.ID,
                date = Date,
                charCode = it.KGS.CharCode,
                nominal = it.KGS.Nominal.toString(),
                name = it.KGS.Name,
                value = it.KGS.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.CNY.ID,
                date = Date,
                charCode = it.CNY.CharCode,
                nominal = it.CNY.Nominal.toString(),
                name = it.CNY.Name,
                value = it.CNY.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.MDL.ID,
                date = Date,
                charCode = it.MDL.CharCode,
                nominal = it.MDL.Nominal.toString(),
                name = it.MDL.Name,
                value = it.MDL.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.NOK.ID,
                date = Date,
                charCode = it.NOK.CharCode,
                nominal = it.NOK.Nominal.toString(),
                name = it.NOK.Name,
                value = it.NOK.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.PLN.ID,
                date = Date,
                charCode = it.PLN.CharCode,
                nominal = it.PLN.Nominal.toString(),
                name = it.PLN.Name,
                value = it.PLN.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.RON.ID,
                date = Date,
                charCode = it.RON.CharCode,
                nominal = it.RON.Nominal.toString(),
                name = it.RON.Name,
                value = it.RON.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.XDR.ID,
                date = Date,
                charCode = it.XDR.CharCode,
                nominal = it.XDR.Nominal.toString(),
                name = it.XDR.Name,
                value = it.XDR.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.SGD.ID,
                date = Date,
                charCode = it.SGD.CharCode,
                nominal = it.SGD.Nominal.toString(),
                name = it.SGD.Name,
                value = it.SGD.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.TJS.ID,
                date = Date,
                charCode = it.TJS.CharCode,
                nominal = it.TJS.Nominal.toString(),
                name = it.TJS.Name,
                value = it.TJS.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.TRY.ID,
                date = Date,
                charCode = it.TRY.CharCode,
                nominal = it.TRY.Nominal.toString(),
                name = it.TRY.Name,
                value = it.TRY.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.TMT.ID,
                date = Date,
                charCode = it.TMT.CharCode,
                nominal = it.TMT.Nominal.toString(),
                name = it.TMT.Name,
                value = it.TMT.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.UZS.ID,
                date = Date,
                charCode = it.UZS.CharCode,
                nominal = it.UZS.Nominal.toString(),
                name = it.UZS.Name,
                value = it.UZS.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.UAH.ID,
                date = Date,
                charCode = it.UAH.CharCode,
                nominal = it.UAH.Nominal.toString(),
                name = it.UAH.Name,
                value = it.UAH.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.CZK.ID,
                date = Date,
                charCode = it.CZK.CharCode,
                nominal = it.CZK.Nominal.toString(),
                name = it.CZK.Name,
                value = it.CZK.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.SEK.ID,
                date = Date,
                charCode = it.SEK.CharCode,
                nominal = it.SEK.Nominal.toString(),
                name = it.SEK.Name,
                value = it.SEK.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.CHF.ID,
                date = Date,
                charCode = it.CHF.CharCode,
                nominal = it.CHF.Nominal.toString(),
                name = it.CHF.Name,
                value = it.CHF.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.ZAR.ID,
                date = Date,
                charCode = it.ZAR.CharCode,
                nominal = it.ZAR.Nominal.toString(),
                name = it.ZAR.Name,
                value = it.ZAR.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.KRW.ID,
                date = Date,
                charCode = it.KRW.CharCode,
                nominal = it.KRW.Nominal.toString(),
                name = it.KRW.Name,
                value = it.KRW.Value.toString()
            )
        )
        list.add(
            UICurrency(
                id = it.JPY.ID,
                date = Date,
                charCode = it.JPY.CharCode,
                nominal = it.JPY.Nominal.toString(),
                name = it.JPY.Name,
                value = it.JPY.Value.toString()
            )
        )
    }
    return list
}


