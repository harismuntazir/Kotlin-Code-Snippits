val builder = AlertDialog.Builder(this)
builder.apply {
        setMessage("Permission to access your $name is required to use this app")
        setTitle("Dialog Title Here")
        setPositiveButton("OK") { _, _ ->
                //do positive action
        }
        setNegativeButton("Cancel") { _, _ ->
                //do negative action
        }
        builder.create().show()
}
