//finds total number of profiles to be downloaded
//this function uses some methods which are not here
//they are all inside the informer v2.3 Downloader activity..
    @RequiresApi(Build.VERSION_CODES.R)
    private fun pEnd() {
        var upperLimit = pEnd.toInt()
        var ctr = 0
        var isClose = 0
        var round = 0
        var lost = true
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                do {
                    val data = getData(createUrl(upperLimit.toString()))
                    ctr++   //keep track for number of turns it took
                    if (upperLimit < 0) {
                        break
                    }
                    if (data.size > 97510) {
                        //save this file to phone storage
                        saveFile(data, makeName(upperLimit.toString()))
                        when (round) {
                            0 -> {
                                upperLimit += 10000
                            }
                            1 -> {
                                isClose = 1
                                upperLimit += 1000
                            }
                            2 -> {
                                isClose = 2
                                upperLimit += 100
                            }
                            3 -> {
                                isClose = 3
                                upperLimit += 10
                            }
                            4 -> {
                                isClose = 4
                                upperLimit++
                            }
                        }
                    } else {
                        when (isClose) {
                            0 -> {
                                round = 1
                                upperLimit -= 5000
                            }
                            1 -> {
                                round = 2
                                upperLimit -= 500
                            }
                            2 -> {
                                round = 3
                                upperLimit -= 50
                            }
                            3 -> {
                                round = 4
                                upperLimit -= 5
                            }
                            4 -> {
                                //finally the job is done
                                upperLimit--
                                lost = false
                            }
                        }
                    }
                    runOnUiThread{
                        findViewById<TextView>(R.id.log).text = upperLimit.toString()
                    }
                } while (lost)

                /*
                runOnUiThread{
                    if (upperLimit < 0) {
                        findViewById<TextView>(R.id.log).text = "No Records Found !"
                    } else {
                        findViewById<TextView>(R.id.log).text = "$upperLimit Profiles Founds, We Have Started Downloading.."
                    }
                }
                 */
                if (upperLimit > 0) {
                    pEnd = upperLimit.toString()
                    //save upperLimit aka pEnd in cahce
                    util.setCache(ctx, "pEnd", pEnd)
                    //start the downloader
                    startDownloader()
                }
            }
        }


    }
