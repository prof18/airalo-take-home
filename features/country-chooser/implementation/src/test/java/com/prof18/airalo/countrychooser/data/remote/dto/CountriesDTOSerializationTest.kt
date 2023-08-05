package com.prof18.airalo.countrychooser.data.remote.dto

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import org.intellij.lang.annotations.Language
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@OptIn(ExperimentalStdlibApi::class)
class CountriesDTOSerializationTest {
    @Test
    fun `Verify that the countryDTO is correctly deserialized`() {
        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<List<CountryDTO>>()

        val countries = jsonAdapter.fromJson(countryJson)

        assertNotNull(countries)
        assertTrue(countries.isNotEmpty())
    }
}

@Language("JSON")
private val countryJson = """
    [
      {
        "id": 112,
        "slug": "italy",
        "title": "Italy",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/5d7cdb58-591c-45d6-a9d1-050829acd0ab.png"
        },
        "seo": {
          "title": null,
          "keywords": null,
          "description": null
        },
        "package_count": 6
      },
      {
        "id": 235,
        "slug": "united-states",
        "title": "United States",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/600de234-ec12-4e1f-b793-c70860e4545a.png"
        },
        "seo": {
          "title": null,
          "keywords": null,
          "description": null
        },
        "package_count": 6
      },
      {
        "id": 116,
        "slug": "japan",
        "title": "Japan",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/991049be-2b25-4e87-bca7-b93e8bbd1b77.png"
        },
        "seo": null,
        "package_count": 6
      },
      {
        "id": 227,
        "slug": "turkey",
        "title": "Turkey",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/8efbff32-b788-4098-a957-7fc4b9febb50.png"
        },
        "seo": null,
        "package_count": 6
      },
      {
        "id": 219,
        "slug": "thailand",
        "title": "Thailand",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/b980ec51-80de-4311-bc41-606e91752460.png"
        },
        "seo": null,
        "package_count": 2
      },
      {
        "id": 103,
        "slug": "indonesia",
        "title": "Indonesia",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/08c0ce67-64b4-44d3-920c-ba80dd036151.png"
        },
        "seo": null,
        "package_count": 6
      },
      {
        "id": 6,
        "slug": "albania",
        "title": "Albania",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/dd9baa70-5d51-4a6a-8673-95e09c2acef1.png"
        },
        "seo": null,
        "package_count": 6
      },
      {
        "id": 230,
        "slug": "tanzania",
        "title": "Tanzania",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/d8a7f6bb-78c5-45c6-8140-20f122632304.png"
        },
        "seo": null,
        "package_count": 5
      },
      {
        "id": 50,
        "slug": "colombia",
        "title": "Colombia",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/db651b86-e7dc-4952-ad86-1a8d603a5113.png"
        },
        "seo": null,
        "package_count": 4
      },
      {
        "id": 42,
        "slug": "switzerland",
        "title": "Switzerland",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/4d764558-3365-4757-8360-a5cd7cfa4ab7.png"
        },
        "seo": null,
        "package_count": 6
      },
      {
        "id": 247,
        "slug": "south-africa",
        "title": "South Africa",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/44b29a31-1728-4a33-86dc-11ca4ca2d456.png"
        },
        "seo": null,
        "package_count": 5
      },
      {
        "id": 105,
        "slug": "india",
        "title": "India",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/054cac1d-abf6-4d8a-82e3-a5e16271b782.png"
        },
        "seo": null,
        "package_count": 4
      },
      {
        "id": 143,
        "slug": "mexico",
        "title": "Mexico",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/182d93cc-bbff-4573-865e-cdee85bdd385.png"
        },
        "seo": null,
        "package_count": 4
      },
      {
        "id": 40,
        "slug": "canada",
        "title": "Canada",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/315128d1-0671-4648-b13d-bf9614cd0a15.png"
        },
        "seo": null,
        "package_count": 5
      },
      {
        "id": 158,
        "slug": "malaysia",
        "title": "Malaysia",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/8e2088a7-1ec8-4041-ab73-d5c1033bd3f2.png"
        },
        "seo": null,
        "package_count": 6
      },
      {
        "id": 76,
        "slug": "france",
        "title": "France",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/9753dedb-d495-47cf-b6e4-82e555564743.png"
        },
        "seo": null,
        "package_count": 6
      },
      {
        "id": 242,
        "slug": "vietnam",
        "title": "Vietnam",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/801dd2cd-d1de-45a3-9869-c6d453145f38.png"
        },
        "seo": null,
        "package_count": 6
      },
      {
        "id": 70,
        "slug": "spain",
        "title": "Spain",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/c9c87a09-69f5-4c5c-8d20-633539ab5aca.png"
        },
        "seo": null,
        "package_count": 6
      },
      {
        "id": 67,
        "slug": "egypt",
        "title": "Egypt",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/2da50ef3-d1f6-48d0-9b0c-c31c80ac76e0.png"
        },
        "seo": null,
        "package_count": 3
      },
      {
        "id": 80,
        "slug": "united-kingdom",
        "title": "United Kingdom",
        "image": {
          "width": 132,
          "height": 99,
          "url": "https://cdn.airalo.com/images/38db53aa-6e44-4e65-a106-9465b8e25182.png"
        },
        "seo": {
          "title": null,
          "keywords": null,
          "description": null
        },
        "package_count": 6
      }
    ]
""".trimIndent()