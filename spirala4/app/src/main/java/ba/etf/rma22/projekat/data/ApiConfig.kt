package ba.etf.rma22.projekat.data
/*
postaviBaseURL(baseUrl:String):Unit - postavlja base url za web servise,
 ukoliko se ova metoda ne pozove koristi se defaultni url
 */
class ApiConfig {
    companion object{
        var baseURL:String = "https://rma22ws.herokuapp.com"

    fun postaviBaseURL(baseUrl:String){
        baseURL =baseUrl
    }

    fun getUrl():String{
        return baseURL
    }
    }
}