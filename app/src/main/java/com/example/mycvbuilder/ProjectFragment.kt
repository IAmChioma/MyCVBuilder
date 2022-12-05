package com.example.mycvbuilder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_project.*

class ProjectFragment : Fragment() {
    lateinit var adapter: ArrayAdapter<String>
    var projects: ArrayList<Project> = ArrayList<Project>(arrayListOf(
        Project("Library Management System, MIU (2022)","Collaborated with team of 2 to develop application and implement\n" +
                "user registration / login into application. Enabled library member registration, book addition, check out, and\n" +
                "records of overdue books. Technologies Used: Java, JavaFX, GitHub, Eclipse IDE, In-Memory Database."),
         Project("Personal Hobby Project (PHP), MIU (2022)","Created video game to simulate volleyball game. Technologies\n" +
                 "Used: MongoDB, Express.js, Angular, Node (MEAN) Stack for Development."),
         Project("Job Search Application, MIU (2022)","Created job searching system by modeling 5-layer architecture to develop\n" +
                 "RESTful APIs and configure Spring and Hibernate for persistence. Technologies Used: Spring Boot, REST\n" +
                 "Framework, Spring, Hibernate, ActiveMQ Artemis, Spring ActiveMQ, Mockito"),

    ))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ArrayAdapter<String>(view.context,android.R.layout.simple_spinner_dropdown_item, projects.map{ x->x.title })
        lv.adapter = adapter

        lv.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(view.context,projects[position].title,Toast.LENGTH_SHORT).show()
                val builder = AlertDialog.Builder(view.context)

                builder.setTitle("Project Info")
                builder.setMessage(projects[position].title + "\n" +  projects[position].description)
                builder.setIcon(R.drawable.info)

                builder.setNegativeButton("Cancel"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }

                val dialog: AlertDialog = builder.create()
                dialog.show()

            }

        var resultContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {

                var temp = it.data?.getSerializableExtra("project")
                val project = temp as Project
                addProjectItem(project)
                Toast.makeText(context, " Project ${project.title} added successfully.", Toast.LENGTH_LONG).show()
            }
        }
        fabProject.setOnClickListener {
            val intent = Intent(view.context, AddProjectActivity::class.java)
            resultContracts.launch(intent)
        }
    }


    fun addProjectItem(project:Project) {
        projects.add(project)
        adapter.clear()
        for (p in projects) {
            adapter.insert(p.title, this.adapter.count)
        }
        this.adapter.notifyDataSetChanged()
    }

}