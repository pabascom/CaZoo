package phil.homework.week2day1zoo.activity

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import phil.homework.week2day1zoo.BaseActivity
import phil.homework.week2day1zoo.R

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        fab.setOnClickListener { startActivity(Intent(applicationContext, AnimalTypesListActivity::class.java)) }
    }
}
