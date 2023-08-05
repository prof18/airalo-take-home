package com.prof18.airalo.countrypackages.data.remote.dto

import com.prof18.airalo.core.dto.ImageDTO
import com.prof18.airalo.core.dto.SeoDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class CountryPackagesDTO(
    val id: Int,
    val slug: String,
    val title: String,
    val image: ImageDTO,
    val seo: SeoDTO?,
    val packages: List<PackageDTO>,
) {
    @JsonClass(generateAdapter = true)
    data class PackageDTO(
        val id: Int,
        val slug: String,
        val type: String,
        val price: Double,
        val title: String,
        val amount: Int,
        val validity: String,
        val day: Int,
        val data: String,
        val operator: OperatorDTO,
        @Json(name = "is_unlimited") val isUnlimited: Boolean,
        @Json(name = "short_info") val shortInfo: String?,
        @Json(name = "is_stock") val isStock: Boolean,
    )

    @JsonClass(generateAdapter = true)
    data class OperatorDTO(
        val id: Int,
        val title: String,
        val style: String,
        val type: String,
        val rechargeability: Boolean,
        val networks: List<NetworkDTO>,
        val info: List<String>,
        val image: ImageDTO,
        val countries: List<CountryDTO>,
        @Json(name = "gradient_end") val gradientEnd: String,
        @Json(name = "gradient_start") val gradientStart: String,
        @Json(name = "is_kyc_verify") val isKycVerify: Int,
        @Json(name = "kyc_restriction") val kycRestriction: String?,
        @Json(name = "operator_legal_name") val operatorLegalName: String?,
        @Json(name = "privacy_policy_url") val privacyPolicyUrl: String?,
        @Json(name = "is_multi_package") val isMultiPackage: Boolean,
        @Json(name = "is_prepaid") val isPrepaid: Boolean,
        @Json(name = "plan_type") val planType: String,
        @Json(name = "activation_policy") val activationPolicy: String,
        @Json(name = "apn_type") val apnType: String,
        @Json(name = "apn_type_android") val apnTypeAndroid: String,
        @Json(name = "apn_type_ios") val apnTypeIos: String,
        @Json(name = "apn_single") val apnSingle: String,
        @Json(name = "apn") val apn: String?,
        @Json(name = "data_roaming") val dataRoaming: Boolean,
        @Json(name = "kyc_type") val kycType: String?,
        @Json(name = "other_info") val otherInfo: String?,
    )

    @JsonClass(generateAdapter = true)
    data class NetworkDTO(
        val network: String,
        val status: Boolean,
        @Json(name = "service_type") val serviceType: String,
    )

    @JsonClass(generateAdapter = true)
    data class CountryDTO(
        val id: Int,
        val image: ImageDTO,
        val slug: String,
        val title: String,
    )
}
