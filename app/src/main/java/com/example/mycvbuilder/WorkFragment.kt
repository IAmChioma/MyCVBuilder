package com.example.mycvbuilder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_work.*


class WorkFragment : Fragment() {
    lateinit var adapter: MyWorkAdapter



    var workExperiences: ArrayList<Work> = ArrayList<Work>(arrayListOf(
        Work( R.drawable.pwc,"Senior Software developer","PricewaterhouseCoopers (PwC)","Jul 2020 - Mar 2022","Lagos, Nigeria"),
        Work( R.drawable.dro,"Software engineer","DroHealth (DocsRchOut)","Mar 2020 - Jul 2020","Lagos, Nigeria"),
        Work( R.drawable.nvivo,"Senior Software developer","Envivo Communications Limited","Sep 2019 - March 2020","Lagos, Nigeria"),
        Work( R.drawable.sid,"Software developer","SecureID Limited","Feb 2018 - Sep 2019","Lagos, Nigeria"),
        Work( R.drawable.payit,"Software developer","PayIt Consulting","Feb 2017 - Dec 2017","Abuja, Nigeria")
    ))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ct = context;
        rv.layoutManager = LinearLayoutManager(context)
        // Create an object for the MyWorkAdapter
        adapter = MyWorkAdapter(ct, workExperiences)
        // Set adapter to your RecyclerView
        rv.adapter = adapter

        var resultContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {

                    var temp = it.data?.getSerializableExtra("work")
                    val work = temp as Work
                    addListItem(adapter, work)
                    Toast.makeText(context, "Experience with ${work.company} added successfully.", Toast.LENGTH_LONG).show()
                }
            }
                fabWork.setOnClickListener { view ->
                    val intent = Intent(view.context, AddWorkExperienceActivity::class.java)
                    resultContracts.launch(intent)
                }
            }


    fun addListItem(adapter: MyWorkAdapter,work:Work) {
        workExperiences.add(work)
        adapter.notifyDataSetChanged()
    }


  }