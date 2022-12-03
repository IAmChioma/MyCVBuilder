package com.example.mycvbuilder

import java.io.Serializable

data class Work(var image:Int, var role: String, var company: String,var duration:String,var location:String):
    Serializable {

}
