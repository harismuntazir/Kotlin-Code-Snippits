//start the coroutine like this
private fun startCoroutine() {
    GlobalScope.launch() {
        withContext(Dispatchers.IO) {
            //call some suspend function from here
            getData()
        }
    }
}   
//create the suspend function
private suspend fun getData() {
val link = "https://www.google.com/"
  withContext(Dispatchers.IO) {
    try {
      //do some network request 
      URL(link).readText()
    } catch(e: Exception) {
      e.printStackTrace()
    }
  }
}
 
    
