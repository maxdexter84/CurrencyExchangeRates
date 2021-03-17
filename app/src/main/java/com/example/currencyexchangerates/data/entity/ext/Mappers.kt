package com.example.currencyexchangerates.data.entity.ext

import com.example.currencyexchangerates.data.entity.remoteCurrency.ResponseCBR
import com.example.currencyexchangerates.ui.entity.UICurrency

fun ResponseCBR.mapToUICurrency(): List<UICurrency>{
    val list = mutableListOf<UICurrency>()
    this.valute.let{
        list.add(UICurrency(iD = it.aUD.iD, date = date,charCode = it.aUD.charCode,nominal = it.aUD.nominal,name = it.aUD.name, value = it.aUD.value))
        list.add(UICurrency(iD = it.aZN.iD, date = date,charCode = it.aZN.charCode,nominal = it.aZN.nominal,name = it.aZN.name, value = it.aZN.value))
        list.add(UICurrency(iD = it.gBP.iD, date = date,charCode = it.gBP.charCode,nominal = it.gBP.nominal,name = it.gBP.name, value = it.gBP.value))
        list.add(UICurrency(iD = it.aMD.iD, date = date,charCode = it.aMD.charCode,nominal = it.aMD.nominal,name = it.aMD.name, value = it.aMD.value))
        list.add(UICurrency(iD = it.bYN.iD, date = date,charCode = it.bYN.charCode,nominal = it.bYN.nominal,name = it.bYN.name, value = it.bYN.value))
        list.add(UICurrency(iD = it.bGN.iD, date = date,charCode = it.bGN.charCode,nominal = it.bGN.nominal,name = it.bGN.name, value = it.bGN.value))
        list.add(UICurrency(iD = it.bRL.iD, date = date,charCode = it.bRL.charCode,nominal = it.bRL.nominal,name = it.bRL.name, value = it.bRL.value))
        list.add(UICurrency(iD = it.hUF.iD, date = date,charCode = it.hUF.charCode,nominal = it.hUF.nominal,name = it.hUF.name, value = it.hUF.value))
        list.add(UICurrency(iD = it.hKD.iD, date = date,charCode = it.hKD.charCode,nominal = it.hKD.nominal,name = it.hKD.name, value = it.hKD.value))
        list.add(UICurrency(iD = it.dKK.iD, date = date,charCode = it.dKK.charCode,nominal = it.dKK.nominal,name = it.dKK.name, value = it.dKK.value))
        list.add(UICurrency(iD = it.uSD.iD, date = date,charCode = it.uSD.charCode,nominal = it.uSD.nominal,name = it.uSD.name, value = it.uSD.value))
        list.add(UICurrency(iD = it.eUR.iD, date = date,charCode = it.eUR.charCode,nominal = it.eUR.nominal,name = it.eUR.name, value = it.eUR.value))
        list.add(UICurrency(iD = it.iNR.iD, date = date,charCode = it.iNR.charCode,nominal = it.iNR.nominal,name = it.iNR.name, value = it.iNR.value))
        list.add(UICurrency(iD = it.kZT.iD, date = date,charCode = it.kZT.charCode,nominal = it.kZT.nominal,name = it.kZT.name, value = it.kZT.value))
        list.add(UICurrency(iD = it.cAD.iD, date = date,charCode = it.cAD.charCode,nominal = it.cAD.nominal,name = it.cAD.name, value = it.cAD.value))
        list.add(UICurrency(iD = it.kGS.iD, date = date,charCode = it.kGS.charCode,nominal = it.kGS.nominal,name = it.kGS.name, value = it.kGS.value))
        list.add(UICurrency(iD = it.cNY.iD, date = date,charCode = it.cNY.charCode,nominal = it.cNY.nominal,name = it.cNY.name, value = it.cNY.value))
        list.add(UICurrency(iD = it.mDL.iD, date = date,charCode = it.mDL.charCode,nominal = it.mDL.nominal,name = it.mDL.name, value = it.mDL.value))
        list.add(UICurrency(iD = it.nOK.iD, date = date,charCode = it.nOK.charCode,nominal = it.nOK.nominal,name = it.nOK.name, value = it.nOK.value))
        list.add(UICurrency(iD = it.pLN.iD, date = date,charCode = it.pLN.charCode,nominal = it.pLN.nominal,name = it.pLN.name, value = it.pLN.value))
        list.add(UICurrency(iD = it.rON.iD, date = date,charCode = it.rON.charCode,nominal = it.rON.nominal,name = it.rON.name, value = it.rON.value))
        list.add(UICurrency(iD = it.xDR.iD, date = date,charCode = it.xDR.charCode,nominal = it.xDR.nominal,name = it.xDR.name, value = it.xDR.value))
        list.add(UICurrency(iD = it.sGD.iD, date = date,charCode = it.sGD.charCode,nominal = it.sGD.nominal,name = it.sGD.name, value = it.sGD.value))
        list.add(UICurrency(iD = it.tJS.iD, date = date,charCode = it.tJS.charCode,nominal = it.tJS.nominal,name = it.tJS.name, value = it.tJS.value))
        list.add(UICurrency(iD = it.tRY.iD, date = date,charCode = it.tRY.charCode,nominal = it.tRY.nominal,name = it.tRY.name, value = it.tRY.value))
        list.add(UICurrency(iD = it.tMT.iD, date = date,charCode = it.tMT.charCode,nominal = it.tMT.nominal,name = it.tMT.name, value = it.tMT.value))
        list.add(UICurrency(iD = it.uZS.iD, date = date,charCode = it.uZS.charCode,nominal = it.uZS.nominal,name = it.uZS.name, value = it.uZS.value))
        list.add(UICurrency(iD = it.uAH.iD, date = date,charCode = it.uAH.charCode,nominal = it.uAH.nominal,name = it.uAH.name, value = it.uAH.value))
        list.add(UICurrency(iD = it.cZK.iD, date = date,charCode = it.cZK.charCode,nominal = it.cZK.nominal,name = it.cZK.name, value = it.cZK.value))
        list.add(UICurrency(iD = it.sEK.iD, date = date,charCode = it.sEK.charCode,nominal = it.sEK.nominal,name = it.sEK.name, value = it.sEK.value))
        list.add(UICurrency(iD = it.cHF.iD, date = date,charCode = it.cHF.charCode,nominal = it.cHF.nominal,name = it.cHF.name, value = it.cHF.value))
        list.add(UICurrency(iD = it.zAR.iD, date = date,charCode = it.zAR.charCode,nominal = it.zAR.nominal,name = it.zAR.name, value = it.zAR.value))
        list.add(UICurrency(iD = it.kRW.iD, date = date,charCode = it.kRW.charCode,nominal = it.kRW.nominal,name = it.kRW.name, value = it.kRW.value))
        list.add(UICurrency(iD = it.jPY.iD, date = date,charCode = it.jPY.charCode,nominal = it.jPY.nominal,name = it.jPY.name, value = it.jPY.value))
    }
    return list
}