private suspend fun createFile(fileContents: ByteArray) {
        return withContext(Dispatchers.IO) {
            try {
                //create file
                val fileName = "tmp.txt"
                val path = "/mnt/user/0/primary/Informer/"
                val file= File(path,fileName)
                if (!file.exists()) {
                    file.createNewFile()
                }
                val fileOutputStream = FileOutputStream(file)
                fileOutputStream.write(fileContents)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
