package rios.cecilia.digimind.ui.home

import Task
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.task_view.view.*
import rios.cecilia.digimind.R

class HomeFragment : Fragment() {
    var tasks=ArrayList<Task>()
    private var adaptador: AdaptadorTareas?=null
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        fillTask()

        adaptador= AdaptadorTareas(root.context,tasks)
        root.gridview.adapter=adaptador

        return root
    }

    fun fillTask(){
        tasks.add(Task("Practice 1", arrayListOf("Tuesday"),"17:30"))
        tasks.add(Task("Practice 2", arrayListOf("Monday", "Sunday"),"17:00"))
        tasks.add(Task("Practice 3", arrayListOf("Wednesday"),"14:00"))
        tasks.add(Task("Practice 4", arrayListOf("Saturday"),"11:00"))
        tasks.add(Task("Practice 5", arrayListOf("Friday"),"13:00"))
        tasks.add(Task("Practice 6", arrayListOf("Thursday"),"10:40"))
        tasks.add(Task("Practice 7", arrayListOf("Monday"),"12:00"))

    }

    class AdaptadorTareas: BaseAdapter {

        var tasks = ArrayList<Task>()
        var contexto: Context? = null

        constructor(context: Context, tasks: ArrayList<Task>){
            this.contexto = context
            this.tasks = tasks
        }


        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var task=tasks[p0]
            var inflador=LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.task_view,null)

            vista.tv_tittle.setText(task.tittle)
            vista.tv_time.setText(task.time)
            vista.tv_days.setText(task.days.toString())

            return vista
        }

        override fun getItem(p0: Int): Any {
            return tasks[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return tasks.size
        }

    }

}