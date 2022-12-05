package com.example.mycvbuilder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_project.*

class AddProjectActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_project)
    }
    fun cancel(view: View){
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
    fun submit(view: View){
        val title = p_title.text.toString().trim()
        val desc = p_description.text.toString().trim()

        if (title.isEmpty() || desc.isEmpty() ) {
            if (title.isEmpty())
                p_title.error = "Please enter project title"

            if (desc.isEmpty())
                p_description.error = "Please enter project description"

        } else {
            var project = Project(title,desc);
            val intent = Intent()
            intent.putExtra("project", project)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }
}