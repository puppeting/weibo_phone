package com.pzbao.microphoto.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.navigation.NavigationView
import com.jaeger.library.StatusBarUtil
import com.pzbao.microphoto.R
import com.pzbao.microphoto.base.BaseActivity
import com.pzbao.microphoto.databinding.ActivityMain3Binding
import com.pzbao.microphoto.ui.gallery.LiveFragment
import com.pzbao.microphoto.ui.home.HomeFragment
import com.pzbao.microphoto.ui.slideshow.MineFragment
import com.pzbao.microphoto.ui.sucai.SuCaiFragment
import com.pzbao.microphoto.utils.SZWUtils

@Route(path = "/com/MainActivity")
class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain3Binding

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = findViewById<View>(com.pzbao.microphoto.R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        setSupportActionBar(binding.appBarMain.toolbar)
//        hideSystemUI(this)
//        val drawerLayout: DrawerLayout = binding.drawerLayout
//        val navView: NavigationView = binding.navView
//        val navController = findNavController(com.pzbao.microphoto.R.id.nav_host_fragment_content_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                com.pzbao.microphoto.R.id.nav_home, com.pzbao.microphoto.R.id.nav_gallery, com.pzbao.microphoto.R.id.nav_slideshow
//            ), drawerLayout
//        )
//        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
//        val toggle = ActionBarDrawerToggle(
//            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
//        )
//        drawer.setDrawerListener(toggle)
//        toggle.syncState()
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//        binding.appBarMain.fab.setOnClickListener { view ->
//            val drawer = findViewById<View>(com.pzbao.microphoto.R.id.drawer_layout) as DrawerLayout
//             drawer.openDrawer(Gravity.START);
//
//        }
//        binding.navView.setNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.nav_slideshow -> {
//                    Log.e("ddd","qqqq")
//                    SZWUtils.showSnakeBarSuccess("nav_slideshow")
//                }
//                R.id.nav_gallery -> {
//                    Log.e("ddd","qqqq")
//
//                    SZWUtils.showSnakeBarSuccess("nav_gallery")
//                }
//                R.id.nav_home -> {
//                    Log.e("ddd","qqqq")
//
//                    SZWUtils.showSnakeBarSuccess("nav_home")
//                }
//            }
//            drawerLayout.closeDrawers();
//            false;
//        };

//        var  onDestinationChangedListener = NavController
//            .OnDestinationChangedListener { _, destination, _ ->
//                Log.e("lzp", destination.label.toString()+destination.id+destination.navigatorName)
//
//
//            }
//        navController?.addOnDestinationChangedListener(onDestinationChangedListener)
        StatusBarUtil.setColor(this,getResources().getColor(R.color.home_lan),0)
        val stateView = window.decorView

        if (stateView != null) {
            var vis = stateView.systemUiVisibility
            //vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //黑色
            vis = vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() //白色
            stateView.systemUiVisibility = vis //设置状态栏字体颜色
        }
        supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment_content_main,HomeFragment()).commit()
//        navView.setNavigationItemSelectedListener(this);
        binding?.appBarMain?.button?.linearHome?.setOnClickListener(View.OnClickListener { view: View? ->
            StatusBarUtil.setColor(this,getResources().getColor(R.color.home_lan),0)
            setPager(0)
        })//首页


        binding?.appBarMain?.button?.linearOrder?.setOnClickListener(View.OnClickListener { view: View? ->
            StatusBarUtil.setColor(this,getResources().getColor(R.color.white),0)

            setPager(1)

        })//直播
        binding?.appBarMain?.button?.linearSuicai?.setOnClickListener(View.OnClickListener { view: View? ->
            StatusBarUtil.setColor(this,getResources().getColor(R.color.bg_color),0)
            setPager(2)

        })
        binding?.appBarMain?.button?.linearMine?.setOnClickListener(View.OnClickListener { view: View? ->
            StatusBarUtil.setColor(this,getResources().getColor(R.color.mine_lan),0)

            setPager(3)

        })
    }
    override fun onBackPressed() {
//        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
    }
    private fun setPager(i: Int) {
        binding?.appBarMain?.button?.ivButtonHome?.setBackgroundResource(R.mipmap.home_no)
        binding?.appBarMain?.button?.tvButtonHome?.setTextColor(resources.getColor(R.color.color_333))
        binding?.appBarMain?.button?.ivButtonLiaotian?.setBackgroundResource(R.mipmap.live_no)
        binding?.appBarMain?.button?.tvButtonLiaotian?.setTextColor(resources.getColor(R.color.color_333))
        binding?.appBarMain?.button?.ivButtonMine?.setBackgroundResource(R.mipmap.mine_no)
        binding?.appBarMain?.button?.tvButtonMine?.setTextColor(resources.getColor(R.color.color_333))
        binding?.appBarMain?.button?.ivButtonSuicai?.setBackgroundResource(R.mipmap.suicai_no)
        binding?.appBarMain?.button?.tvButtonSucai?.setTextColor(resources.getColor(R.color.color_333))
        if (i == 0) {
            val stateView = window.decorView
            if (stateView != null) {
                var vis = stateView.systemUiVisibility
                //vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //黑色
                vis = vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() //白色
                stateView.systemUiVisibility = vis //设置状态栏字体颜色
            }
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,HomeFragment()).commit()
            binding?.appBarMain?.button?.ivButtonHome?.setBackgroundResource(R.mipmap.home_pre)
            binding?.appBarMain?.button?.tvButtonHome?.setTextColor(resources.getColor(R.color.colorzise))
        } else if (i == 1) {
            val stateView = window.decorView
            if (stateView != null) {
                var vis = stateView.systemUiVisibility
                vis = vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv(); //黑色
//                vis = vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() //白色
                stateView.systemUiVisibility = vis //设置状态栏字体颜色
            }
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,LiveFragment()).commit()
            binding?.appBarMain?.button?.ivButtonLiaotian?.setBackgroundResource(R.mipmap.live_pre)
            binding?.appBarMain?.button?.tvButtonLiaotian?.setTextColor(resources.getColor(R.color.colorzise))
        } else if (i == 2) {
            val stateView = window.decorView
            if (stateView != null) {
                var vis = stateView.systemUiVisibility
                vis = vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv(); //黑色
//                vis = vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() //白色
                stateView.systemUiVisibility = vis //设置状态栏字体颜色
            }
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,SuCaiFragment()).commit()

            binding?.appBarMain?.button?.ivButtonSuicai?.setBackgroundResource(R.mipmap.suicai_pre)
            binding?.appBarMain?.button?.tvButtonSucai?.setTextColor(resources.getColor(R.color.colorzise))

        }else if (i == 3) {
            val stateView = window.decorView
            if (stateView != null) {
                var vis = stateView.systemUiVisibility
                //vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //黑色
                vis = vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() //白色
                stateView.systemUiVisibility = vis //设置状态栏字体颜色
            }
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main,MineFragment()).commit()
            binding?.appBarMain?.button?.ivButtonMine?.setBackgroundResource(R.mipmap.mine_pre)
            binding?.appBarMain?.button?.tvButtonMine?.setTextColor(resources.getColor(R.color.colorzise))

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun initToolbar() {

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_slideshow -> {
                Log.e("ddd","qqqq")
                SZWUtils.showSnakeBarSuccess("nav_slideshow")
            }
            R.id.nav_gallery -> {
                Log.e("ddd","qqqq")

                SZWUtils.showSnakeBarSuccess("nav_gallery")
            }
            R.id.nav_home -> {
                Log.e("ddd","qqqq")

                SZWUtils.showSnakeBarSuccess("nav_home")
            }
        }
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}

