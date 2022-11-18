package com.y4n9b0.ak.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FooViewModel(a: Int, b: Boolean, c: String, d: String) : ViewModel() {
    val liveData: MutableLiveData<String> =
        MutableLiveData("Int=$a Boolean=$b String1=$c String2=$d")

    constructor(a: Int, b: Boolean, c: String) : this(a, b, c, "")
    constructor(a: Int, b: Int, c: String) : this(a, false, c, "")
    constructor(): this(6, true, "xixi", "haha")
}