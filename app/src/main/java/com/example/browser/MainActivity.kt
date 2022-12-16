package com.example.browser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.example.browser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ws: WebSettings = binding.webView.settings
        ws.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()

        binding.webView.loadUrl("https://www.google.com")

        binding.imageSearch.setOnClickListener {
            binding.webView.loadUrl("https://www.google.com/search?q=${binding.urlText.text}&oq=&sourceid=chrome&ie=UTF-8")
        }

        binding.imageRestart.setOnClickListener {
            binding.webView.loadUrl("https://www.google.com/search?q=12391047-43690-1236123867123-53436346243-12313213-534&oq=&sourceid=chrome&ie=UTF-8")
            binding.webView.loadUrl("https://www.google.com/search?q=${binding.urlText.text}&oq=&sourceid=chrome&ie=UTF-8")
        }
    }
    override fun onBackPressed() {
        if (binding.webView.canGoBack()){
            binding.webView.goBack()
        }
        else
            super.onBackPressed()
    }
}