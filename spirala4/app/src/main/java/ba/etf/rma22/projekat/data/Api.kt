package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.*
import org.json.JSONObject
import retrofit2.http.*

interface Api {
    @GET("/istrazivanje") suspend fun DajSvaIstrazivanja(@Query("offset") offset: Int): List<Istrazivanje>
    @GET("/istrazivanje{id}") suspend fun DajIstrazivanjePoId(@Path("id") id: Int): Istrazivanje
    @GET("/grupe/{gid}/istrazivanje") suspend fun DajIstrazivanjaZaGrupu(@Path("gid") id: Int): List<Istrazivanje>

    //
    //Grupe
    //

    @GET("/student/{id}/grupa") suspend fun DajGrupeStudenta(@Path("id") hashStudenta:String): List<Grupa>
    @POST("/grupa/{gid}/student/{id}")
    suspend fun DodajStudenta(@Path("gid") idGrupa: Int, @Path("id") hashStudenta: String): Poruka
    @GET("/grupa") suspend fun DajSveGrupe(): List<Grupa>
    @GET("/grupa/{id}") suspend fun DajGrupu(@Path("id") id: Int): Grupa

    //////////
    //Anketa
    /////////

    @GET("/anketa") suspend fun DajSveAnkete(@Query("offset") offset: Int): List<Anketa>
    @GET("/anketa/{id}") suspend fun DajAnketu(@Path("id") id: Int): Anketa
    @GET("/grupa/{id}/ankete") suspend fun DajAnketeZaGrupu(@Path("id") id: Int): List<AnketaGrupa>

    //
    //AnketaTaken
    //

    @GET("/student/{id}/anketataken") suspend fun DajListuZapocetihAnketa(@Path("id") hashStudenta: String):List<AnketaTaken>
    @POST("/student/{id}/anketa/{kid}")
    suspend fun ZapocniAnketu(@Path("id") hashStudenta: String, @Path("kid") kid:Int):AnketaTaken

    //
    //Account
    //

     @GET("/student/{id}") suspend fun DajStudenta(@Path("id") id: Int): Account
    //
    //Odgovori
    //

    @GET("/student/{id}/anketataken/{ktid}/odgovori")
    suspend fun DajListuOdgovora(@Path("id") hashStudenta: String, @Path("ktid") kid:Int): List<Odgovor>
    @POST("/student/{id}/anketataken/{ktid}/odgovor")
    suspend fun DodajOdgovor(@Path("id") hashStudenta: String, @Path("ktid") kid:Int, @Body odgovor:OdgovorAnketa)

    //
    //Pitanje
    //

    @GET("anketa/{id}/pitanja")
    suspend fun DajPitanjaZaAnketu(@Path("id") id: Int): List<Pitanje>
}