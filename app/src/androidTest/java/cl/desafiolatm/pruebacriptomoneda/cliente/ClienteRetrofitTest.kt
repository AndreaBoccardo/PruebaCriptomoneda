package cl.desafiolatm.pruebacriptomoneda.cliente

import androidx.test.ext.junit.runners.AndroidJUnit4
import cl.desafiolatm.pruebacriptomoneda.FileReader
import com.google.common.truth.Truth
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ClienteRetrofitTest {

    private val server = MockWebServer()
    private val body = FileReader.lectorJson("moneda.json")

    @Before
    fun setUp() {
        server.start(8080)
        server.enqueue(MockResponse().setResponseCode(200).setBody(body))
        server.url("assets")
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun test_apiSuccess(){
        val call = ClienteRetrofit.getInstancia().getMoneda()
        var moneda = call.execute().body()
        Truth.assertThat(moneda?.data?.get(0)!!.name).isEqualTo("Bitcoin")
    }
}