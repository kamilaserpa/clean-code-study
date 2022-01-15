package refactown.cleancode.c08boundary

class LogonController(private val jsonParser: JsonParser){

    fun logon(login: String, password: String): User{
        val userJson = callHttp(login, password)
        // Consumidor não acessa implementação de infraestrutura de parser do Json
        return jsonParser.fromJson(userJson, User::class.java) as User
    }

    private fun callHttp(login: String, password: String): String {
        return "{\"login\":\"admin\", \"role\":\"admin\"}" //MOCK
    }
}

data class User (val login: String, val role: String)
