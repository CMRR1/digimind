package rios.cecilia.digimind.ui.dashboard

import Task
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.et_task
import rios.cecilia.digimind.R
import rios.cecilia.digimind.ui.home.HomeFragment

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    var tasks: Task? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        dashboardViewModel.text.observe(this, Observer {
//            textView.text = it
//        })


    root.btn_save.setOnClickListener{
        var title=et_task.text.toString()
        var time=btn_time.text.toString()
        var days=ArrayList<String>()

    if (checkMonday.isChecked)
        days.add("Monday")
    if (checkTuesday.isChecked)
        days.add("Tuesday")
    if (checkWednesday.isChecked)
        days.add("Wedsnesday")
    if (checkThursday.isChecked)
        days.add("Thursday")
    if(checkFriday.isChecked)
        days.add("Friday")
    if (checkSatuday.isChecked)
        days.add("Saturday")
    if (checkSunday.isChecked)
        days.add("Sunday")

    var task=Task(title, days, time)
    HomeFragment.tasks.add(task)
    Toast.makeText(root.context,"New task added", Toast.LENGTH_SHORT).show()
    }
        return root}
}