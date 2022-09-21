//the physical keyboard handle
    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        //UtilityMethods(this).toast(keyCode.toString())
        return when (keyCode) {
            //the numeric keys
            in KeyEvent.KEYCODE_0..KeyEvent.KEYCODE_9 -> {
                Lib(this).playClick()
                if (inputField.text.toString() == "0") {
                    inputField.text = ""
                }
                inputField.append((keyCode - KeyEvent.KEYCODE_0).toString())
                true
            }
            //handle the numpad and the dpad
            in KeyEvent.KEYCODE_NUMPAD_0..KeyEvent.KEYCODE_NUMPAD_9, in KeyEvent.KEYCODE_DPAD_UP..KeyEvent.KEYCODE_DPAD_CENTER -> {
                if (!event.isNumLockOn) {
                    true
                } else { //take the button input
                    if (keyCode !in KeyEvent.KEYCODE_DPAD_UP..KeyEvent.KEYCODE_DPAD_CENTER) { //not a dpad key
                        Lib(this).playClick()
                        if (inputField.text.toString() == "0") {
                            inputField.text = ""
                        }
                        //clear custom type
                        if (!form.rb00.isChecked) {
                            form.ctField.text = ""
                        }
                        inputField.append((keyCode - KeyEvent.KEYCODE_NUMPAD_0).toString())
                        true

                    } else {    //handle the nav menu
                        when (keyCode) {
                            KeyEvent.KEYCODE_DPAD_LEFT -> {
                                Lib(this).playClick()
                                back()
                                true
                            }
                            KeyEvent.KEYCODE_DPAD_DOWN -> {
                                Lib(this).playClick()
                                first()
                                true
                            }
                            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                                Lib(this).playClick()
                                next()
                                true
                            }
                            KeyEvent.KEYCODE_DPAD_UP -> {
                                Lib(this).playClick()
                                last()
                                true
                            }
                            else -> {
                                true
                            }
                        }
                    }
                }
            }

            //the backspace
            KeyEvent.KEYCODE_DEL -> {
                Lib(this).playClick()
                inputField.text = inputField.text.dropLast(1)
                true
            }
            //the clear
            KeyEvent.KEYCODE_FORWARD_DEL -> {
                Lib(this).playClick()
                WarningDialog(this).clear { clearData() }
                true
            }
            //ctrl + R = Reset App Data
            KeyEvent.KEYCODE_R -> {
                Lib(this).playClick()
                if (event.isCtrlPressed) {
                    WarningDialog(this).reset({ clearData() }, { resetMore() })
                }
                true
            }
            //the dot
            KeyEvent.KEYCODE_NUMPAD_DOT, KeyEvent.KEYCODE_PERIOD -> {
                Lib(this).playClick()
                if (inputField.text.toString() == "") {
                    inputField.append("0.")
                } else {
                    inputField.append(".")
                }
                true
            }
            //the enter key
            KeyEvent.KEYCODE_NUMPAD_ENTER, KeyEvent.KEYCODE_NUMPAD_EQUALS, KeyEvent.KEYCODE_EQUALS, KeyEvent.KEYCODE_ENTER -> {
                if (event.isShiftPressed) {
                    form.total.performClick()
                    true
                } else {
                    form.enter.performClick()
                    true
                }
            }
            //ctrl + S = Save
            KeyEvent.KEYCODE_S -> {
                if (event.isCtrlPressed) {
                    Keyboard(this, form).save(currentQueueInput, currentQueueType)
                }
                true
            }

            else -> super.onKeyUp(keyCode, event)
        }
    }
