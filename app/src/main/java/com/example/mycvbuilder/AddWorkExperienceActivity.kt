package com.example.mycvbuilder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_work_experience.*


class AddWorkExperienceActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work_experience)
    }
    fun cancel(view: View){
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
    fun submit(view: View){

        val role = job_role.text.toString().trim()
        val comp = company.text.toString().trim()
        val duration = job_duration.text.toString().trim()
        val location = job_location.text.toString().trim()

        if (role.isEmpty() || comp.isEmpty() || duration.isEmpty() || location.isEmpty()) {
            if (role.isEmpty())
                job_role.error = "Please enter Job Role"

            if (comp.isEmpty())
                company.error = "Please enter Company name"

            if (location.isEmpty())
                job_location.error = "Please enter Job Location"

            if (duration.isEmpty())
                job_duration.error = "Please enter Job duration"
        } else {
            var work = Work(R.drawable.work,role,comp,duration,location);
            val intent = Intent()
            intent.putExtra("work", work)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }

}