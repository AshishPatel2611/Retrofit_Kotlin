package com.codexalters.retrofitnewstructure

import com.google.gson.annotations.SerializedName

/**
 * Created by codexalters on 21/12/17.
 */
class IndexDetailBean {


    @SerializedName("id")
    val id: Int? = null
    @SerializedName("nCategoryId")
    val nCategoryId: String = ""
    @SerializedName("vCompanyName")
    val vCompanyName: String = ""
    @SerializedName("vTag")
    val vTag: String = ""
    @SerializedName("nIndexId")
    val nIndexId: String = ""
    @SerializedName("vTitleImage")
    val vTitleImage: String = ""
    @SerializedName("nContactNo")
    val nContactNo:String =""
    @SerializedName("vFax_Number")
    val vFax_Number: String = ""
    @SerializedName("vEmail")
    val vEmail: String = ""
    @SerializedName("vCompanyAddress")
    val vCompanyAddress: String = ""
    @SerializedName("vPurchaseUserName")
    val vPurchaseUserName: String = ""
    @SerializedName("isReportScam")
    val isReportScam: String = ""
    @SerializedName("nTotalViews")
    val nTotalViews: String = ""
    @SerializedName("vRemark")
    val vRemark: String = ""
    @SerializedName("vFirstImage")
    val vFirstImage: String = ""
    @SerializedName("vSecondImage")
    val vSecondImage: String = ""
    @SerializedName("vThirdImage")
    val vThirdImage: String = ""
    @SerializedName("dUpdatedDate")
    val dUpdatedDate: String = ""
    @SerializedName("dCreatedDate")
    val dCreatedDate: String = ""
    @SerializedName("vUnit")
    val vUnit: String = ""

    override fun toString(): String {
        return "IndexDetailBean(id=$id, nCategoryId='$nCategoryId', vCompanyName='$vCompanyName', vTag='$vTag', nIndexId='$nIndexId', vTitleImage='$vTitleImage', vFax_Number='$vFax_Number', vEmail='$vEmail', vCompanyAddress='$vCompanyAddress', vPurchaseUserName='$vPurchaseUserName', isReportScam='$isReportScam', nTotal='$nTotalViews', vRemark='$vRemark', vFirstImage='$vFirstImage', vSecondImage='$vSecondImage', vThirdImage='$vThirdImage', dUpdatedDate='$dUpdatedDate', dCreatedDate='$dCreatedDate',vUnit='$vUnit')"
    }


}