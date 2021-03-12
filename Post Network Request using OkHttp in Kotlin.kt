//get data from server
    private suspend fun getData(link: String): ByteArray? {
        val client = OkHttpClient().newBuilder()
            .build()
        val mediaType: MediaType? = "text/plain".toMediaTypeOrNull()
        val body: RequestBody = create(mediaType, "")
        val request: Request = Request.Builder()
            .url("https://www.jk.gov.in/jkeservices/")
            .method("POST", body)
            .addHeader("Cookie", "JSESSIONID=1512D560F92003A5F159C30C4DB079DA")
            .build()
        val response: Response = client.newCall(request).execute()
        return response.body?.bytes()
    }


/*
*also make sure to add below dependencies to the build.gradle file of your project.
implementation 'com.squareup.okhttp3:okhttp:3.14.6'
    // for v4.x :
    // implementation 'com.squareup.okhttp3:okhttp:4.3.1'
*/
