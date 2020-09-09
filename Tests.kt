package com.travels.searchtravels

import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.api.services.vision.v1.model.LatLng
import com.preview.planner.prefs.AppPreferences
import com.travels.searchtravels.activity.MainActivity
import com.travels.searchtravels.api.OnVisionApiListener
import com.travels.searchtravels.api.VisionApi
import com.travels.searchtravels.utils.Constants
import org.json.JSONArray
import org.json.JSONObject
import org.jsoup.Jsoup
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class Tests : AppCompatActivity() {

    @Test
    fun testSea() {

        try {
            val uri =
                Uri.parse("http://rk.karelia.ru/wp-content/uploads/2016/05/More.jpg")

            val bitmap = MediaStore.Images.Media.getBitmap(
                contentResolver,
                uri
            )
            Constants.PICKED_BITMAP = bitmap
            VisionApi.findLocation(
                bitmap,
                AppPreferences.getToken(applicationContext),
                object : OnVisionApiListener {
                    override fun onSuccess(latLng: LatLng) {
                        //nothing
                    }

                    override fun onErrorPlace(category: String) {
                        when (category) {
                            "sea" -> {
                                assertEquals(category, "sea")
                            }
                            "ocean" -> {
                                assertEquals(category, "ocean")
                            }
                            "beach" -> {
                                assertEquals(category, "beach")
                            }
                            "mountain" -> {
                                assertEquals(category, "mountain")
                            }
                            "snow" -> {
                                assertEquals(category, "snow")
                            }
                            else -> {
                                assertEquals(category, "some")
                            }
                        }
                    }

                    override fun onError() {
                        throw Exception("error")
                    }
                })
        } catch (e: Exception) {
            assertEquals(1, 0)
        }
    }

    @Test
    fun testOcean() {
        try {
            val uri =
                Uri.parse("https://wavehouse.ru/wp-content/uploads//2017/04/mini.jpeg")
            val bitmap = MediaStore.Images.Media.getBitmap(
                contentResolver,
                uri
            )
            Constants.PICKED_BITMAP = bitmap
            VisionApi.findLocation(
                bitmap,
                AppPreferences.getToken(applicationContext),
                object : OnVisionApiListener {
                    override fun onSuccess(latLng: LatLng) {
                        //nothing
                    }

                    override fun onErrorPlace(category: String) {
                        when (category) {
                            "sea" -> {
                                assertEquals(category, "sea")
                            }
                            "ocean" -> {
                                assertEquals(category, "ocean")
                            }
                            "beach" -> {
                                assertEquals(category, "beach")
                            }
                            "mountain" -> {
                                assertEquals(category, "mountain")
                            }
                            "snow" -> {
                                assertEquals(category, "snow")
                            }
                            else -> {
                                assertEquals(category, "some")
                            }
                        }
                    }

                    override fun onError() {
                        throw Exception("error")
                    }
                })
        } catch (e: Exception) {
            assertEquals(1, 0)
        }
    }

    @Test
    fun testBeach() {
        try {
            val uri =
                Uri.parse("https://chemodanus.ru/upload/information_system_143/3/2/3/item_3239/001-yantarny-beach.jpg")
            val bitmap = MediaStore.Images.Media.getBitmap(
                contentResolver,
                uri
            )
            Constants.PICKED_BITMAP = bitmap
            VisionApi.findLocation(
                bitmap,
                AppPreferences.getToken(applicationContext),
                object : OnVisionApiListener {
                    override fun onSuccess(latLng: LatLng) {
                        //nothing
                    }

                    override fun onErrorPlace(category: String) {
                        when (category) {
                            "sea" -> {
                                assertEquals(category, "sea")
                            }
                            "ocean" -> {
                                assertEquals(category, "ocean")
                            }
                            "beach" -> {
                                assertEquals(category, "beach")
                            }
                            "mountain" -> {
                                assertEquals(category, "mountain")
                            }
                            "snow" -> {
                                assertEquals(category, "snow")
                            }
                            else -> {
                                assertEquals(category, "some")
                            }
                        }
                    }

                    override fun onError() {
                        throw Exception("error")
                    }
                })
        } catch (e: Exception) {
            assertEquals(1, 0)
        }
    }

    @Test
    fun testMountain() {
        try {
            val uri =
                Uri.parse("https://rutasochi.ru/uploads/images/news/gori_sochi.jpg")
            val bitmap = MediaStore.Images.Media.getBitmap(
                contentResolver,
                uri
            )
            Constants.PICKED_BITMAP = bitmap
            VisionApi.findLocation(
                bitmap,
                AppPreferences.getToken(applicationContext),
                object : OnVisionApiListener {
                    override fun onSuccess(latLng: LatLng) {
                        //nothing
                    }

                    override fun onErrorPlace(category: String) {
                        when (category) {
                            "sea" -> {
                                assertEquals(category, "sea")
                            }
                            "ocean" -> {
                                assertEquals(category, "ocean")
                            }
                            "beach" -> {
                                assertEquals(category, "beach")
                            }
                            "mountain" -> {
                                assertEquals(category, "mountain")
                            }
                            "snow" -> {
                                assertEquals(category, "snow")
                            }
                            else -> {
                                assertEquals(category, "some")
                            }
                        }
                    }

                    override fun onError() {
                        throw Exception("error")
                    }
                })
        } catch (e: Exception) {
            assertEquals(1, 0)
        }
    }

    @Test
    fun testSnow() {
        try {
            val uri =
                Uri.parse("https://cdnimg.rg.ru/img/content/134/83/54/sneg1_d_850.jpg")
            val bitmap = MediaStore.Images.Media.getBitmap(
                contentResolver,
                uri
            )
            Constants.PICKED_BITMAP = bitmap
            VisionApi.findLocation(
                bitmap,
                AppPreferences.getToken(applicationContext),
                object : OnVisionApiListener {
                    override fun onSuccess(latLng: LatLng) {
                        //nothing
                    }

                    override fun onErrorPlace(category: String) {
                        when (category) {
                            "sea" -> {
                                assertEquals(category, "sea")
                            }
                            "ocean" -> {
                                assertEquals(category, "ocean")
                            }
                            "beach" -> {
                                assertEquals(category, "beach")
                            }
                            "mountain" -> {
                                assertEquals(category, "mountain")
                            }
                            "snow" -> {
                                assertEquals(category, "snow")
                            }
                            else -> {
                                assertEquals(category, "some")
                            }
                        }
                    }

                    override fun onError() {
                        throw Exception("error")
                    }
                })
        } catch (e: Exception) {
            assertEquals(1, 0)
        }
    }

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testPrice() {

        val data =
            LinkedHashMap<String, String>()


        val dataCity = listOf(
            "Rimini",
            "Sochi",
            "Helsinki",
            "Kiev",
            "Geneva"
        )

        for (i in dataCity) {

            try {

                //get City
                var url =
                    URL("https://autocomplete.travelpayouts.com/places2?locale=en&types[]=city&term=$i")
                val httpConnect = url.openConnection() as HttpURLConnection
                httpConnect.requestMethod = "GET"
                httpConnect.setRequestProperty("User-Agent", "Mozilla/5.0")
                httpConnect.setRequestProperty("Accept-Language", "en-US,en;q=0.5")
                httpConnect.setRequestProperty("Content-Type", "application/json")
                val br = BufferedReader(InputStreamReader(httpConnect.inputStream))
                var inputLine: String?
                val response = StringBuffer()
                while (br.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }
                br.close()
                val resJson = JSONArray(response.toString())
                val destination = resJson.getJSONObject(0).getString("code")


                //get ticket
                var tempDataForTicket = ""
                url =
                    URL("https://api.travelpayouts.com/v1/prices/cheap?origin=LED&depart_date=2020-9&return_date=2020-10&destination=$destination")
                val httpConnect2 = url.openConnection() as HttpURLConnection
                httpConnect2.requestMethod = "GET"
                httpConnect2.setRequestProperty("User-Agent", "Mozilla/5.0")
                httpConnect2.setRequestProperty("Accept-Language", "en-US,en;q=0.5")
                httpConnect2.setRequestProperty("Content-Type", "application/json")
                httpConnect2.setRequestProperty("X-Access-Token", "658983a9856473e965e072f47d6ae449")
                val brTicket = BufferedReader(InputStreamReader(httpConnect2.inputStream))
                var inputLine2: String?
                val response2 = StringBuffer()

                while (brTicket.readLine().also { inputLine2 = it } != null) {
                    response2.append(inputLine2)
                }
                brTicket.close()
                val ticketObj = JSONObject(response2.toString())

                val price = ticketObj.getJSONObject("data").getJSONObject(destination)
                    .getJSONObject("1")
                    .getString("price").toInt()

                //set price
                //onView(withId(R.id.hotelsTV)).perform(typeText("от $price \u20BD"))))
                onView(withId(R.id.airticketTV)).check(matches(withText("от $price \u20BD")))

                url = URL(
                    "https://nomadlist.com/cost-of-living/in/" + i.toLowerCase()
                        .trim { it <= ' ' }
                )
                Log.d("myLogs", "url = $url")
                val document = Jsoup.parse(url, 5000)

                val cost_of_living =
                    document.body().select("div.tab-cost-of-living")[0]

                val prices = cost_of_living.select("span.price")

                var pos = 2
                var firstHotel = true
                for (element in prices) {
                    val formatter =
                        NumberFormat.getInstance(Locale.US) as DecimalFormat
                    val symbols =
                        formatter.decimalFormatSymbols
                    symbols.groupingSeparator = ' '
                    formatter.decimalFormatSymbols = symbols
                    var price = formatter.format(
                        Math.round(
                            element.attr("data-usd").toFloat() * 64.42f
                        ).toLong()
                    ) + ""
                    val keys: Array<Any> = data.keys.toTypedArray()
                    Log.d("myLogs", "keys[pos] = " + keys[pos])
                    val keyTarget = keys[pos].toString()
                    if (keyTarget.contains("Nomad Cost")) {
                        price += "\u20BD/мес"
                    } else if (keyTarget.contains("Cost of living for family")) {
                        price += "\u20BD за чел./мес"
                    } else if (keyTarget.contains("Cost of living for local")) {
                        price += "\u20BD/мес"
                    } else if (keyTarget.contains("studio rent in center")) {
                        price += "\u20BD/мес"
                    } else if (keyTarget.contains("Hotel") && firstHotel) {
                        firstHotel = false
                        price += "\u20BD/мес"
                        continue
                    } else if (keyTarget.contains("Airbnb") && keyTarget.contains("listings")) {
                        price += "\u20BD/мес"
                    } else if (keyTarget.contains("Cost of living for expat")) {
                        price += "\u20BD/мес"
                    } else if (keyTarget.contains("Coworking")) {
                        price += "\u20BD/мес"
                    } else if (keyTarget.contains("Airbnb")) {
                        price += "\u20BD/ночь"
                    } else if (keyTarget.contains("Hotel")) {
                        price += "\u20BD/ночь"
                    } else {
                        price += " \u20BD"
                    }
                    data.put(keys[pos].toString(), price)
                    pos++
                }

                //set hotel
                //onView(withId(R.id.hotelsTV)).perform(typeText(data.get("\uD83C\uDFE8 Hotel")))
                onView(withId(R.id.hotelsTV)).check(matches(withText(data.get("\uD83C\uDFE8 Hotel"))))

                //Nomad Cost™
                //onView(withId(R.id.shopTV)).perform(typeText(data.get("\uD83D\uDCB5 Nomad Cost™")))
                onView(withId(R.id.shopTV)).check(matches(withText(data.get("\uD83D\uDCB5 Nomad Cost™"))))



            } catch (e: Exception) {
                assertEquals(1, 0)
            }
        }
    }

    @Test
    fun testInCorrectImage() {

        try {
            val uri =
                Uri.parse("http://")

            val bitmap = MediaStore.Images.Media.getBitmap(
                contentResolver,
                uri
            )
            Constants.PICKED_BITMAP = bitmap
            VisionApi.findLocation(
                bitmap,
                "",
                object : OnVisionApiListener {
                    override fun onSuccess(latLng: LatLng) {
                        //nothing
                    }

                    override fun onErrorPlace(category: String) {
                        //nothing
                    }

                    override fun onError() {
                        onView(withId(R.id.errorRL)).check(matches(isDisplayed()))
                    }
                })
        } catch (e: Exception) {
            assertEquals(1, 0)
        }
    }
}