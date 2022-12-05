package com.example.mycvbuilder

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val myPageAdapter= MyPageAdapter(this)
        pager.adapter = myPageAdapter
        tab_layout.tabGravity = TabLayout.GRAVITY_FILL
        TabLayoutMediator(tab_layout,pager){tab,position ->
            when(position){
                0->{
                    tab.text="Home"
                    tab.setIcon(R.drawable.home)
                }
                1->{
                    tab.text="AboutMe"
                    tab.setIcon(R.drawable.about)
                }
                2->{
                    tab.text="Work"
                    tab.setIcon(R.drawable.work)
                }
                3->{
                    tab.text="Contact"
                    tab.setIcon(R.drawable.contact)
                }
                4->{
                    tab.text="Project"
                    tab.setIcon(R.drawable.project)
                }

            }
        }.attach()



    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean {

        return when (item.itemId) {
            R.id.linkedIn -> {
                showToast(item)
                showWebLinkedInIntent(item)
                true}
            R.id.whatsapp -> {
                showToast(item)
                showWhatsappIntent(item)
                true }
            R.id.gmail -> {
                showToast(item)
                showEmailIntent(item)
                return true}
            R.id.telegram -> {
                showToast(item)
                showWebTelegramInIntent(item)
                return true}
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showToast(item: MenuItem) {
        Toast.makeText(
            applicationContext,
            item.title.toString(),
            Toast.LENGTH_LONG
        ).show()
    }
    private fun showEmailIntent(item: MenuItem) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("cigbokwe@miu.edu"))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello Chioma")
        mIntent.putExtra(Intent.EXTRA_TEXT, "My CV App")
        startActivity(mIntent)
    }

    private fun showWhatsappIntent(item: MenuItem) {
        val whatsAppAppId = "com.whatsapp"
        try {
            intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.`package`= whatsAppAppId
            startActivity(Intent.createChooser(intent, "Finish the action with:"));

        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(this,"Whatsapp not found",Toast.LENGTH_LONG ).show()
            finish()
        }

    }


    private fun showWebTelegramInIntent(item: MenuItem) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url","https://web.telegram.org/")
        intent.putExtra("title","Telegram")
        startActivity(intent)

    }

    private fun showWebLinkedInIntent(item: MenuItem) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url","https://www.linkedin.com/in/chioma-peace-igbokwe/")
        intent.putExtra("title","LinkedIn")
        startActivity(intent)

    }
    private fun showWebWhatsappInIntent(item: MenuItem) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url","https://wa.me/+2349029558581")
        intent.putExtra("title","Whatsapp")
        startActivity(intent)

    }
}