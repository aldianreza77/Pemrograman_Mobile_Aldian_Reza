package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityNavigationDrawerBinding
import de.hdodenhof.circleimageview.CircleImageView

class NavigationDrawerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationDrawerBinding

    private lateinit var profilecircleImageView : CircleImageView
    private var profileImage = "https://lh3.googleusercontent.com/pw/AIL4fc_Q82I8tjVjE7lTTtDz61Sky7pvuRT4a_nj1MQumKBDVSTDkjkA6XCDPvWogSVegn1l2EoHYwLDBcOYGWIKjyDXAuzOxc-YdJSqArhL9pAX9pKpKx-qApSdQzK-IjGJE5DH4Pafd1wi2OIlp5IsMJsmbE3WBHu_AT41ITFS4qriu-VtH_4EPJ8Y4PXKXXvulgoaF4yb7vnQdDQ0iCDQCZUU7vVX_6T8tSbkHG0VMx2qk8gn0XUrNzz76XcCUX2J-ynaax2T3E6MgqndHBYPS4ab8Efdvt11Q4MlvrLGdg-5wJSuH8eTqPCts-28fTmIjQHS_ImwnbQc7Qmj58eTCfcrmW--opG1uJP-anxI9Do5P5Rxo637BIRuc6OqLqB88Ww7E88UXi5-SQlydtyXJgbDwkjUaT6U3H74ICd4IdVgNSIm9fU4Wyh5c4OFjuJCQaZvxSsnCMGDzlaoTVapMrcKcFAre5l8ktYPGUXGThv_V6n-2orSVHixKTQRuIYmCVtA66SHRbPkomKdWdrrcIiQYfSOnmmSZFgwr16SsBczXM1gzvd-LlQjeSa4Khvc-ZsIfx9Zs8J9EjIJy86xLEay3OA_j2CWypaM__9kwQ_NiK3aquz7IYKmCwTiptCs4HyCP2Yp0fbqqvDxWhpj6SYQDyumVPKv5ZNTT_0nCNLT2RML0IMkcf1ejq3PqW5sF3N5ja1yV9VbvoI73G8iOQGl8sDQQ3c-sMAbqnAUlYZrVixDZ-WZGdguwlF8ZBiyLGjGlxIZwaQDEbvDGPes0G-4hteRvlcHmlQixCh_HFBgYjY7DiWGzJdItS0Y0uclu77-El_Q_ddwuZy4org74wWFwuSueRTUrNTVwpG5f97VQ3_vDH_U2VC0ni9drWIiqRqgL1bGXfeT5gAofYlCBw=w360-h480-s-no?authuser=0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar)

        binding.appBarNavigationDrawer.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView


        profilecircleImageView = navView.getHeaderView(0).findViewById(R.id.imageView)

        Glide.with(this).load(profileImage).into(profilecircleImageView)

        val navController = findNavController(R.id.nav_host_fragment_content_navigation_drawer)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_chart,R.id.nav_pengalaman,R.id.nav_riwayat,R.id.nav_profile
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation_drawer)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}