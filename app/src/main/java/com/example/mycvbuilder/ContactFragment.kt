package com.example.mycvbuilder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contact.*


class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        address_detail.setOnClickListener{
            showAddressOnMapIntent();
        }
        mobile_detail.setOnClickListener{
            showPhoneIntent();
        }
        email_detail.setOnClickListener{
            showEmailIntent();
        }
        github_detail.setOnClickListener{
            showWebGitHubInIntent();
        }
        linkedIn_detail.setOnClickListener{
            showWebLinkedInIntent();
        }
        twitter_detail.setOnClickListener{
            showWebTwitterInIntent();
        }
        facebook_detail.setOnClickListener{
            showWebFacebookInIntent();
        }
    }

    private fun showAddressOnMapIntent() {
        val uri = Uri.parse("geo:41.006950,-91.973419")
        val aIntent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(aIntent)
    }

    private fun showPhoneIntent() {
        val mIntent = Intent(Intent.ACTION_DIAL)
        mIntent.data = Uri.parse("tel:6418192445")
        startActivity(mIntent)
    }
    private fun showEmailIntent() {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("cigbokwe@miu.edu"))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello Chioma")
        mIntent.putExtra(Intent.EXTRA_TEXT, "My CV App")
        startActivity(Intent.createChooser(mIntent, "Choose application to send Email...."))
    }



    private fun showWebLinkedInIntent() {
        val intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra("url","https://www.linkedin.com/in/chioma-peace-igbokwe/")
        intent.putExtra("title","LinkedIn")
        startActivity(intent)

    }
    private fun showWebGitHubInIntent() {
        val intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra("url","https://github.com/IAmChioma")
        intent.putExtra("title","Github")
        startActivity(intent)

    }
    private fun showWebFacebookInIntent() {
        val intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra("url","https://www.facebook.com/Chioma.Peace.Uche")
        intent.putExtra("title","Facebook")
        startActivity(intent)

    }
    private fun showWebTwitterInIntent() {
        val intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra("url","https://twitter.com/chiomzy_peace")
        intent.putExtra("title","Twitter")
        startActivity(intent)

    }
    }