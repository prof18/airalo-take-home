package com.prof18.airalo.countrypackages.data.remote.dto

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import org.intellij.lang.annotations.Language
import org.junit.Test
import kotlin.test.assertNotNull

@OptIn(ExperimentalStdlibApi::class)
class CountryPackagesDTOTest {
    @Test
    fun `Verify that the countryDTO is correctly deserialized`() {
        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<CountryPackagesDTO>()

        val countries = jsonAdapter.fromJson(countryPackagesJson)

        assertNotNull(countries)
    }
}

@Language("JSON")
val countryPackagesJson = """
    {
      "id": 195,
      "slug": "singapore",
      "title": "Singapore",
      "image": {
        "width": 132,
        "height": 99,
        "url": "https://cdn.airalo.com/images/ac5a6754-33dd-42ca-911f-ed481917c91b.png"
      },
      "seo": null,
      "packages": [
        {
          "id": 4149,
          "slug": "connect-lah-7days-1gb",
          "type": "sim",
          "price": 7.5,
          "title": "1 GB - 7 Days",
          "data": "1 GB",
          "validity": "7 Days",
          "day": 7,
          "amount": 1024,
          "is_unlimited": false,
          "note": null,
          "short_info": "This eSIM doesn't come with a phone number.",
          "calling_credit": null,
          "fair_usage_policy": null,
          "is_stock": true,
          "operator": {
            "id": 621,
            "title": "Connect Lah!",
            "style": "light",
            "gradient_start": "#8897ff",
            "gradient_end": "#ced9fd",
            "is_kyc_verify": 0,
            "kyc_type": null,
            "operator_legal_name": null,
            "privacy_policy_url": null,
            "type": "local",
            "is_prepaid": false,
            "is_multi_package": true,
            "plan_type": "data",
            "activation_policy": "first-usage",
            "rechargeability": true,
            "other_info": null,
            "apn_type": "single",
            "apn_type_ios": "automatic",
            "apn_type_android": "single",
            "apn_single": "e-ideas",
            "data_roaming": false,
            "apn": null,
            "networks": [
              {
                "network": "Singtel",
                "service_type": "LTE",
                "status": true
              }
            ],
            "info": [
              ""
            ],
            "image": {
              "width": 1035,
              "height": 653,
              "url": "https://cdn.airalo.com/images/d71dd812-9787-408e-a362-85346756762c.jpg"
            },
            "countries": [
              {
                "id": 195,
                "slug": "singapore",
                "title": "Singapore",
                "image": {
                  "width": 132,
                  "height": 99,
                  "url": "https://cdn.airalo.com/images/ac5a6754-33dd-42ca-911f-ed481917c91b.png"
                }
              }
            ]
          }
        },
        {
          "id": 4151,
          "slug": "connect-lah-30days-3gb",
          "type": "sim",
          "price": 15,
          "title": "3 GB - 30 Days",
          "data": "3 GB",
          "validity": "30 Days",
          "day": 30,
          "amount": 3072,
          "is_unlimited": false,
          "note": null,
          "short_info": "This eSIM doesn't come with a phone number.",
          "calling_credit": null,
          "fair_usage_policy": null,
          "is_stock": true,
          "operator": {
            "id": 621,
            "title": "Connect Lah!",
            "style": "light",
            "gradient_start": "#8897ff",
            "gradient_end": "#ced9fd",
            "is_kyc_verify": 0,
            "kyc_type": null,
            "operator_legal_name": null,
            "privacy_policy_url": null,
            "type": "local",
            "is_prepaid": false,
            "is_multi_package": true,
            "plan_type": "data",
            "activation_policy": "first-usage",
            "rechargeability": true,
            "other_info": null,
            "apn_type": "single",
            "apn_type_ios": "automatic",
            "apn_type_android": "single",
            "apn_single": "e-ideas",
            "data_roaming": false,
            "apn": null,
            "networks": [
              {
                "network": "Singtel",
                "service_type": "LTE",
                "status": true
              }
            ],
            "info": [
              ""
            ],
            "image": {
              "width": 1035,
              "height": 653,
              "url": "https://cdn.airalo.com/images/d71dd812-9787-408e-a362-85346756762c.jpg"
            },
            "countries": [
              {
                "id": 195,
                "slug": "singapore",
                "title": "Singapore",
                "image": {
                  "width": 132,
                  "height": 99,
                  "url": "https://cdn.airalo.com/images/ac5a6754-33dd-42ca-911f-ed481917c91b.png"
                }
              }
            ]
          }
        },
        {
          "id": 4153,
          "slug": "connect-lah-30days-5gb",
          "type": "sim",
          "price": 22.5,
          "title": "5 GB - 30 Days",
          "data": "5 GB",
          "validity": "30 Days",
          "day": 30,
          "amount": 5120,
          "is_unlimited": false,
          "note": null,
          "short_info": "This eSIM doesn't come with a phone number.",
          "calling_credit": null,
          "fair_usage_policy": null,
          "is_stock": true,
          "operator": {
            "id": 621,
            "title": "Connect Lah!",
            "style": "light",
            "gradient_start": "#8897ff",
            "gradient_end": "#ced9fd",
            "is_kyc_verify": 0,
            "kyc_type": null,
            "operator_legal_name": null,
            "privacy_policy_url": null,
            "type": "local",
            "is_prepaid": false,
            "is_multi_package": true,
            "plan_type": "data",
            "activation_policy": "first-usage",
            "rechargeability": true,
            "other_info": null,
            "apn_type": "single",
            "apn_type_ios": "automatic",
            "apn_type_android": "single",
            "apn_single": "e-ideas",
            "data_roaming": false,
            "apn": null,
            "networks": [
              {
                "network": "Singtel",
                "service_type": "LTE",
                "status": true
              }
            ],
            "info": [
              ""
            ],
            "image": {
              "width": 1035,
              "height": 653,
              "url": "https://cdn.airalo.com/images/d71dd812-9787-408e-a362-85346756762c.jpg"
            },
            "countries": [
              {
                "id": 195,
                "slug": "singapore",
                "title": "Singapore",
                "image": {
                  "width": 132,
                  "height": 99,
                  "url": "https://cdn.airalo.com/images/ac5a6754-33dd-42ca-911f-ed481917c91b.png"
                }
              }
            ]
          }
        },
        {
          "id": 4165,
          "slug": "connect-lah-30days-10gb",
          "type": "sim",
          "price": 33.5,
          "title": "10 GB - 30 Days",
          "data": "10 GB",
          "validity": "30 Days",
          "day": 30,
          "amount": 10240,
          "is_unlimited": false,
          "note": null,
          "short_info": null,
          "calling_credit": null,
          "fair_usage_policy": null,
          "is_stock": true,
          "operator": {
            "id": 621,
            "title": "Connect Lah!",
            "style": "light",
            "gradient_start": "#8897ff",
            "gradient_end": "#ced9fd",
            "is_kyc_verify": 0,
            "kyc_type": null,
            "operator_legal_name": null,
            "privacy_policy_url": null,
            "type": "local",
            "is_prepaid": false,
            "is_multi_package": true,
            "plan_type": "data",
            "activation_policy": "first-usage",
            "rechargeability": true,
            "other_info": null,
            "apn_type": "single",
            "apn_type_ios": "automatic",
            "apn_type_android": "single",
            "apn_single": "e-ideas",
            "data_roaming": false,
            "apn": null,
            "networks": [
              {
                "network": "Singtel",
                "service_type": "LTE",
                "status": true
              }
            ],
            "info": [
              ""
            ],
            "image": {
              "width": 1035,
              "height": 653,
              "url": "https://cdn.airalo.com/images/d71dd812-9787-408e-a362-85346756762c.jpg"
            },
            "countries": [
              {
                "id": 195,
                "slug": "singapore",
                "title": "Singapore",
                "image": {
                  "width": 132,
                  "height": 99,
                  "url": "https://cdn.airalo.com/images/ac5a6754-33dd-42ca-911f-ed481917c91b.png"
                }
              }
            ]
          }
        },
        {
          "id": 4167,
          "slug": "connect-lah-30days-20gb",
          "type": "sim",
          "price": 45,
          "title": "20 GB - 30 Days",
          "data": "20 GB",
          "validity": "30 Days",
          "day": 30,
          "amount": 20480,
          "is_unlimited": false,
          "note": null,
          "short_info": null,
          "calling_credit": null,
          "fair_usage_policy": null,
          "is_stock": true,
          "operator": {
            "id": 621,
            "title": "Connect Lah!",
            "style": "light",
            "gradient_start": "#8897ff",
            "gradient_end": "#ced9fd",
            "is_kyc_verify": 0,
            "kyc_type": null,
            "operator_legal_name": null,
            "privacy_policy_url": null,
            "type": "local",
            "is_prepaid": false,
            "is_multi_package": true,
            "plan_type": "data",
            "activation_policy": "first-usage",
            "rechargeability": true,
            "other_info": null,
            "apn_type": "single",
            "apn_type_ios": "automatic",
            "apn_type_android": "single",
            "apn_single": "e-ideas",
            "data_roaming": false,
            "apn": null,
            "networks": [
              {
                "network": "Singtel",
                "service_type": "LTE",
                "status": true
              }
            ],
            "info": [
              ""
            ],
            "image": {
              "width": 1035,
              "height": 653,
              "url": "https://cdn.airalo.com/images/d71dd812-9787-408e-a362-85346756762c.jpg"
            },
            "countries": [
              {
                "id": 195,
                "slug": "singapore",
                "title": "Singapore",
                "image": {
                  "width": 132,
                  "height": 99,
                  "url": "https://cdn.airalo.com/images/ac5a6754-33dd-42ca-911f-ed481917c91b.png"
                }
              }
            ]
          }
        }
      ]
    }
""".trimIndent()
