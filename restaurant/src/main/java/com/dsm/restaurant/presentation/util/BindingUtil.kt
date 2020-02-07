package com.dsm.restaurant.presentation.util

import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.dsm.restaurant.R
import mabbas007.tagsedittext.TagsEditText

@BindingAdapter("image")
fun ImageView.setImage(url: LiveData<String>?) {
    url?.let {
        Glide.with(this).load(it.value).into(this)
    }
}

@BindingAdapter("image")
fun ImageView.setImage(url: String?) {
    url?.let {
        Glide.with(this).load(it).into(this)
    }
}

@BindingAdapter("tags")
fun TagsEditText.bindTags(tagsMutableLiveData: MutableLiveData<List<String>>?) {
    tagsMutableLiveData?.value = this.tags.toList()
}

@BindingAdapter("passwordAnim")
fun MotionLayout.animPassword(isEmailChecked: Boolean) {
    if (isEmailChecked && this.currentState == R.id.start) {
        this.transitionToState(R.id.end)
    }
}