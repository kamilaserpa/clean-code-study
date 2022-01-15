package refactown.cleancode.c07exceptions

import com.google.gson.Gson

typealias JsonParserFunction = (String, Class<*>) -> Any

/*
 * Problemas:
 * - Não retorna uma exceção
 * - Abafa exceção do Gson
 * - Retorna "null"
 * - Imprime direto no console
 *
 */
fun fromJsonV0(json: String, clazz: Class<*>): Any?{
    val gson = Gson()
    try {
        return gson.fromJson(json, clazz)
    } catch (e: Exception){
        println("Parsing error. Json text:$json")
        return null
    }
}

/*
* Problemas:
* - Abafa exceção do Gson
*/
fun fromJsonV1(json: String, clazz: Class<*>): Any{
    val gson = Gson()
    try {
        return gson.fromJson(json, clazz)
    } catch (e: Exception){
        throw JsonException("Parsing error. Json text:$json")
    }
}

fun fromJsonV2(json: String, clazz: Class<*>): Any{
    val gson = Gson()
    try {
        return gson.fromJson(json, clazz)
    } catch (e: Exception){
        throw JsonException("Parsing error. Json text:$json", e)
    }
}
