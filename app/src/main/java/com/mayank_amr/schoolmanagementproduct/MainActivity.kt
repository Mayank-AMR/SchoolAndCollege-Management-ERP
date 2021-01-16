package com.mayank_amr.schoolmanagementproduct

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() /* , KodeinAware */ {
    //override val kodein by kodein()

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration =
            AppBarConfiguration(          // Configuring appBar like homeFragment and
                setOf(                    // FeesFragment are at same level in stack so
                    R.id.homeFragment,    // if we select home or fees in bottom menu no back perform.
                    R.id.feesFragment,    // Simply remove back arrow from toolbar.
                    R.id.myClassesFragment,
                    R.id.announcementsFragment
                ),
                drawer_layout_main        // It enables hamburger icon in main toolbar and animate for back arrow.
            )

        setSupportActionBar(main_activity_toolbar)
        setupActionBarWithNavController(
            navController,                // Attaching navController with actionbar
            appBarConfiguration           // Attaching appBarConfiguration with actionbar
        )

        bottomNavigationView.setupWithNavController(navController) // Connecting BottomNavigationView to navController
        navigation_view_main.setupWithNavController(navController) // Connecting NavigationDrawableView to navController

//        assignment_button.setOnClickListener(View.OnClickListener {
//            Intent(this, AssignmentActivity::class.java).also {
//                it.flags =
//                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_TASK_ON_HOME// no other activity in stack bz of Flag
//                startActivity(it)
//            }
//        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu_main, menu)
        //return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.terms_and_condition_menu_item) {
            val action = MainNavGraphDirections.actionGlobalTermsAndConditionsFragment()
            // MainNavGraphDirections and actionGlobalTermsAndConditionsFragment() both are generated according to the id that are assign in Graph
            navController.navigate(action)
            true
        } else {
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun onBackPressed() {
        if (drawer_layout_main.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_main.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
