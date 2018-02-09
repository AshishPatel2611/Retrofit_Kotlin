package com.codexalters.retrofitnewstructure

import com.google.gson.annotations.SerializedName

/**
 * Created by codexalters on 21/12/17.
 */
 class CategoryBean  {

    @SerializedName("id")
    val id: Int? = null
    @SerializedName("vCategoryName")
    val vCategoryName: String = ""
    @SerializedName("vCategoryImage")
    val vCategoryImage: String = ""
    @SerializedName("isActive")
    val isActive: Int? = null
    @SerializedName("dCreatedDate")
    val dCreatedDate: String = ""

   override fun toString(): String {
      return "CategoryBean(id=$id, vCategoryName='$vCategoryName', vCategoryImage='$vCategoryImage', isActive=$isActive, dCreatedDate='$dCreatedDate')"
   }


}