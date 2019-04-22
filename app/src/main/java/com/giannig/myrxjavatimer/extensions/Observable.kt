package com.giannig.myrxjavatimer.extensions

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.subscribeOrLog(tag: String? = "NO TAG", function: (T) -> Unit) = subscribe({
    function(it)
}, {
    Log.e(tag, it.localizedMessage)
})