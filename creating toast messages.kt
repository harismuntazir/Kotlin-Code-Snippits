fun toast(msg: String, length: Int = 0) { //0 means TOAST.LENGTH_SHORT
  toast(applicationContext, msg, length).show()
}
  
